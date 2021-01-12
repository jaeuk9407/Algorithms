package DAY02.P2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainSolution {
	static int N, M;
	static int[] Trees;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Trees = new int[N + 1];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			Trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(Trees[i], max);
		}
		
		long start = 0, mid = 0, end = max, result = 0;
		
		while(true) {
			mid = (start + end) / 2;
			long sum = calc(mid); // 수확 가능한 나무의 양
			
			// sum == M -> 정답 반환
			if(sum == M) {
				result = mid;
				break;
			}
			// sum < M -> 높이를 낮춘다
			else if(sum < M) {
				end = mid - 1;
			}
			// sum > M -> 높이를 높인다
			else {
				result = mid;
				start = mid + 1;
			}
			if(start > end) {
				break;
			}
		}
		System.out.println(result);
	}
	
	static long calc(long value) {
		long result = 0;
		for (int t:Trees) {
			if(t > value) {
				result += t - value;
			}
		}
		return result;
	}
}
