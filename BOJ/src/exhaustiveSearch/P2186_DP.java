package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
// ERROR

public class P2186_DP {
	private static char[][] P;
	private static char[] word;
	private static int N, M, K, cnt;
	private static int[] dx;
	private static int[] dy;
	private static int[][][] DP;	// x, y, wordIndex ==> 진행상태, value ==> 달성할 수 있는 경로 수
	private static ArrayList<Info2186> list;
	
	
	private static void dfs(int x, int y, int wordIndex) {
		// 시작점이 word의 첫 글자와 다르면 진행하지 않음
		if(P[x][y] != word[wordIndex]) {
			return;
		}
		
		// 현재 진행상태가 이미 방문한 적 있는 상태이면 결과만 반영하고 더 진행하지 않음
		if(DP[x][y][wordIndex] != 0) {
			System.out.println("현재 진행 상태를 방문한 적 있음 ==> out");
			System.out.println("DP: "+ DP[x][y][wordIndex]);
			cnt += DP[x][y][wordIndex];
			return;
		}
		
		// 체크인
		list.add(new Info2186(x, y));
		System.out.println("checkIN ====> "+list.toString());
		
		// 연결된 곳을 순회
		for(int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 갈 수 있는가
			if(1 <= nx && nx <= N && 1 <= ny && ny <= M) {
				int nextWordIndex = wordIndex+1;
				// 목적지에 도착하는가
				if(nextWordIndex == word.length) {
					System.out.println("============= 목적지 도착 ==============");
					System.out.println("nextWordIndex: "+nextWordIndex);
					cnt++;
//					list.add(new Info2186(nx, ny));
					// 지나온 경로의 DP + 1
					int path = 0;
					while(!list.isEmpty()) {
						System.out.println("목적지 도착 list 상태 출력: "+list.toString());
						Info2186 backPoint = list.get(0);
						DP[backPoint.x][backPoint.y][path]++;
						list.remove(0);
						System.out.println("list 요소 삭제: "+backPoint.toString()+", index: "+path);
						path++;
					}
					return;
				}else if(P[nx][ny] == word[nextWordIndex]) {
					// 목적지에 도착X, 갈 수 있는 경로이므로 재귀 진행
					System.out.println("다음 경로 재귀 진행");
					System.out.println("nextWordIndex: "+nextWordIndex);
					dfs(nx, ny, nextWordIndex);
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
		
		DP = new int[101][101][81];
		
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
		cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				list = new ArrayList<>();
				dfs(i, j, 0);
			}
		}
		
		System.out.println(cnt);
	}

}

class Info2186{
	int x, y;

	public Info2186(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Info2186 [x=" + x + ", y=" + y + "]";
	}
}
