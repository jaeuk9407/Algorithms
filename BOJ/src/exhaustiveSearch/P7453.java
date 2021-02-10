package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. 배열 두 개씩 묶어 합을 저장하는 ArrayList 사용 => Collections.sort의 성능 문제
// https://www.acmicpc.net/board/view/50851

// 2. N = 1인 경우 예외 처리
// 3. ans Integer => Long 자료형 변환

public class P7453 {
	
	static int[] A, B, C, D;
	static int[] leftArr, rightArr; // 배열 두 개의 합을 모은 Array
	static int N;
	static long ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		
		leftArr = new int[N*N];
		rightArr = new int[N*N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		makeSum(A, B, leftArr);
		makeSum(C, D, rightArr);
		
		Arrays.sort(leftArr);
		Arrays.sort(rightArr);
		
		ans = 0;
		calcAns();
		
		System.out.println(ans);
		
	}
	// 두 배열에서 원소를 하나씩 뽑아 만들 수 있는 합의 모든 경우를 list에 담아줌
	private static void makeSum(int[] arr1, int[] arr2, int[] whereArr) {
		int index = 0;
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				whereArr[index] = arr1[i] + arr2[j];
				index++;
			}
		}
	}
	
	private static void calcAns() {
		int left = 0;
		int right = rightArr.length - 1;
		while(left < leftArr.length && right >= 0) {
			int lv = leftArr[left];
			int rv = rightArr[right];
			
			if(lv + rv == 0) {
				int lc = 0;
				while(true) {
					// N = 1인 경우 outOfBounds를 피해주기 위한 예외처리
					if(left == leftArr.length) break;
					if(leftArr[left] == lv) {
						lc++;
						left++;
					}else {
						break;
					}
				}
				
				int rc = 0;
				while(true) {
					// N = 1인 경우 outOfBounds를 피해주기 위한 예외처리 
					if(right < 0) break;
					if(rightArr[right] == rv) {
						rc++;
						right--;
					}else {
						break;
					}
				}
				ans += (long)lc * (long)rc;
			}
			else if(lv + rv < 0) left++;
			else if(lv + rv > 0) right--;
		}
	}
}
