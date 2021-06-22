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
				// ���̸� ����Ʈ�� �߰��س���
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
		// ġŲ���� m�� ������ ��� ������ ġŲ�Ÿ� ���
		if(cnt == m) {
			int cityDist = calculate();
			answer = Math.min(answer, cityDist);
		}
		
		// m�� �̸� ������ ��� ����
		for(int i = start; i < chickens.size(); i++) {
			Info now = chickens.get(i);
			// �����ؼ� dfs ȣ��
			selected.push(now);
			dfs(i + 1, cnt + 1);
			// ȣ�� �� ���󺹱�
			selected.pop();
		}
	} // end of dfs
	
	public static int calculate() {
		int cityMinDist = 0;
		// ���� �ϳ��� ���
		for(int i = 0; i < houses.size(); i++) {
			Info nowHouse = houses.get(i);
			int minDist = Integer.MAX_VALUE;
			// ġŲ������ �Ÿ��� ����ϰ� �ּ� ġŲ�Ÿ� ���� �����ϸ� ����
			for(int j = 0; j < selected.size(); j++) {
				Info nowChicken = selected.get(j);
				// ���� ���� ġŲ�� �Ÿ� ���
				int dist = Math.abs(nowHouse.row - nowChicken.row) 
						+ Math.abs(nowHouse.col - nowChicken.col);
				// �ּ� ġŲ�Ÿ� ���� �����ϸ� ����
				minDist = Math.min(dist, minDist);
			}
			// ���� ������ ���� ����� ġŲ�Ÿ��� ���� ġŲ�Ÿ��� �ݿ�
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
