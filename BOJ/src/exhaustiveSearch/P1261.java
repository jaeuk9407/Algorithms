package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1261 {

	static int N, M;
	static int map[][];
	static int dist[][];
	static PriorityQueue<Place> pq;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		dist = new int[N+1][M+1];
		
		for(int i = 0; i < dist.length; i++) {
			for(int j = 0; j < dist[i].length; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			String line = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j-1) - '0';
			}
		}
		
		// Priority Queue 생성
		pq = new PriorityQueue<>();
		bfs();
		System.out.println(result);
		
		
	}
	
	private static void bfs() {
		// 첫 번째 시작 값 
		pq.add(new Place(1, 1, 0));
		dist[1][1] = 0;
		
		while(!pq.isEmpty()) {
			Place now = pq.poll();
			
			// 목적지에 도착했는가
			if(now.x == N && now.y == M) {
				result = now.cost;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				// map의 범위 안에 존재하면
				if(0 < nx && nx <= N && 0 < ny && ny <= M) {
					// 지금까지 찾은 최소 weight 경로보다 작으면 변경 후 이동
					if(dist[nx][ny] > dist[now.x][now.y] + map[nx][ny]) {
						dist[nx][ny] = dist[now.x][now.y] + map[nx][ny];
						pq.add(new Place(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
	}

}

class Place implements Comparable<Place>{
	int x, y, cost;

	public Place(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Place o) {
		if(this.cost < o.cost) return -1; 
		return 1;
	}
}
