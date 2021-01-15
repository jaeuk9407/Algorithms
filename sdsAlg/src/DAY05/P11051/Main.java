package DAY05.P11051;

import java.util.Scanner;

public class Main {

	// Á¶ÇÕ, ÆÄ½ºÄ®ÀÇ »ï°¢Çü&DP
	static int[][] D;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		D = new int[N+1][N+1];
		sc.close();
		// k == 0 ==> 1
		// n == k ==> 1
		// D[n][k] = D[n-1][k-1] + D[n-1][k]
		for(int n = 1; n <= N; n++) {
			for(int k = 0; k <= N; k++) {
				if(k == 0 || n == k) {
					D[n][k] = 1;
				}else {
					D[n][k] = (D[n-1][k-1] + D[n-1][k]) % 10007; 
				}
			}
		}
		
		System.out.println(D[N][K]);
		
	}

}
