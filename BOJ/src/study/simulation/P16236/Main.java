package study.simulation.P16236;

// 참고 https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-16236-%EC%95%84%EA%B8%B0-%EC%83%81%EC%96%B4
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int max_val =401, max_int = 21;
	static int n, shark_x, shark_y, min_dist, min_x, min_y, result, eat_cnt = 0, shark_size = 2;
	static int[][] spaces, check;
	static int[] dx = {0, 0, 1, -1}, dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		spaces = new int[n + 1][n + 1];
		check = new int[n + 1][n + 1];	// 아기 상어의 위치 기준 거리 배열: 먹을 때마다 update
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				spaces[i][j] = Integer.parseInt(st.nextToken());
				
				if(spaces[i][j] == 9) {
					shark_x = i;
					shark_y = j;
					spaces[i][j] = 0;
				}
			}
		}
		
		while(true) {
			init_check();
			
			bfs(shark_x, shark_y);
			
			// 먹을 수 있는 먹이가 없어 update되지 않은 경우가 아니라면 먹는다. 
			if(min_x != max_int && min_y != max_int) {
				result += check[min_x][min_y];
				eat_cnt++;
				
				// 몸집만큼 먹이를 먹으면 몸집 커짐
				if(eat_cnt == shark_size) {
					shark_size++;
					eat_cnt = 0;
				}
				// 먹은 먹이 위치 0으로 초기화
				spaces[min_x][min_y] = 0;
				
				// 아기 상어 위치를 먹은 먹이 위치로 변경
				shark_x = min_x;
				shark_y = min_y;
			}else {
				// 맵을 벗어나면 더이상 먹이가 없으므로 out
				break;
			}
		}
		
		System.out.println(result);
	} // end of main
	
	// 먹이를 먹을 때마다 실행하는 거리 배열 초기화
	static void init_check() {
		min_dist = max_val;
		min_x = max_int;
		min_y = max_int;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				check[i][j] = -1;
			}
		}
	}
	
	// 최소 거리 먹이를 찾아 설정하는 함수
	static void bfs(int x, int y) {
		Queue<Info> q = new LinkedList<>();
		check[x][y] = 0;
		q.add(new Info(x, y));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			x = cur.x;
			y = cur.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
				if(check[nx][ny] != -1 || spaces[nx][ny] > shark_size) continue;
				
				check[nx][ny] = check[x][y] + 1;
				
				// 비어 있지 않고, 먹을 수 있는 물고기가 있는 경우
				if(spaces[nx][ny] != 0 && spaces[nx][ny] < shark_size) {
					// 다음 위치가 가진 최소 거리 위치보다 가까우면 새로 설정한다
					if(min_dist > check[nx][ny]) {
						min_x = nx;
						min_y = ny;
						min_dist = check[nx][ny];
					}else if(min_dist == check[nx][ny]) {
						// 같다면 왼쪽부터, col도 같다면 위쪽부터 처리한다
						if(min_x == nx) {
							if(min_y > ny) {
								min_x = nx;
								min_y = ny;
							}
						}else if(min_x > nx) {
							min_x = nx;
							min_y = ny;
						}
					}
				}
				q.add(new Info(nx, ny));
			}
		}
	}
	
	
}
class Info{
	int x, y;

	public Info(int x, int y) {
		this.x = x;
		this.y = y;
	}
}