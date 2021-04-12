package study.simulation.P15685;

// ����: https://dublin-java.tistory.com/34

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int RIGHT = 0;
	private static final int UP = 1;
	private static final int LEFT = 2;
	private static final int DOWN = 3;
	private static final int LENGTH = 101;
	
	private static boolean[][] map = new boolean[LENGTH][LENGTH];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			draw(x, y, getDirections(d, g));
		}
		
		int result = getNumberOfSquares();
		System.out.println(result);
		
		
	}
	
	// ������ �׸���
	static void draw(int x, int y, List<Integer> directions) {
		map[x][y] = true;
		
		for(int direction : directions) {
			switch(direction) {
				case RIGHT:
					map[++x][y] = true;
					break;
				case UP:
					map[x][--y] = true;
					break;
				case LEFT:
					map[--x][y] = true;
					break;
				case DOWN:
					map[x][++y] = true;
					break;
			}
			
		}
	}
	
	// ���� ���뿡 �׸� ������ ��� ��ȯ
	static List<Integer> getDirections(int direction, int generation){
		List<Integer> directions = new ArrayList<>();
		// �ʱ� ������ �Է� 
		directions.add(direction);
		
		// g���븸ŭ �ݺ�
		while(generation-- > 0) {
			for(int i = directions.size() - 1; i >= 0; i--) {
				// �������� ������ ���ð� �������� 90�� ���� ����Ʈ�� ����
				int nextDirection = (directions.get(i) + 1) % 4;
				directions.add(nextDirection);
			}
		}
		
		return directions;
	}
	
	// ��� ���� �巡��Ŀ�꿡 ���Ե� 1X1 �簢�� ���� ���
	static int getNumberOfSquares() {
		int count = 0;
		
		for(int x = 0; x < LENGTH - 1; x++) {
			for(int y = 0; y < LENGTH - 1; y++) {
				if(map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
					count++;
			}
		}
		
		return count;
	}

}
