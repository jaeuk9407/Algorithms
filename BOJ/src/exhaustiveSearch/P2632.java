package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 참조 : https://kohen.tistory.com/20
public class P2632 {
	static int M, N, S;
	static int[] A, B;
	static int ans;
	static boolean check[];
	static ArrayList<Integer> AList = new ArrayList<>();
	static ArrayList<Integer> BList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		A = new int[M];
		B = new int[N];
		
		for(int i = 0; i<M; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 0; i < M; i++) {
			// check배열 초기화
			check = new boolean[M];
			// 첫 번째 조각 담기  
			check[i] = true;
			getSum(A[i], i, i+1, check, A, AList);
			
		}
		
		for(int i = 0; i < N; i++) {
			// check배열 초기화
			check = new boolean[N];
			// 첫 번째 조각 담기  
			check[i] = true;
			getSum(B[i], i, i+1, check, B, BList);
		}
		
		// 각각 전혀 사용되지 않는 경우 처리 
		AList.add(0);
		BList.add(0);
		
		
		Collections.sort(AList);
		Collections.sort(BList);
		
		getAns();
		
		System.out.println(ans);
		
	
		
		
	} // end of main
	

	// 부분합 구하기
	// 순환 큐 구현하듯이
	private static void getSum(int sum, int startIdx, int idx, boolean[] check, int[] arr, List list) {
		// 들어온 인덱스가 끝이면 원형이기 때문에 다시 0으로 처리
		if(idx == arr.length) idx = 0;
		
		list.add(sum);
		
		// 아직 안 담은 피자조각에 대해서만 판매함 && 마지막 인덱스 값을 계속 저장하지 않음 && 순열의 합이 이미 타겟을 넘어서면 계산하지 않음
		if(check[idx] == false && idx != startIdx -1 && sum <= S) {
			check[idx] = true;
			getSum(sum +arr[idx], startIdx, idx +1, check, arr, list);
		}else {
			return;
		}
	}
	
	// 투 포인터로 부분합들을 하나는 작은 수부터, 하나는 큰 수부터 더해보며 목표 수와 비교하며 ans 계산하기
	private static void getAns() {
		int leftIdx = 0;
		int rightIdx = BList.size() - 1;
		
		while(leftIdx < AList.size() && 0 <= rightIdx) {
			int lv = AList.get(leftIdx);
			int rv = BList.get(rightIdx);
			
			// 두 부분합의 합이 원하는 합과 동일한 경우
			if(lv + rv == S) {
				int lc = 0;
				while(leftIdx < AList.size() && AList.get(leftIdx) == lv) {
					lc++;
					leftIdx++;
				}
				
				int rc = 0;
				while(rightIdx >= 0 && BList.get(rightIdx) == rv) {
					rc++;
					rightIdx++;
				}
				
				ans += lc * rc;
			}else if(lv + rv < S) {
				// 두 부분합의 합이 원하는 합보다 작은 경우
				leftIdx++;
			}else {
				// 두 부분합의 합이 원하는 합보다 큰 경우
				rightIdx--;
			}
		}
	}
}
