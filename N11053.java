package dp;

import java.util.Scanner;

public class N11053 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int array[] = new int[n+1];
		int dp[] = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			array[i] = sc.nextInt();
		}
		sc.close();
		
		dp[1]=1;
		
		for(int i=2; i<=n; i++) {
			dp[i] =1;
			for(int j=1; j<i;j++) {
				if(array[i]>array[j] &&dp[i] <=dp[j]) {
					dp[i] = dp[j]+1;
				}else if(array[i] == array[j]) {
					dp[i] =dp[j];
				}
			}
		}
		int max = 0;
		for(int i=1; i<=n; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}

}
