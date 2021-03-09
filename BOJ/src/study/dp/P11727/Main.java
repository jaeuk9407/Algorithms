package study.dp.P11727;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	// Bottom Up
	static int N;
	static int dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		if(2 <= N) {
			for(int i = 2; i <= N; i++) {
				dp[i] = 2 * dp[i - 2] + dp[i - 1];
				dp[i] %= 10007;
			}
		}
		
		System.out.println(dp[N]);
	}

}
