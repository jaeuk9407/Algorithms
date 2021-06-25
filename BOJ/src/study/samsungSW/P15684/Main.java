package study.samsungSW.P15684;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
public class Main { 
	private static int n, m, h, answer; 
	private static int[][] map; 
	private static boolean finish = false; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); 
		h = Integer.parseInt(st.nextToken()); 
		map = new int[h + 1][n + 1]; 
		
		for (int i = 0; i < m; i++) { 
			int x, y;
			st = new StringTokenizer(br.readLine()); 
			x = Integer.parseInt(st.nextToken()); 
			y = Integer.parseInt(st.nextToken());
			// 1이면 오른쪽 방향 사다리, 2이면 왼쪽 방향 사다리
			map[x][y] = 1; 
			map[x][y + 1] = 2;
		} 
		
		// 사다리를 놓아보고 성공한다면 바로 break, 안되면 3번까지
		for (int i = 0; i <= 3; i++) { 
			answer = i; 
			dfs(1, 0); 
			if (finish) break;
		} 
		
		System.out.println((finish) ? answer : -1);
	} 
	
	private static void dfs(int x, int count) {
		// 답을 찾았다면 더이상 연산하지 않음
		if (finish) return; 
		
		// 0 ~ 3번째 사다리를 놓은 상태에서
		if (answer == count) { 
			// 모든 세로선이 조건을 만족한다면 종료
			if (check()) finish = true; 
			return;
		} 
		// 높이 depth를 1부터 h까지
		for (int i = x; i < h + 1; i++) {
			// 1번부터 마지막 전 세로선까지
			for (int j = 1; j < n; j++) {
				// 우측으로 가로선이 존재하지 않으면
				if (map[i][j] == 0 && map[i][j + 1] == 0) {
					// 가로선을 놓는다
					map[i][j] = 1; 
					map[i][j + 1] = 2;
					// 가로선을 놓은 상태에서 dfs 호출
					dfs(i, count + 1); 
					// 다시 가로선 제거
					map[i][j] = map[i][j + 1] = 0;
				}
			}
		} 
	} 
	
	// 모든 세로선이 조건을 만족하는지 판별해주는 boolean 반환 메서드 
	private static boolean check() { 
		// i: 세로선
		// y: 움직이는 위치에서의 column
		for (int i = 1; i <= n; i++) { 
			int x = 1, y = i;
			// j: 높이
			// x: h번 하강하는 과정에서의 depth
			for (int j = 0; j < h; j++) {
				// 1이면 오른쪽 이동
				if (map[x][y] == 1) y++;
				// 2이면 왼쪽 이동
				else if (map[x][y] == 2) y--;
				// 1만큼 내려감
				x++; 
			} 
			// 출발 세로선 인덱스와 도착한 세로선 인덱스가 다르면 false
			if (y != i) return false; 
		} 
		// 모든 세로선의 출발 세로선 인덱스와 도착한 세로선 인덱스가 같은 경우 true
		return true; 
	} 
}

