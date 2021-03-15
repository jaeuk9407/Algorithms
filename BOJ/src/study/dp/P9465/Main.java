package study.dp.P9465;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, T;
	static int dp[][], stickers[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int testCase = 0; testCase < T; testCase++) {
			N = Integer.parseInt(br.readLine());
			dp = new int[3][N];
			stickers = new int[2][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				stickers[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				stickers[1][i] = Integer.parseInt(st.nextToken());
			}
			
			int result =solve();
			System.out.println(result);
		}
		
	}
	static int solve() {
		
		dp[0][0] = 0;
		dp[1][0] = stickers[0][0];
		dp[2][0] = stickers[1][0];
		
		for(int index = 1; index < N; index++) {
			dp[0][index] = Math.max(dp[1][index-1], dp[2][index - 1]);
			dp[1][index] = Math.max(dp[0][index-1], dp[2][index - 1]) + stickers[0][index];
			dp[2][index] = Math.max(dp[0][index-1], dp[1][index - 1]) + stickers[1][index];
		}
		
		int result = Math.max(dp[0][N-1], Math.max(dp[1][N-1], dp[2][N-1]));
//		System.out.println(dp[0][N-1]+","+dp[1][N-1]+","+dp[2][N-1]);
		
		return result;
	}
}
