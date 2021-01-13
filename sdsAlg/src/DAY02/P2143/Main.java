package DAY02.P2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;
	static int[] A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		B = new int[M + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		// 부분 배열 값을 원소로 갖는 배열(subA, subB) 정의
		int[] subA = new int[(N * (1+N)/2) + 1];
		int[] subB = new int[(M * (1+M)/2) + 1];
		
		int p = 0, start = 0, end = 0, sum = 0;
		sum = A[0];
		
		while(true) {
			System.out.println("start:"+start+", end:"+end);
			subA[p] = sum;
			p++;
			if(end < N-1) {
				sum += A[++end];
			}else {
				sum = A[++start];
				end = start;
			}
			if(end == N-1 && start == N-1) {
				break;
			}
		}
		
		
		System.out.println(Arrays.toString(subA));
	}

}
