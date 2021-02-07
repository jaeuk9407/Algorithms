package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1261_DFS_DP {
	static int miro[][];
	static boolean visited[][];
	static int ans;
	static int N, M;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int dp[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		miro = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		dp = new int[N+1][M+1];
		
		for(int i = 1; i<= N; i++) {
			String line = br.readLine();
			for(int j = 1; j<=M; j++) {
				miro[i][j] = line.charAt(j-1) - '0';
			}
//			System.out.println(Arrays.toString(miro[i]));
		}
		
		for(int i = 1; i<= N; i++) {
			for(int j = 1; j<=M; j++) {
				dp[i][j] = 101;
			}
		}
		
		ans = 101;
		dfs(1, 1, 0, visited);
		System.out.println(ans);
	}
	
	static void dfs(int row, int col, int cnt, boolean[][] visited) {
		if(row >= N && col>= M) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(dp[row][col] <= cnt) {
			return;
		}
		
		visited[row][col] = true;
		dp[row][col] = cnt;
		
//		System.out.println("---------------------------");
//		for(int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		for(int i = 0; i< 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			if(0 < nx && nx <= N && 0 < ny && ny <= M) {
				if(!visited[nx][ny]) {
					if(miro[nx][ny] == 1) {
						dfs(nx, ny, cnt+1, visited);
					}else {
						dfs(nx, ny, cnt, visited);
					}
				}
			}
		}
		visited[row][col] = false;
	}
}
