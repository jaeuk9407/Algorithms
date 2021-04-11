package study.simulation.P16234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
	static int count;
	static int[][] populations, nations;
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		populations = new int[N + 1][N + 1];
		nations = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				populations[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visited = new boolean[N + 1][N + 1];
			if(!check()) {
				count++;
			}else {
				break;
			}
		}
		
		System.out.println(count);
	}
	
	// 인구 이동 필요한지 확인
	static boolean check() {
		List<Point> n_list;
		boolean isDone = true;	// 이동이 더이상 필요하지 않을 경우 true. 필요한 경우 false
		
		for(int i = 1; i<= N; i++) {
			for(int j = 1; j <= N; j++) {
				// 방문하지 않은 경우
				if(!visited[i][j]) {
					n_list = new LinkedList<>();
					n_list.add(new Point(i, j));
					
					// sum = 리스트에 저장된 값의 합 
					int sum = dfs(i, j, n_list, 0);
					// 연합이 가능한 주변국이 있는 경우 연합 후 population 정리
					if(n_list.size() > 1) {
						change(sum, n_list);
						isDone = false;
					}
				}
			}
		}
		return isDone;
	}
	
	// 평균 값으로 population을 갱신 
	static void change(int sum, List<Point> n_list) {
		int avg = sum/n_list.size();
		for(Point p : n_list) {
			populations[p.row][p.col] = avg;
		}
	}
	
	// 인접한 국가중 연합이 가능한 국가를 dfs로 탐색하고 전체 합을 반환 
	static int dfs(int row, int col, List<Point> n_list, int sum) {
		visited[row][col] = true;
		sum = populations[row][col];
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row+dx[i];
			int nextCol = col+dy[i];
			
			if(nextRow < 1 || nextCol < 1 || nextRow > N || nextCol > N) continue;
			if(!visited[nextRow][nextCol]) {
				int dif = Math.abs(populations[row][col] - populations[nextRow][nextCol]);
				if(L <= dif && dif <= R) {
					n_list.add(new Point(nextRow, nextCol));
					sum += dfs(nextRow, nextCol, n_list, sum);
				}
			}
		}
		return sum;
	}
}

class Point{
	int row, col;

	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
