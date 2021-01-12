package DAY02.P2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] Trees;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			Trees[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxHeight = Trees[0];
		for(int i = 0; i < N-1; i++) {
			maxHeight = Math.max(maxHeight, Trees[i+1]);
		}
		
		// M의 범위가 최대 20억, 단일 나무의 높이 10억, 나무의 개수 100만으로 수가 매우 큰 상황에서 int를 사용하면 값이 제대로 계산되지 않음
		long woods = 0, mid = maxHeight / 2, low = 0, high = maxHeight, result = 0;
		int pt = 0;
		
		while(true) {
			pt = 0;
			woods = 0;
			// 해당 높이 벌목 결과 목재량 계산 
			while(pt < N) {
				if(Trees[pt] > mid) {
					woods += Trees[pt] - mid;
				}
				pt++;
			}
			
			if(woods == M) {
				//목재량이 알맞은 경우
				result = mid;
				break;
			}else if(woods > M) {
				// 목재량이 목표를 초과한 경우
				low = mid;
				mid = (low + high) / 2;
			}else {
				// 목재량이 부족한 경우
				high = mid;
				mid = (low + high) / 2;
			}
			
			// 목재량을 정확히 맞출 수 없는 케이스 처리
			if(low == mid) {
				result = mid;
				break;
			}
		}
		
		System.out.println(result);
		
	}
}
