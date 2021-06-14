package study.samsungSW.P14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static int[][] board;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(answer);
	}
	
	// dfs로 벽 세우기
	public static void dfs(int cnt) {
		// 벽이 모두 세워졌으면 바이러스 전파하고, 가능하면 결과 갱신
		if(cnt == 3) {
			bfs();
		}else {	// 벽이 모두 세워지지 않았으면 세워질 때까지 세움
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					// 빈칸이면
					if(board[i][j] == 0) {
						// 벽 세우기
						board[i][j] = 1;
						dfs(cnt + 1);
						// 다음 탐색을 위해 벽 허물기
						board[i][j] = 0;
					}
				}
			}
		}
	}
	
	// bfs로 바이러스 전파
	public static void bfs() {
		Queue<Virus> q = new LinkedList<>();
		
		// 수행 시점에 board 정보 복사
		int[][] tempBoard = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempBoard[i][j] = board[i][j];
			}
		}

		
		// 초기 바이러스 위치를 큐에 저장
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tempBoard[i][j] == 2) {
					q.add(new Virus(i, j));
				}
			}
		}
		
		// 바이러스 전파
		while(!q.isEmpty()) {
			Virus now = q.poll();
			
			// 4방향 이동
			for(int d = 0; d < 4; d++) {
				int nx = now.row + dx[d];
				int ny = now.col + dy[d];
				
				// board를 벗어나면 이동 불가
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				// 빈공간이면
				if(tempBoard[nx][ny] == 0) {
					// 다음 위치에 바이러스 감염 후 이동
					tempBoard[nx][ny] = 2;
					q.add(new Virus(nx, ny));
				}
			}
		} // end of 바이러스 전파
		calSafeRegion(tempBoard);
	}
	
	// 현재 상태의 안전 영역을 계산하고, 현재 answer보다 크면 업데이트
	public static void calSafeRegion(int[][] tempBoard) {
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tempBoard[i][j] == 0) cnt++;
			}
		}
		
		if(answer < cnt) {
			answer = cnt;
		}
	}
}

class Virus{
	int row, col;

	public Virus(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
