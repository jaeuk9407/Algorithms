package DAY02.P2003;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		A = new int[N + 1];
		
		for(int i = 0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;
		
		sum = A[0];
		
		while(true) {
			// sum == M
			if(sum == M) {
				count++;
				sum += A[++end];
				sum -= A[start++];
				
			}else if(sum < M){
				// sum < M
				sum += A[++end];
			}else {
				// sum > M
				sum -= A[start++];
			}
			if(end == N) {
				break;
			}
		}
		
		sc.close();
		System.out.println(count);
		
	}
}
