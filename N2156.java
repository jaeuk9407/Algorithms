package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2156 {

	static int dp[];
	static int array[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n];
		array= new int[n];
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		System.out.println(calculate(n));
	}
	
	public static int calculate(int n) {
		if(n==1) {
			return array[0];
		}else if(n==2) {
			return array[0]+array[1];
		}else {
			dp[0] = array[0];
			dp[1] = dp[0]+array[1];
			dp[2] = Math.max(dp[1], Math.max(array[0]+ array[2], array[1]+array[2]));
			
			for(int i=3; i<n; i++) {
				dp[i] = Math.max(dp[i-3]+array[i]+array[i-1], dp[i-2]+array[i]);
				dp[i] = Math.max(dp[i-1], dp[i]);
			}
			return dp[n-1];
		}
		
	}

}
