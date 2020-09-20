package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		long dp[][] = new long[91][2];
		br.close();
		
		dp[1][1] = 1;
		dp[2][0] = 1;
		
		for(int i=3;i<n+1;i++) {
			for(int j =0; j<2; j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][0] + dp[i-1][1];
				}
				else {
					dp[i][j] = dp[i-1][0];
				}
			}
		}
		
		long sum = dp[n][0] + dp[n][1];
		System.out.println(sum);
		
		
		
	}

}
