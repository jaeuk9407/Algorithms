package dp;

import java.util.Scanner;

public class N1912_RuleofThumbs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int max=-9999999;
		int sum[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i>j) {
					sum[i][j] = -99999999;
				}
				else if(i == j) {
					sum[i][j] = arr[j];
				}
				else {
					sum[i][j] = sum[i][j-1]+arr[j];
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				max = Math.max(max, sum[i][j]);
			}
		}
		System.out.println(max);
	}

}
