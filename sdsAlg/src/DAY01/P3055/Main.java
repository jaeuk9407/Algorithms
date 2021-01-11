package DAY01.P3055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] mx = {-1, 1, 0, 0};
	static int[] my = {0, 0, 1, -1};
	
	static int R, C;
	static char[][] map;
	static int[][] dp;
	static Queue<Point> queue;
	static boolean foundAnswer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		dp = new int[R][C];
		queue = new LinkedList<>();
		
		Point st = null;
		// map 입력
		for(int r = 0; r < R; r++) {
			String line = sc.next();
			for(int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == '*') {
					queue.add(new Point(r, c, '*'));
				}
				if(map[r][c] == 'S') {
					st = new Point(r, c, 'S');
				}
			}
		}
		
		sc.close();
		
		// 큐에 먼저 water 시작 지점 넣은 뒤, start 위치 주입
		// [*, *, *, S]
		queue.add(st);
		
		
		while(!queue.isEmpty()) {
			// 1. 큐에서 꺼내옴
			Point now = queue.poll();
			// 2. 목적지인가? if(p ==D)
			if(now.type == 'D') {
				System.out.println(dp[now.x][now.y]);
				foundAnswer = true;
				break;
				
			}
			// 3. 갈수 있는 곳을 순회 for(좌, 우, 상, 하)
			for(int i = 0; i<4; i++) {
				int nx = now.x + mx[i];
				int ny = now.y + my[i];
				// 4. 갈 수 있는가? if(맵을 벗어나지 않는가)
				if(0 <= nx && nx < R && 0 <= ny && ny < C ) {
					// queue에서 나오는 type은 고슴도치 or *
					if(now.type == 'S' || now.type == '.') { // 고슴도치
						// next가 아직 방문하지 않았고, 이동 가능한가?
						if(dp[nx][ny] == 0 && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
							// 5. 체크인 dp[r][c] = time
							dp[nx][ny] = dp[now.x][now.y] + 1;
							// 6. 큐에 넣음 queue.add(next)
							queue.add(new Point(nx, ny, map[nx][ny]));
						}
					
					}else { // 물
						if(map[nx][ny] == '.') {
							map[nx][ny] = '*';
							queue.add(new Point(nx, ny, '*'));
						}
					}
				}
			}
		}
		if(foundAnswer == false) {
			System.out.println("KAKTUS");
		}

	}

}
class Point{
	int x;
	int y;
	char type;
	public Point(int x, int y, char type) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
	}
}