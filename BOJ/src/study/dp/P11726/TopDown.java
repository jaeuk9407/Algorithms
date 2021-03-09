package study.dp.P11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TopDown {
	// Top Down
	static int N;
	static int dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		solve(N);
		
		System.out.println(dp[N]);
	}
	
	static int solve(int num) {
		// 한 번 구해놓은 답이라면 더 연산 수행하지 않고 저장된 값 사용 -> Memoization
		if(dp[num] != 0) {
			return dp[num];
		}
		
		dp[num] = solve(num - 1) + solve(num - 2);
		dp[num] %= 10007;
		
		return dp[num];
	}

}
