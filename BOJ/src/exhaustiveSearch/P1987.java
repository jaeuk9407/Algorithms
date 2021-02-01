package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1987 {
	static boolean alphas[] = new boolean[26];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static char board[][];
	static int R, C, cnt, ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		// 맵 정보 입력 처리
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
//			System.out.println(Arrays.toString(board[i]));
		}
		cnt = 1;
		ans = 1;
		dfs(0,0);
		System.out.println(ans);
	}

	private static void dfs(int row, int col) {
		
		alphas[board[row][col] - 'A'] = true;
		for(int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			if(0 <= nx && nx < R && 0 <= ny && ny < C) {
				if(!alphas[board[nx][ny] - 'A']) {
					ans = Math.max(++cnt, ans);
					dfs(nx, ny);
				}
			}
		}
		
		--cnt;
		alphas[board[row][col] - 'A'] = false; 
	}
}
