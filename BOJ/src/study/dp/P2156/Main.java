package study.dp.P2156;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int wine[];
	static int dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wine = new int[N + 1];
		dp = new int[N + 1];
		
		for(int i = 0; i < N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		int result = solve();
		System.out.println(result);
		
	}
	
	private static int solve() {
		if(N==1) {
			return wine[0];
		}else if(N==2) {
			return wine[0]+wine[1];
		}else {
			dp[0] = wine[0];
			dp[1] = dp[0]+wine[1];
			dp[2] = Math.max(dp[1], Math.max(wine[0]+ wine[2], wine[1]+wine[2]));
			
			for(int i=3; i<N; i++) {
				dp[i] = Math.max(dp[i-3]+wine[i]+wine[i-1], dp[i-2]+wine[i]);
				dp[i] = Math.max(dp[i-1], dp[i]);
			}
			return dp[N-1];
		}
		
	}
}
