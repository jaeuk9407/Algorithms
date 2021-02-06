package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Memory exceeded
public class P2186_BFS {
	private static char[][] P;
	private static char[] word;
	private static int N, M, K, cnt;
	private static int[] dx;
	private static int[] dy;
	private static Queue<Info2186_BFS> q = new LinkedList<>();
	
	private static void bfs(int x, int y) {

		if(P[x][y] == word[0]) {
			Info2186_BFS start = new Info2186_BFS(x, y, String.valueOf(word[0]));
			q.add(start);
		}
			
		
		while(!q.isEmpty()) {
			Info2186_BFS now = q.poll();
			
			if(now.collect.length() >= word.length) {
//				System.out.println("-------------------------------------");
//				System.out.println("break!! =====>" + now.collect);
				cnt++;
				break;
			}
			
			for(int i = 0; i < dx.length; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				
				if(1 <= nextX && nextX <= N && 1 <= nextY && nextY <= M) {
					if(P[nextX][nextY] == word[now.collect.length()]) {
						Info2186_BFS next = new Info2186_BFS(nextX, nextY, now.collect+P[nextX][nextY]);
//						System.out.println("now x, y:" + now.x+", "+now.y);
//						System.out.println("next x, y:" + next.x+", "+next.y+"====>"+next.collect);
//						System.out.println("-------------------------------------");
						q.add(next);
					}
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// K값에 따른 이동 범위 설정
		dx = new int[K * 4];
		dy = new int[K * 4];
		
		int index = 0;
		// 상하좌우(1, 2, 3 ,4)
		for(int dir = 1;  dir <= 4; dir++) {
			for(int k = 1; k <=K; k++) {
				if(dir == 1) {
					// 상 방향 
					dx[index] = k;
					dy[index] = 0;
					index++;
				}else if(dir == 2) {
					// 하 방향
					dx[index] = -k;
					dy[index] = 0;
					index++;
				}else if(dir == 3) {
					// 좌 방향
					dx[index] = 0;
					dy[index] = -k;
					index++;
				}else {
					// 우 방향
					dx[index] = 0;
					dy[index] = k;
					index++;
				}
			}
		}
		
		P = new char[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			String line = br.readLine();
			for(int j = 1; j<=M; j++) {
				P[i][j] = line.charAt(j-1);
			}
		}
		String lastLine = br.readLine();
		word = lastLine.toCharArray();
		
//		System.out.println(Arrays.toString(P[1]));
//		System.out.println(Arrays.toString(P[2]));
//		System.out.println(Arrays.toString(P[3]));
//		System.out.println(Arrays.toString(P[4]));
//		System.out.println(Arrays.toString(word));
//		
//		System.out.println(Arrays.toString(dx));
//		System.out.println(Arrays.toString(dy));
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				bfs(i, j);
			}
		}
		
		System.out.println(cnt);
	}

}

class Info2186_BFS{
	int x, y;
	String collect;

	public Info2186_BFS(int x, int y, String collect) {
		this.x = x;
		this.y = y;
		this.collect = collect;
	}
}