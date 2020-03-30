package dp;

import java.util.Scanner;

public class N11054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int dp[] = new int[n+1];
		int dp2[] = new int[n+1];
		
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] =1;
			for(int j =1; j<i; j++) {
				if(arr[i]>arr[j] && dp[i]<=dp[j]) {
					dp[i] = dp[j]+1;
				}
			}
		}

		dp2[n] =1;
		// inverse order
		for(int i=n-1; i>0; i--) {
			dp2[i] =1;
			for(int j=n; j>i; j--) {
				if(arr[i]>arr[j] && dp2[i]<=dp2[j]) {
					dp2[i] = dp2[j]+1;
				}
			}
		}
		int max =0;
		for(int i=1; i<=n; i++) {
			max = Math.max(dp[i]+dp2[i]-1, max);
		}
		
		System.out.println(max);

	}

}
