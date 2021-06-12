package study.samsungSW.P14499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[] dice = new int[7];
	static int[][] board;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// ���� ���� �Է�
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �̵� ��� ����
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			// �̵��� ����
			int oper = Integer.parseInt(st.nextToken());
			// �̵��� ���� ��ġ
			int nx = x + dx[oper - 1];
			int ny = y + dy[oper - 1];
			// ������ ������ ������ ������ �̵�
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				move(oper);
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void move(int dir) {
		int[] temp = dice.clone();
		if(dir == 1) {	// ��
			dice[4] = temp[6]; dice[1] = temp[4];
			dice[3] = temp[1]; dice[6] = temp[3];
		}else if(dir == 2) {	// �� 
			dice[4] = temp[1]; dice[1] = temp[3];
			dice[3] = temp[6]; dice[6] = temp[4];
		}else if(dir == 3) {	// �� 
			dice[2] = temp[1]; dice[1] = temp[5];
			dice[5] = temp[6]; dice[6] = temp[2];
		}else {	// ��
			dice[2] = temp[6]; dice[1] = temp[2];
			dice[5] = temp[1]; dice[6] = temp[5];
		}
		// �̵��� ���� ��ġ
		int nx = x + dx[dir - 1];
		int ny = y + dy[dir - 1];
		// �̵��� ���� ��ġ�� ���� 0�̸� �ֻ����� �ظ��� ���� ������ �Է�
		if(board[nx][ny] == 0) {
			board[nx][ny] = dice[6];
		}else {	// ������ ���� �ִٸ� �ֻ����� �ظ鿡 ������ ���� ����, ����� 0
			dice[6] = board[nx][ny];
			board[nx][ny] = 0;
		}
		
		x = nx;
		y = ny;
		
		// �̵� �� ���� ���� ����
		list.add(dice[1]);
	}
}
