package sds.dataStructure.P2042;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int nums[];
	static long tree[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new int[N+1];
		tree = new long[N+1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			update(i, nums[i]);
		}
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// update 연산인 경우 
			if(a == 1) {
				update(b, c-nums[b]);
				nums[b] = c;
			}else {
				System.out.println(interval_sum(b, c));
			}
			
		}
		
		
	}
	
	// i번째 수까지의 누적 합을 계산하는 함수
	private static long prefix_sum(int index) {
		long result = 0;
		while(index > 0) {
			result += tree[index];
			// 0이 아닌 마지막 비트만큼 빼가면서 이동
			index -= (index & -index);
		}
		return result;
	}
	
	// i번째 수를 dif만큼 더하는 함수
	private static void update(int index, int dif) {
		while(index <= N) {
			tree[index] += dif;
			index += (index & -index);
		}
	}
	
	// start부터 end까지의 구간 합을 계산하는 함수
	private static long interval_sum(int start, int end) {
		return prefix_sum(end) - prefix_sum(start-1);
	}
	
}
