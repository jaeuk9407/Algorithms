package dp;

import java.util.Scanner;

public class N1912{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		int dp[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		dp[0] = arr[0];
		
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
		}
		
		int max = -9999999;
		for(int i=0; i<n; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}
