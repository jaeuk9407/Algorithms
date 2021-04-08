package study.simulation.P15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, blindSpot = 0;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static List<int[]> list = new ArrayList<>();
	static int[][] stat= {
			{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1},
			{1, 0, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 0},
			{0, 0, 1, 1}, {1, 0, 0, 1}, {1, 1, 1, 0}, {0, 1, 1, 1},
			{1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}
	};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				
				if(room[i][j] == 0) blindSpot++;
				if(0 < room[i][j] && room[i][j] < 6) list.add(new int[] {i, j});
			}
		}
		
		bfs(room, blindSpot);
		System.out.println(blindSpot);
		
	}
	// ��� cctv�� ���� ������ �õ�
	static void bfs(int[][] room, int blindSpot) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(blindSpot, room));
		
		for(int i = 0; i < list.size(); i++) {
			int qLen = q.size();
			
			for(int t = 0; t < qLen; t++) {
				Info m = q.poll();
				int bs = m.blindSpot;
				int row = list.get(i)[0];
				int col = list.get(i)[1];
				
				if(room[row][col] == 1) {
					q.add(cctv(m.room, row, col, bs, stat[0]));
					q.add(cctv(m.room, row, col, bs, stat[1]));
					q.add(cctv(m.room, row, col, bs, stat[2]));
					q.add(cctv(m.room, row, col, bs, stat[3]));
				}
				if(room[row][col] == 2) {
					q.add(cctv(m.room, row, col, bs, stat[4]));
					q.add(cctv(m.room, row, col, bs, stat[5]));
				}
				if(room[row][col] == 3) {
					q.add(cctv(m.room, row, col, bs, stat[6]));
					q.add(cctv(m.room, row, col, bs, stat[7]));
					q.add(cctv(m.room, row, col, bs, stat[8]));
					q.add(cctv(m.room, row, col, bs, stat[9]));
				}
				if(room[row][col] == 4) {
					q.add(cctv(m.room, row, col, bs, stat[10]));
					q.add(cctv(m.room, row, col, bs, stat[11]));
					q.add(cctv(m.room, row, col, bs, stat[12]));
					q.add(cctv(m.room, row, col, bs, stat[13]));
				}
				if(room[row][col] == 5) {
					q.add(cctv(m.room, row, col, bs, stat[14]));
				}
			}
		}
	}
	
	// cctv�� ���۽�Ű�� ����� blindSpot ������ ���� ��ȯ
	static Info cctv(int[][] room, int row, int col, int num, int[] status) {
		int[][] result = copy(room);
		
		// ���ߴ� ���⸶�� ���� �����ų� ���� ��� ������ ���ߵ��� ��
		for(int i = 0; i < 4; i++) {
			// ���� ������ ������ ������ continue
			if(status[i] == 0) continue;
			int nxtRow = row;
			int nxtCol = col;
			
			while(true) {
				nxtRow = nxtRow + dx[i];
				nxtCol = nxtCol + dy[i];
				
				// ���� ��ġ�� room ���θ� ����ų� ���̶�� �̵��� �� ����
				if(nxtRow < 1 || nxtRow > n || nxtCol < 1 || nxtCol > m) break;
				if(result[nxtRow][nxtCol] == 6) break;
				
				if(result[nxtRow][nxtCol] == 0) {
					result[nxtRow][nxtCol] = 8;
					num--;
				}
			}
		}
		
		if(blindSpot > num) blindSpot = num;
		return new Info(num, result);
	}
	
	// 2���� �� ������ �״�� ����
	static int[][] copy(int[][] room){
		int[][] result = new int[n + 1][m + 1];
		for(int i = 0; i<= n; i++) {
			System.arraycopy(room[i], 0, result[i], 0, m + 1);
		}
		return result;
	}
}

class Info{
	int blindSpot;
	int[][] room;
	
	public Info(int blindSpot, int[][] room) {
		this.blindSpot = blindSpot;
		this.room = room;
	}
}

