package DAY05.P1256;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, K;
	static int [][] dp = new int[201][201];
	static int L;	// L: N+M
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		if(K > combination(N+M, M)) {
			System.out.println(-1);
		}else {
			StringBuilder sb = new StringBuilder();
			query(N, M, K, sb);
			System.out.println(sb.toString());
		}
		sc.close();
		
	}
	public static void query(int n, int m, int k, StringBuilder sb) {
		if(n + m == 0) {
			// n == 0 and m == 0
			return;
		}
		// n == 0
		if(n == 0) {
			sb.append("z");
			query(n, m-1, k, sb);
		}else if(m == 0) {
			// m == 0
			sb.append("a");
			query(n-1, m, k, sb);
		}else {
			// n+m-1 C m
			int leftCount = combination(n+m -1, m);
			if(k <= leftCount) {
				sb.append("a");
				query(n - 1, m, k, sb);
			}else {
				sb.append("z");
				query(n, m-1, k-leftCount, sb);
			}
		}
	}
	
	
	public static int combination(int n, int r) {
		if(n == r || r == 0) {
			return 1;
		}else if(dp[n][r] != 0){
			return dp[n][r];
		}else{
			return dp[n][r] = Math.min((int)1e9, combination(n - 1, r - 1) + combination(n - 1, r));
		}
	}

}
