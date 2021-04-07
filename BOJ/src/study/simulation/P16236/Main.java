package study.simulation.P16236;

// ���� https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-16236-%EC%95%84%EA%B8%B0-%EC%83%81%EC%96%B4
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
		check = new int[n + 1][n + 1];	// �Ʊ� ����� ��ġ ���� �Ÿ� �迭: ���� ������ update
		
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
			
			// ���� �� �ִ� ���̰� ���� update���� ���� ��찡 �ƴ϶�� �Դ´�. 
			if(min_x != max_int && min_y != max_int) {
				result += check[min_x][min_y];
				eat_cnt++;
				
				// ������ŭ ���̸� ������ ���� Ŀ��
				if(eat_cnt == shark_size) {
					shark_size++;
					eat_cnt = 0;
				}
				// ���� ���� ��ġ 0���� �ʱ�ȭ
				spaces[min_x][min_y] = 0;
				
				// �Ʊ� ��� ��ġ�� ���� ���� ��ġ�� ����
				shark_x = min_x;
				shark_y = min_y;
			}else {
				// ���� ����� ���̻� ���̰� �����Ƿ� out
				break;
			}
		}
		
		System.out.println(result);
	} // end of main
	
	// ���̸� ���� ������ �����ϴ� �Ÿ� �迭 �ʱ�ȭ
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
	
	// �ּ� �Ÿ� ���̸� ã�� �����ϴ� �Լ�
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
				
				// ��� ���� �ʰ�, ���� �� �ִ� ����Ⱑ �ִ� ���
				if(spaces[nx][ny] != 0 && spaces[nx][ny] < shark_size) {
					// ���� ��ġ�� ���� �ּ� �Ÿ� ��ġ���� ������ ���� �����Ѵ�
					if(min_dist > check[nx][ny]) {
						min_x = nx;
						min_y = ny;
						min_dist = check[nx][ny];
					}else if(min_dist == check[nx][ny]) {
						// ���ٸ� ���ʺ���, col�� ���ٸ� ���ʺ��� ó���Ѵ�
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