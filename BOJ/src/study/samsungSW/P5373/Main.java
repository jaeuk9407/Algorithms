package study.samsungSW.P5373;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int cases;
	static char[][] cube = new char[6][9];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		cases = Integer.parseInt(br.readLine());
		for(int k = 0; k < cases; k++) {
			init();
			int operNum = Integer.parseInt(br.readLine());
			String[] opers = new String[operNum];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < operNum; i++) {
				opers[i] = st.nextToken();
				rotate(opers[i]);
			}
			printUp();
		}
	}
	
	public static void rotate(String oper) {
		char[][] temp = copy();
		int index = -1;
		
		if(oper.charAt(0) == 'U') {
			index = 0;
		}else if(oper.charAt(0) == 'D') {
			index = 1;
		}else if(oper.charAt(0) == 'F') {
			index = 2;
		}else if(oper.charAt(0) == 'B') {
			index = 3;
		}else if(oper.charAt(0) == 'L') {
			index = 4;
		}else if(oper.charAt(0) == 'R') {
			index = 5;
		}
		
		if(oper.charAt(1) == '+') {
			// 돌린 면의 숫자 재배치
			cube[index][0] = temp[index][6]; cube[index][1] = temp[index][3]; cube[index][2] = temp[index][0];
			cube[index][3] = temp[index][7]; cube[index][4] = temp[index][4]; cube[index][5] = temp[index][1];
			cube[index][6] = temp[index][8]; cube[index][7] = temp[index][5]; cube[index][8] = temp[index][2];
			if(oper.charAt(0) == 'U') {
				cube[2][0] = temp[5][0]; cube[2][1] = temp[5][1]; cube[2][2] = temp[5][2];
				cube[4][0] = temp[2][0]; cube[4][1] = temp[2][1]; cube[4][2] = temp[2][2];
				cube[3][0] = temp[4][0]; cube[3][1] = temp[4][1]; cube[3][2] = temp[4][2];
				cube[5][0] = temp[3][0]; cube[5][1] = temp[3][1]; cube[5][2] = temp[3][2];
			}else if(oper.charAt(0) == 'D') {
				cube[5][6] = temp[2][6]; cube[5][7] = temp[2][7]; cube[5][8] = temp[2][8];
				cube[3][6] = temp[5][6]; cube[3][7] = temp[5][7]; cube[3][8] = temp[5][8];
				cube[4][6] = temp[3][6]; cube[4][7] = temp[3][7]; cube[4][8] = temp[3][8];
				cube[2][6] = temp[4][6]; cube[2][7] = temp[4][7]; cube[2][8] = temp[4][8];
			}else if(oper.charAt(0) == 'F') {
				cube[5][0] = temp[0][6]; cube[5][3] = temp[0][7]; cube[5][6] = temp[0][8];
				cube[1][2] = temp[5][0]; cube[1][1] = temp[5][3]; cube[1][0] = temp[5][6];
				cube[4][2] = temp[1][0]; cube[4][5] = temp[1][1]; cube[4][8] = temp[1][2];
				cube[0][8] = temp[4][2]; cube[0][7] = temp[4][5]; cube[0][6] = temp[4][8];
			}else if(oper.charAt(0) == 'B') {
				cube[4][6] = temp[0][0]; cube[4][3] = temp[0][1]; cube[4][0] = temp[0][2];
				cube[1][6] = temp[4][0]; cube[1][7] = temp[4][3]; cube[1][8] = temp[4][6];
				cube[5][8] = temp[1][6]; cube[5][5] = temp[1][7]; cube[5][2] = temp[1][8];
				cube[0][0] = temp[5][2]; cube[0][1] = temp[5][5]; cube[0][2] = temp[5][8];
			}else if(oper.charAt(0) == 'L') {
				cube[2][0] = temp[0][0]; cube[2][3] = temp[0][3]; cube[2][6] = temp[0][6];
				cube[1][0] = temp[2][0]; cube[1][3] = temp[2][3]; cube[1][6] = temp[2][6];
				cube[3][8] = temp[1][0]; cube[3][5] = temp[1][3]; cube[3][2] = temp[1][6];
				cube[0][6] = temp[3][2]; cube[0][3] = temp[3][5]; cube[0][0] = temp[3][8];
			}else if(oper.charAt(0) == 'R') {
				cube[3][6] = temp[0][2]; cube[3][3] = temp[0][5]; cube[3][0] = temp[0][8];
				cube[1][8] = temp[3][0]; cube[1][5] = temp[3][3]; cube[1][2] = temp[3][6];
				cube[2][2] = temp[1][2]; cube[2][5] = temp[1][5]; cube[2][8] = temp[1][8];
				cube[0][2] = temp[2][2]; cube[0][5] = temp[2][5]; cube[0][8] = temp[2][8];
			}
		}else if(oper.charAt(1) == '-') {
			// 돌린 면의 숫자 재배치
			cube[index][0] = temp[index][2]; cube[index][1] = temp[index][5]; cube[index][2] = temp[index][8];
			cube[index][3] = temp[index][1]; cube[index][4] = temp[index][4]; cube[index][5] = temp[index][7];
			cube[index][6] = temp[index][0]; cube[index][7] = temp[index][3]; cube[index][8] = temp[index][6];
			if(oper.charAt(0) == 'U') {
				cube[5][0] = temp[2][0]; cube[5][1] = temp[2][1]; cube[5][2] = temp[2][2];
				cube[2][0] = temp[4][0]; cube[2][1] = temp[4][1]; cube[2][2] = temp[4][2];
				cube[4][0] = temp[3][0]; cube[4][1] = temp[3][1]; cube[4][2] = temp[3][2];
				cube[3][0] = temp[5][0]; cube[3][1] = temp[5][1]; cube[3][2] = temp[5][2];
			}else if(oper.charAt(0) == 'D') {
				cube[2][6] = temp[5][6]; cube[2][7] = temp[5][7]; cube[2][8] = temp[5][8];
				cube[5][6] = temp[3][6]; cube[5][7] = temp[3][7]; cube[5][8] = temp[3][8];
				cube[3][6] = temp[4][6]; cube[3][7] = temp[4][7]; cube[3][8] = temp[4][8];
				cube[4][6] = temp[2][6]; cube[4][7] = temp[2][7]; cube[4][8] = temp[2][8];
			}else if(oper.charAt(0) == 'F') {
				cube[4][8] = temp[0][6]; cube[4][5] = temp[0][7]; cube[4][2] = temp[0][8];
				cube[1][0] = temp[4][2]; cube[1][1] = temp[4][5]; cube[1][2] = temp[4][8];
				cube[5][6] = temp[1][0]; cube[5][3] = temp[1][1]; cube[5][0] = temp[1][2];
				cube[0][6] = temp[5][0]; cube[0][7] = temp[5][3]; cube[0][8] = temp[5][6];
			}else if(oper.charAt(0) == 'B') {
				cube[5][2] = temp[0][0]; cube[5][5] = temp[0][1]; cube[5][8] = temp[0][2];
				cube[1][8] = temp[5][2]; cube[1][7] = temp[5][5]; cube[1][6] = temp[5][8];
				cube[4][0] = temp[1][6]; cube[4][3] = temp[1][7]; cube[4][6] = temp[1][8];
				cube[0][2] = temp[4][0]; cube[0][1] = temp[4][3]; cube[0][0] = temp[4][6];
			}else if(oper.charAt(0) == 'L') {
				cube[0][0] = temp[2][0]; cube[0][3] = temp[2][3]; cube[0][6] = temp[2][6];
				cube[3][8] = temp[0][0]; cube[3][5] = temp[0][3]; cube[3][2] = temp[0][6];
				cube[1][6] = temp[3][2]; cube[1][3] = temp[3][5]; cube[1][0] = temp[3][8];
				cube[2][0] = temp[1][0]; cube[2][3] = temp[1][3]; cube[2][6] = temp[1][6];
			}else if(oper.charAt(0) == 'R') {
				cube[2][2] = temp[0][2]; cube[2][5] = temp[0][5]; cube[2][8] = temp[0][8];
				cube[1][2] = temp[2][2]; cube[1][5] = temp[2][5]; cube[1][8] = temp[2][8];
				cube[3][6] = temp[1][2]; cube[3][3] = temp[1][5]; cube[3][0] = temp[1][8];
				cube[0][8] = temp[3][0]; cube[0][5] = temp[3][3]; cube[0][2] = temp[3][6];
			}
		}
	}
	
	// 초기 cube의 각 면에 지정된 색을 칠해주는 메서드
	public static void init() {
		char color = '-';
		for(int k = 0; k < 6; k++) {
			if(k == 0) color = 'w';
			else if(k == 1) color = 'y';
			else if(k == 2) color = 'r';
			else if(k == 3) color = 'o';
			else if(k == 4) color = 'g';
			else if(k == 5) color = 'b';
			for(int i = 0; i < 9; i++) {
				cube[k][i] = color;
			}
		}
	}
	// cube 배열 복사본을 생성해 반환하는 메서드
	public static char[][] copy(){
		char[][] temp = new char[6][9];
		for(int k = 0; k < 6; k++) {
			for(int i = 0; i < 9; i++) {
				temp[k][i] = cube[k][i];
			}
		}
		return temp;
	}
	
	public static void printUp() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 3; i++) {
			sb.append(cube[0][i * 3]);
			sb.append(cube[0][i * 3 + 1]);
			sb.append(cube[0][i * 3 + 2]);
			if(i != 2) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	// test를 위해 cube의 모든 면을 출력하는 메서드
	public static void print() {
		String name = "";
		for(int k = 0; k < 6; k++) {
			if(k == 0) name = "윗면";
			else if(k == 1) name = "아랫면";
			else if(k == 2) name = "앞면";
			else if(k == 3) name = "뒷면";
			else if(k == 4) name = "왼쪽면";
			else if(k == 5) name = "오른쪽면";
			System.out.println(name);
			System.out.println(Arrays.toString(cube[k]));
			System.out.println();
		}
	}
}
