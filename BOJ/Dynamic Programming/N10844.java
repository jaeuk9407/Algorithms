package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int[][] dp = new int[101][11];
		
		for(int i =1; i<=9; i++) {
			dp[1][i] = 1; //n=1인 경우 정의
		}
		
		for(int i =2; i<=n;i++) {
			dp[i][0] = dp[i-1][1]; //n>=2인 경우 중 마지막 자리가 1인 개수
			for(int j=1; j<=9;j++) {
				dp[i][j] = (dp[i-1][j-1] +dp[i-1][j+1]) %1000000000; 
				// j=9 즉 마지막 자리가 9인 경우 [n-1][10]은 넣어주지 않았기 때문에 0이 연산된다. 
			}
		}
		long sum =0;
		for(int i=0; i<10; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum%1000000000);
	}

}
