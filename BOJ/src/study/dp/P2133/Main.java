package study.dp.P2133;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		
		int answer = 0;
		if(N % 2 == 0) {
			dp[2] = 3;
			dp[0] = 1;
			
			for(int i = 4; i <= N; i += 2) {
				for(int j = 2; j <= i; j += 2) {
					int newShape = j == 2 ? 3 : 2;
					dp[i] += newShape * dp[i-j];
				}
			}
			answer = dp[N];
		}
		System.out.println(answer);
	}
}
