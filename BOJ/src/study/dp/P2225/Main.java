package study.dp.P2225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static long dp[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new long[K + 1][N + 1];
		
		for(int n = 0; n <= N; n++) {
			dp[1][n] = 1;
		}
		
		for(int k = 0; k <= K; k++) {
			dp[k][0] = 1;
		}
		
		for(int i = 2; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
//				System.out.println(dp[i][j-1]+","+dp[i-1][j]);
			}
		}
		System.out.println(dp[K][N]);
		
	}

}
