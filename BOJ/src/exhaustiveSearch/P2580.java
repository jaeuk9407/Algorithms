package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2580 {
	static int[][] totalMap = new int[9][9];
	static int[][][] smallMaps = new int[9][3][3];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				totalMap[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(totalMap[i]));
		}
		solve(0, 0);
		
	}
	private static void solve(int row, int col) {
		
		// 행이 모두 채워졌을 경우 다음 행의 첫 번째 열부터 시작
		if(col == 9) {
			solve(row+1, 0);
			return;
		}
		
		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(totalMap[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			
			// 출력 후 시스템 종료
			System.exit(0);
		}
		
		// 현재 위치가 0이라면 1부터 9까지 중 가능한 수 탐색
		if(totalMap[row][col] == 0) {
			for(int i = 1; i<= 9; i++) {
				// i 값이 중복되지 않는지 검사
				if(possibility(row, col, i)) {
					totalMap[row][col] = i;
					solve(row, col + 1);
				}
			}
			
			// 1 ~ 9 까지 넣은 값중 답이 존재하지 않으면 다시 0으로 셋팅해 값 변경을 기다린다.
			// 검사할 수직선, 수평선, 작은 정사각형 중 0이 여러개 존재하는 경우 => 두 개의 0이 값을 뒤바꿔 들어간 경우 등..
			totalMap[row][col] = 0;
			return;
		}
		solve(row, col + 1);
		
	}
	
	private static boolean possibility(int row, int col, int value) {
		
		// 같은 행, 열에 있는 원소들 중 겹치는 열 원소가 있는지 검사. 
		for(int i = 0; i < 9; i++) {
			if(totalMap[row][i] == value || totalMap[i][col] == value) {
				return false;
			}
		}
		
		// 3*3 칸에 중복되는 원소가 있는지 검사
		int set_row = (row / 3) * 3;	// value가 속한 3 * 3의 행의 첫 위치
		int set_col = (col / 3) * 3;	// value가 속한 3 * 3의 열의 첫 위치 
		
		for(int i = set_row; i < set_row + 3; i++) {
			for(int j = set_col ; j < set_col + 3; j++) {
				if(totalMap[i][j] == value) {
					return false;
				}
			}
		}
		
		return true;	// 중복되는 것이 없을 경우 true 반환
	}

}
