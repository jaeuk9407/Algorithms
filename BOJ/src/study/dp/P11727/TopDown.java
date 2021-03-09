package study.dp.P11727;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TopDown {
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
		// 수행한 적 있는 수이면, 메모되어 있는 값을 이용!
		if(dp[num] != 0) {
			return dp[num];
		}else {
			// 처음 수행하는 수이면 수를 구하고 저장
			dp[num] = 2 * solve(num - 2) + solve(num - 1);
			dp[num] %= 10007;
			
			return dp[num];
		}
	}
}
