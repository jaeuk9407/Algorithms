package dp;

import java.util.Scanner;

public class N11722 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int dp[] = new int[n+1];
		
		for(int i=1; i<=n;i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(arr[i]<arr[j] && dp[i]<=dp[j]) {
					dp[i]= dp[j]+1;
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
