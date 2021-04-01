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
	static int[] head = {1, 1};	// 좌상단에서 시작
	static int sec;	// 경과시간
	static int direction = 0;	// 우측을 보고 시작
	static int[] dx = {0, 1, 0, -1};	// 동남서북
	static int[] dy = {1, 0, -1, 0};	// 동남서북
	static Queue<Point> q;
	static Queue<Point> body;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		// board 및 사과 정보 입력
		board = new int[N + 1][N + 1];
		StringTokenizer st;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			board[row][col] = 1;	// 사과 위치를 1로 설정
		}
		
		// 방향 전환 정보 입력
		L = Integer.parseInt(br.readLine());
		infoD = new int[L + 1][2];
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			infoD[i][0] = second;
			// 좌로 이동: -1, 우로 이동: 1
			if(dir.equals("L")) infoD[i][1] = -1;
			else if(dir.equals("D")) infoD[i][1] = 1;
		}
		
		// 이동
		q = new LinkedList<>();
		body = new LinkedList<>();
		result = move();
		
		System.out.println(result);
	}
	
	static int move() {
		Point start = new Point(head[0], head[1]);
		q.add(start);
		body.add(start);
		
		int countD = 0;	// 몇 번째 infoD를 확인할지 count
		
		while(!q.isEmpty()) {
			// 방향 전환이 있는 타이밍이면 전환
			if(infoD[countD][0] == sec) {
				direction += infoD[countD][1];
				
				if(direction == 4) {	// 북 -> 동
					direction = 0;
				}else if(direction == -1) {	// 동 -> 북
					direction = 3;
				}
				countD++;
			}
			
			// check in
			Point now = q.poll();
			
//			// 사과가 있다면
//			if(board[now.x][now.y] == 1){
//				board[now.x][now.y] = -1;	// 사과 없어지고 body로 설정
//			}else {	// 사과가 없다면
//				Point tail = body.poll();	// 비워줌
//				board[tail.x][tail.y] = 0;	
//			}
			
			int nextX = now.x + dx[direction];
			int nextY = now.y + dy[direction];
			Point next = new Point(nextX, nextY);
			sec++;
			
			// 이동할 수 있는 위치이고, 몸이 있는 위치가 아니면 움직인다.
			if(1 <= nextX && nextX <= N && 1 <= nextY && nextY <= N 
					&& board[nextX][nextY] != -1) {
				head[0] = nextX;
				head[1] = nextY;
				body.add(next);
				q.add(next);
				
				if(board[next.x][next.y] == 0) {	// 사과가 없다면
					Point tail = body.poll();	// 비워줌
					board[tail.x][tail.y] = 0;	
				}
				board[next.x][next.y] = -1;	// body로 설정
				
//				System.out.println(sec+"초 경과: " + nextX+","+nextY +"----"+ body.toString());
				
			}else {
				// 이동이 불가하다면 끝남
//				System.out.println(nextX+","+nextY+"에서 멈춤. direction:"+direction);
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
