package study.dp.P11052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static long dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1];
		dp = new long[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		
		for(int i = 2; i <= N; i++) {
			// N장짜리 카드팩 or 1장짜리 카드팩 N장 
			dp[i] = Math.max(dp[i - 1] + arr[1], arr[i]);
			
			for(int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[j] + arr[i - j], dp[i]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
