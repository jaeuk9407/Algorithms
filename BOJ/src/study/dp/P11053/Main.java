package study.dp.P11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int A[];
	static int ans;
	static int dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		
	
		dp[0] = 1;
		for(int i = 1; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(A[i] > A[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(ans);
	}
}
