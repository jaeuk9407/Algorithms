package study.simulation.P15685;

// 참고: https://dublin-java.tistory.com/34

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
	
	// 꼭지점 그리기
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
	
	// 다음 세대에 그릴 방향을 담아 반환
	static List<Integer> getDirections(int direction, int generation){
		List<Integer> directions = new ArrayList<>();
		// 초기 방향을 입력 
		directions.add(direction);
		
		// g세대만큼 반복
		while(generation-- > 0) {
			for(int i = directions.size() - 1; i >= 0; i--) {
				// 역순으로 방향을 역시계 방향으로 90도 돌려 리스트에 저장
				int nextDirection = (directions.get(i) + 1) % 4;
				directions.add(nextDirection);
			}
		}
		
		return directions;
	}
	
	// 모든 점이 드래곤커브에 포함된 1X1 사각형 개수 계산
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
