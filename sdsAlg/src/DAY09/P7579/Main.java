package DAY09.P7579;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M,cost[], mem[], ans;
	static int dp[][]; // dp: cost i 를 소모해서 확보할 수 있는 최대 메모리 크기
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[101][10001];
		cost = new int[10001];
		mem = new int[101];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<= N; i++) {
			mem[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for(int j = 1; j<=N; j++) {
			for(int i = 0; i<= 10000; i++) {
				// [j][i] : j앱까지 고려했을 때(대상으로 했을 때) cost i 로 확보할 수 있는 최대 메모리
				// j번째 앱을 사용하지 않거나 / 사용하거나
				// 둘중에 큰 값
				dp[j][i] = dp[j-1][i];	// j번째 앱을 사용하지 않을 때 
				if(i - cost[j] >= 0) {
					dp[j][i] = Math.max(dp[j][i], dp[j-1][i-cost[j]] +mem[j]);	// j번째 앱을 사용했을 때 
				}
			}
		}
		
		// 비용을 찾아보면서, m이상의 메모리를 확보했는지 확인해봄
		for(int i = 0; i <=10000; i++) {
			if(dp[N][i] >= M) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
