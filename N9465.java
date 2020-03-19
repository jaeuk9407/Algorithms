package dp;

import java.util.Scanner;

public class N9465 {

	static long data[][];
	static long d[][];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testn = sc.nextInt();
		int n;
		
		for(int i=0; i<testn; i++) {
			n= sc.nextInt();
			long data1[] = new long[n];
			long data2[] = new long[n];
			data = new long[2][n+1];
			
			for(int j=0; j<n;j++) {
				data1[j] = sc.nextLong();
			}
			for(int j=0; j<n;j++) {
				data2[j] = sc.nextLong();
			}
			
			for(int j=0; j<n;j++) {
				data[0][j] = data1[j];
				data[1][j] = data2[j];
			}
			
			System.out.println(bottomUp(n));
			
		}
	}
	
	public static long bottomUp(int n) {
		long d[][] = new long[3][n+1];
		d[0][0] = 0;
		d[1][0] = data[0][0];
		d[2][0] = data[1][0];
		
		
		
		for(int i=1; i<=n; i++) {
			d[0][i] = Math.max(d[0][i-1], Math.max(d[1][i-1], d[2][i-1]));
			d[1][i] = Math.max(d[0][i-1], d[2][i-1])+ data[0][i];
			d[2][i] = Math.max(d[0][i-1], d[1][i-1])+ data[1][i];
		}
		
		long ans = Math.max(d[0][n], Math.max(d[1][n], d[2][n]));
		
		
		return ans;
	}

}
