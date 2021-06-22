package study.samsungSW.P15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n, m, answer;
	static int[][] board;
	static List<Info> houses = new ArrayList<>();
	static List<Info> chickens = new ArrayList<>();
	static Stack<Info> selected = new Stack<>();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				// 집이면 리스트에 추가해놓음
				if(board[i][j] == 1) {
					houses.add(new Info(i, j, 1));
				}else if(board[i][j] == 2) {
					chickens.add(new Info(i, j, 2));
				}
			}
		}
		dfs(0, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int start, int cnt) {
		// 치킨집을 m개 오픈한 경우 도시의 치킨거리 계산
		if(cnt == m) {
			int cityDist = calculate();
			answer = Math.min(answer, cityDist);
		}
		
		// m개 미만 오픈한 경우 오픈
		for(int i = start; i < chickens.size(); i++) {
			Info now = chickens.get(i);
			// 오픈해서 dfs 호출
			selected.push(now);
			dfs(i + 1, cnt + 1);
			// 호출 후 원상복구
			selected.pop();
		}
	} // end of dfs
	
	public static int calculate() {
		int cityMinDist = 0;
		// 집을 하나씩 골라
		for(int i = 0; i < houses.size(); i++) {
			Info nowHouse = houses.get(i);
			int minDist = Integer.MAX_VALUE;
			// 치킨집마다 거리를 계산하고 최소 치킨거리 갱신 가능하면 갱신
			for(int j = 0; j < selected.size(); j++) {
				Info nowChicken = selected.get(j);
				// 현재 집과 치킨집 거리 계산
				int dist = Math.abs(nowHouse.row - nowChicken.row) 
						+ Math.abs(nowHouse.col - nowChicken.col);
				// 최소 치킨거리 갱신 가능하면 갱신
				minDist = Math.min(dist, minDist);
			}
			// 현재 집에서 가장 가까운 치킨거리를 도시 치킨거리에 반영
			cityMinDist += minDist;
		}
		return cityMinDist;
	}
	

}
class Info{
	int row, col;
	int type;
	public Info(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Info [row=" + row + ", col=" + col + ", type=" + type + "]";
	}
}
