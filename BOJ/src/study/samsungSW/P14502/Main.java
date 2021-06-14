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
	
	// dfs�� �� �����
	public static void dfs(int cnt) {
		// ���� ��� ���������� ���̷��� �����ϰ�, �����ϸ� ��� ����
		if(cnt == 3) {
			bfs();
		}else {	// ���� ��� �������� �ʾ����� ������ ������ ����
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					// ��ĭ�̸�
					if(board[i][j] == 0) {
						// �� �����
						board[i][j] = 1;
						dfs(cnt + 1);
						// ���� Ž���� ���� �� �㹰��
						board[i][j] = 0;
					}
				}
			}
		}
	}
	
	// bfs�� ���̷��� ����
	public static void bfs() {
		Queue<Virus> q = new LinkedList<>();
		
		// ���� ������ board ���� ����
		int[][] tempBoard = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempBoard[i][j] = board[i][j];
			}
		}

		
		// �ʱ� ���̷��� ��ġ�� ť�� ����
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tempBoard[i][j] == 2) {
					q.add(new Virus(i, j));
				}
			}
		}
		
		// ���̷��� ����
		while(!q.isEmpty()) {
			Virus now = q.poll();
			
			// 4���� �̵�
			for(int d = 0; d < 4; d++) {
				int nx = now.row + dx[d];
				int ny = now.col + dy[d];
				
				// board�� ����� �̵� �Ұ�
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				// ������̸�
				if(tempBoard[nx][ny] == 0) {
					// ���� ��ġ�� ���̷��� ���� �� �̵�
					tempBoard[nx][ny] = 2;
					q.add(new Virus(nx, ny));
				}
			}
		} // end of ���̷��� ����
		calSafeRegion(tempBoard);
	}
	
	// ���� ������ ���� ������ ����ϰ�, ���� answer���� ũ�� ������Ʈ
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
