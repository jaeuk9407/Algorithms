package study.samsungSW.P14890;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L, answer;
	static int[][] board;
	static boolean[][] isPlaced;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		isPlaced = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행 기준 검사
		for(int i = 0; i < N; i++) {
			boolean isPossible = true;
			for(int j = 0; j < N - 1; j++) {
				// 경사가 1 차이나는 지점을 만나면 
				if(Math.abs(board[i][j] - board[i][j + 1]) == 1) {
					// 좌상향 경사로인 경우
					// 경사로를 놓을 수 있는 길이가 부족하거나, 
					if(board[i][j] > board[i][j + 1]) {
						if(j + L > N - 1) {
							isPossible = false;
							continue;
						}
						// 그 길이의 블록에 이미 놓아진 경사로가 이미 있거나, 높이가 1 낮은 블록들이 아니라면 불가
						for(int k = 1; k <= L; k++) {
							if(isPlaced[i][j + k] || board[i][j + k] + 1 != board[i][j]) {
								isPossible = false;
								break;
							}
						}
						if(isPossible) {
							for(int k = 1; k <= L; k++) {
								isPlaced[i][j + k] = true;
							}
						}
					}else {	// 우상향 경사로인 경우
						if(j - L + 1 < 0) {
							isPossible = false;
							continue;
						}
						for(int k = 0; k < L; k++) {
							if(isPlaced[i][j - k] || board[i][j - k] + 1 != board[i][j + 1]) {
								isPossible = false;
								break;
							}
						}
						if(isPossible) {
							for(int k = 0; k < L; k++) {
								isPlaced[i][j - k] = true;
							}
						}
					}
				}else if(Math.abs(board[i][j] - board[i][j + 1]) > 1) {
					isPossible = false;
				}
			}
			// 경사로를 놓을 수 있거나, 모두 높이가 같다면 answer 증가
			if(isPossible) {
				answer++;
			}
		}
		
		// 경사로 초기화
		isPlaced = new boolean[N][N];
		
		
		// 열 기준 검사
		for(int j = 0; j < N; j++) {
			boolean isPossible = true;
			for(int i = 0; i < N - 1; i++) {
				// 경사가 1 차이나는 지점을 만나면 
				if(Math.abs(board[i][j] - board[i + 1][j]) == 1) {
					// 경사로를 놓을 수 있는 길이가 부족하거나, 
					if(board[i][j] > board[i + 1][j]) {
						if(i + L > N - 1) {
							isPossible = false;
							continue;
						}
						// 그 길이의 블록에 이미 놓아진 경사로가 이미 있거나, 높이가 1 낮은 블록들이 아니라면 불가
						for(int k = 1; k <= L; k++) {
							if(isPlaced[i + k][j] || board[i + k][j] + 1 != board[i][j]) {
								isPossible = false;
								break;
							}
						}
						if(isPossible) {
							for(int k = 1; k <= L; k++) {
								isPlaced[i + k][j] = true;
							}
						}
					}else {	
						if(i - L + 1 < 0) {
							isPossible = false;
							continue;
						}
						for(int k = 0; k < L; k++) {
							if(isPlaced[i - k][j] || board[i - k][j] + 1 != board[i + 1][j]) {
								isPossible = false;
								break;
							}
						}
						if(isPossible) {
							for(int k = 0; k < L; k++) {
								isPlaced[i - k][j] = true;
							}
						}
					}
				}else if(Math.abs(board[i][j] - board[i + 1][j]) > 1) {
					isPossible = false;
				}
			}
			// 경사로를 놓을 수 있거나, 모두 높이가 같다면 answer 증가
			if(isPossible) {
				answer++;
			}
		}
		System.out.println(answer);
	} // end of main
}
