package study.simulation.P3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, L, result;
	static int board[][];
	static int[][] infoD;
	static int[] head = {1, 1};	// �»�ܿ��� ����
	static int sec;	// ����ð�
	static int direction = 0;	// ������ ���� ����
	static int[] dx = {0, 1, 0, -1};	// ��������
	static int[] dy = {1, 0, -1, 0};	// ��������
	static Queue<Point> q;
	static Queue<Point> body;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		// board �� ��� ���� �Է�
		board = new int[N + 1][N + 1];
		StringTokenizer st;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			board[row][col] = 1;	// ��� ��ġ�� 1�� ����
		}
		
		// ���� ��ȯ ���� �Է�
		L = Integer.parseInt(br.readLine());
		infoD = new int[L + 1][2];
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			infoD[i][0] = second;
			// �·� �̵�: -1, ��� �̵�: 1
			if(dir.equals("L")) infoD[i][1] = -1;
			else if(dir.equals("D")) infoD[i][1] = 1;
		}
		
		// �̵�
		q = new LinkedList<>();
		body = new LinkedList<>();
		result = move();
		
		System.out.println(result);
	}
	
	static int move() {
		Point start = new Point(head[0], head[1]);
		q.add(start);
		body.add(start);
		
		int countD = 0;	// �� ��° infoD�� Ȯ������ count
		
		while(!q.isEmpty()) {
			// ���� ��ȯ�� �ִ� Ÿ�̹��̸� ��ȯ
			if(infoD[countD][0] == sec) {
				direction += infoD[countD][1];
				
				if(direction == 4) {	// �� -> ��
					direction = 0;
				}else if(direction == -1) {	// �� -> ��
					direction = 3;
				}
				countD++;
			}
			
			// check in
			Point now = q.poll();
			
//			// ����� �ִٸ�
//			if(board[now.x][now.y] == 1){
//				board[now.x][now.y] = -1;	// ��� �������� body�� ����
//			}else {	// ����� ���ٸ�
//				Point tail = body.poll();	// �����
//				board[tail.x][tail.y] = 0;	
//			}
			
			int nextX = now.x + dx[direction];
			int nextY = now.y + dy[direction];
			Point next = new Point(nextX, nextY);
			sec++;
			
			// �̵��� �� �ִ� ��ġ�̰�, ���� �ִ� ��ġ�� �ƴϸ� �����δ�.
			if(1 <= nextX && nextX <= N && 1 <= nextY && nextY <= N 
					&& board[nextX][nextY] != -1) {
				head[0] = nextX;
				head[1] = nextY;
				body.add(next);
				q.add(next);
				
				if(board[next.x][next.y] == 0) {	// ����� ���ٸ�
					Point tail = body.poll();	// �����
					board[tail.x][tail.y] = 0;	
				}
				board[next.x][next.y] = -1;	// body�� ����
				
//				System.out.println(sec+"�� ���: " + nextX+","+nextY +"----"+ body.toString());
				
			}else {
				// �̵��� �Ұ��ϴٸ� ����
//				System.out.println(nextX+","+nextY+"���� ����. direction:"+direction);
				break;
			}
		}
		return sec;
	}

}

class Point{
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
}
