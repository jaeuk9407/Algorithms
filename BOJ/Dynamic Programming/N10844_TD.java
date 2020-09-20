package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10844_TD {

	public static int mod = 1000000000;
	public static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		dp = new long[n+1][10];
		long sum=0;
		
		for(int l=1; l<=9; l++) {
			sum += calculate(n, l);
		}
		System.out.println(sum%mod);
		
	}
	public static long calculate(int n, int l) {
		if(n==1) {
			return 1;
		}
		if(dp[n][l]>0) {
			return dp[n][l];
		}
		
		if(l==0) {
			dp[n][l] = calculate(n-1, 1);
		}
		else if(l==9) {
			dp[n][l] = calculate(n-1,8);
		}
		else {
			dp[n][l] = calculate(n-1, l-1) + calculate(n-1, l+1);
		}
		return dp[n][l]%mod;
	}

}
