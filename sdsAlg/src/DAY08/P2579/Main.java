package DAY08.P2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, a[], max_point[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		a = new int[N+1];
		max_point = new int[3][N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
		}
		max_point[1][1] = a[1];
		
		for(int i = 2; i <= N; i++) {
			max_point[1][i] = Math.max(max_point[1][i-2], max_point[2][i-2]) + a[i];
			max_point[2][i] = max_point[1][i-1] + a[i];
		}
		System.out.println(Math.max(max_point[1][N], max_point[2][N]));
		
	}

}
