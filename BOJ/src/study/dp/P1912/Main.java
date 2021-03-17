package study.dp.P1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[] dp, A;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = A[0];
		ans = Integer.MIN_VALUE;
		
		for(int i = 1; i < N; i++) {
			int continuity = dp[i - 1] + A[i];
			int newStart = A[i];
			
			dp[i] = Math.max(continuity, newStart);
		}
		
		for(int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[i]);
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(ans);
		
	}
}
