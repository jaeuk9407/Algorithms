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
			// 1�̸� ������ ���� ��ٸ�, 2�̸� ���� ���� ��ٸ�
			map[x][y] = 1; 
			map[x][y + 1] = 2;
		} 
		
		// ��ٸ��� ���ƺ��� �����Ѵٸ� �ٷ� break, �ȵǸ� 3������
		for (int i = 0; i <= 3; i++) { 
			answer = i; 
			dfs(1, 0); 
			if (finish) break;
		} 
		
		System.out.println((finish) ? answer : -1);
	} 
	
	private static void dfs(int x, int count) {
		// ���� ã�Ҵٸ� ���̻� �������� ����
		if (finish) return; 
		
		// 0 ~ 3��° ��ٸ��� ���� ���¿��� 
		if (answer == count) { 
			// ��� ���μ��� ������ �����Ѵٸ� ����
			if (check()) finish = true; 
			return;
		} 
		// ���� depth�� 1���� h����
		for (int i = x; i < h + 1; i++) {
			// 1������ ������ �� ���μ�����
			for (int j = 1; j < n; j++) {
				// �������� ���μ��� �������� ������
				if (map[i][j] == 0 && map[i][j + 1] == 0) {
					// ���μ��� ���´�
					map[i][j] = 1; 
					map[i][j + 1] = 2;
					// ���μ��� ���� ���¿��� dfs ȣ��
					dfs(i, count + 1); 
					// �ٽ� ���μ� ����
					map[i][j] = map[i][j + 1] = 0;
				}
			}
		} 
	} 
	
	// ��� ���μ��� ������ �����ϴ��� �Ǻ����ִ� boolean ��ȯ �޼��� 
	private static boolean check() { 
		// i: ���μ�
		// y: �����̴� ��ġ������ column
		for (int i = 1; i <= n; i++) { 
			int x = 1, y = i;
			// j: ����
			// x: h�� �ϰ��ϴ� ���������� depth
			for (int j = 0; j < h; j++) {
				// 1�̸� ������ �̵�
				if (map[x][y] == 1) y++;
				// 2�̸� ���� �̵�
				else if (map[x][y] == 2) y--;
				// 1��ŭ ������
				x++; 
			} 
			// ��� ���μ� �ε����� ������ ���μ� �ε����� �ٸ��� false
			if (y != i) return false; 
		} 
		// ��� ���μ��� ��� ���μ� �ε����� ������ ���μ� �ε����� ���� ��� true
		return true; 
	} 
}

