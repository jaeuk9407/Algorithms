package study.dp.P1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IncorrectAnswer {
	static int N;
	static int dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		
		int ans = solve(N, 0);
		
		System.out.println(ans);
	}
	private static int solve(int num, int cnt) {
		
		// 도착지 -> 현재까지의 count 반환 
		if(num == 1) {
			return cnt;
		}
		
		// 현재 위치를 방문한 적이 있다면 최선의 값이 저장되어 있으므로 더 탐색하지 않음
		if(dp[num] != 0) {
			return dp[num];
		}
		
		// 가장 많이 탐색해도 N을 넘어가지 않음
		int result1 = N+1;
		int result2 = N+1;
		int result3 = N+1;
		
		// 1, 2, 3번 선택한 결과의 최선 결과를 저장
		if(num % 3 == 0) {
			result1 = solve(num/3, cnt+1);
		}
		if(num % 2 == 0) {
			result2 = solve(num/2, cnt+1);
		}
		
		result3 = solve(num-1, cnt+1);
		
		
		// 각 결과값을 비교해 그 중에서의 최솟값 선택하고 저장
		dp[num] = Math.min(result1, Math.min(result2, result3));
		
		//	현재 위치에서의 최솟값을 반환
		return dp[num];
	}
}
