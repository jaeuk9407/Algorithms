package exhaustiveSearch;

// DFS WrongAnswer ==> Time Exceeded

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2186_beforeDP {
	private static char[][] P;
	private static char[] word;
	private static int N, M, K, cnt;
	private static int[] dx;
	private static int[] dy;
	
	private static void dfs(int x, int y, int wordIndex) {
		// 체크인
		if(P[x][y] != word[wordIndex]) {
			return;
		}
		// 연결된 곳을 순회
		for(int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 갈 수 있는가
			if(1 <= nx && nx <= N && 1 <= ny && ny <= M) {
				int nextWordIndex = wordIndex+1;
				// 목적지에 도착하는가
				if(nextWordIndex == word.length) {
					cnt++;
					return;
				}else if(P[nx][ny] == word[nextWordIndex]) {
					// 간다 
					dfs(nx, ny, nextWordIndex);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// K값에 따른 이동 범위 설정
		dx = new int[K * 4];
		dy = new int[K * 4];
		
		int index = 0;
		// 상하좌우(1, 2, 3 ,4)
		for(int dir = 1;  dir <= 4; dir++) {
			for(int k = 1; k <=K; k++) {
				if(dir == 1) {
					// 상 방향 
					dx[index] = k;
					dy[index] = 0;
					index++;
				}else if(dir == 2) {
					// 하 방향
					dx[index] = -k;
					dy[index] = 0;
					index++;
				}else if(dir == 3) {
					// 좌 방향
					dx[index] = 0;
					dy[index] = -k;
					index++;
				}else {
					// 우 방향
					dx[index] = 0;
					dy[index] = k;
					index++;
				}
			}
		}
		
		P = new char[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			String line = br.readLine();
			for(int j = 1; j<=M; j++) {
				P[i][j] = line.charAt(j-1);
			}
		}
		String lastLine = br.readLine();
		word = lastLine.toCharArray();
		cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				dfs(i, j, 0);
			}
		}
		
		System.out.println(cnt);
	}

}
