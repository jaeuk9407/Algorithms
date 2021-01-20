package DAY08.P1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// DP

	static int N, tri[][], max_val[][], ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		tri = new int[510][510];
		max_val = new int[510][510];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		max_val[1][1] = tri[1][1];
		for(int i = 2; i <= N ; i++) {
			for(int j = 1; j <= i; j++) {
				// max_val[i][j] == max_val[i-1][j], max_val[i-1][j-1] 둘 중 하나에 + tri[i][j]
				// j 벗어나는지 처리를 해주면....
				// 해도 되지 않는 이유는 어차피 0이니까...
				max_val[i][j] = Math.max(max_val[i-1][j-1], max_val[i-1][j])+tri[i][j];
			}
		}
		
		for(int i = 1; i <= N; i++) {
			ans = Math.max(max_val[N][i], ans);
		}
		
		
		
		System.out.println(ans);
	}
}
