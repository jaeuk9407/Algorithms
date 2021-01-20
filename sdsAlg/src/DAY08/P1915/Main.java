package DAY08.P1915;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[][], max_square[][], ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new int[N+1][M+1];
		max_square = new int[N+1][M+1];
		ans = 0;
		
		for(int i = 1; i<= N; i++) {
			String line = br.readLine();
			for(int j = 1; j<= M; j++) {
				a[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
			}
		}
		
		// ют╥б Test
//		for(int i = 1; i<= N; i++) {
//			System.out.println(Arrays.toString(a[i]));
//		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<= M; j++) {
				if(a[i][j] == 1) {
					int min_value = Integer.MAX_VALUE;
					min_value = Math.min(max_square[i-1][j], max_square[i][j-1]);
					min_value = Math.min(min_value, max_square[i-1][j-1]);
					max_square[i][j] = min_value + 1;
					
					ans = Math.max(ans, max_square[i][j]);
				}
			}
		}
		
		// max_square Test
//		System.out.println("-------------max_square-------------");
//		for(int i = 1; i<= N; i++) {
//			System.out.println(Arrays.toString(max_square[i]));
//		}
		
		System.out.println(ans*ans);
		
		
	}

}
