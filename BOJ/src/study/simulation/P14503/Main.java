package study.simulation.P14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 환경 속성
	static int N, M;
	static int room[][];
	static boolean isClean[][];
	// 청소기 속성
	static int direction;
	static int row, col;
	static int count = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		room = new int[N][M];
		isClean = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		run();
		System.out.println(count);
		
	}
	
	// 청소기 작동 메서드
	static void run() {
		while(true) {
			// 1. 현재 위치를 청소
			clean();
			// 2. 현재 방향 기준 왼쪽 방향부터 탐색 진행
			
			// a) 왼쪽 방향에 청소할 공간 있다면
			if(inspectLeft(direction)) {
				// 회전하고 한 칸 전진후 1번 진행
				// 회전
				direction -= 1;
				if(direction == -1) {
					direction = 3;
				}
				
				// 방향으로 전진
				if(direction == 0) {		// 북
					// 갈 수 있으면
					if(row > 1 && room[row-1][col] != 1)
					row -= 1;
				}else if(direction == 1) {	// 동
					if(col < M && room[row][col+1] != 1)
					col += 1;
				}else if(direction == 2) {	// 남
					if(row < N && room[row+1][col] != 1)	
					row += 1;
				}else {						// 서 
					if(col > 1 && room[row][col-1] != 1)
					col -= 1;
				}
				continue;
				
			}else {
				// c) 네 방향 모두 청소할 공간이 없다면 한 칸 후진
				if(!inspectLeft(0) && !inspectLeft(1) && !inspectLeft(2) && !inspectLeft(3)) {
					if(direction == 0) {	// 북
						row += 1;
						// d) 후진이 불가능한 경우 작동을 멈춤 
						if(row == N || room[row][col] == 1) {
							break;
						}
					}else if(direction == 1) {	// 동
						col -= 1;
						// d) 후진이 불가능한 경우 작동을 멈춤 
						if(col == -1 || room[row][col] == 1) {
							break;
						}
					}else if(direction == 2) {	// 남
						row -= 1;
						// d) 후진이 불가능한 경우 작동을 멈춤 
						if(row == -1 || room[row][col] == 1) {
							break;
						}
					}else {	// 서
						col += 1;
						// d) 후진이 불가능한 경우 작동을 멈춤 
						if(col == M || room[row][col] == 1) {
							break;
						}
					}
				}else {
					// b) 왼쪽은 없지만 다른 방향 청소가 가능하면 좌회전하고 2번으로 돌아감
					direction -= 1;
					if(direction == -1) {
						direction = 3;
					}
					// clean 함수가 이미 청소한 칸에서는 횟수를 세지 않도록 동작시키면 1번으로 돌려보내도 됌
					continue;
				}
			}
		}
	}
	
	// 왼쪽 방향에 청소할 공간 있는지 확인
	static boolean inspectLeft(int dir) {
		if(dir == 0) {	// 북쪽 방향을 바라보는 경우
			// 좌측에 공간이 존재하고
			if(col > 0) {
				// 벽이 아니면서 아직 청소하지 않은 공간이면 true 반환
				if(room[row][col-1] == 0 && isClean[row][col-1] == false) return true;
			}
			// 청소할 공간 없었다면 false 반환
			return false;
		}
		
		else if(dir == 1) {	// 동쪽 방향을 바라보는 경우
			if(row > 0) {
				if(room[row-1][col] == 0 && isClean[row-1][col] == false) return true;
			}
			// 청소할 공간 없었다면 false 반환
			return false;
		}
		
		else if(dir == 2) {	// 남쪽 방향을 바라보는 경우
			if(col < M - 1) {
				if(room[row][col+1] == 0 && isClean[row][col+1] == false) return true;
			}
			// 청소할 공간 없었다면 false 반환
			return false;
		}
		
		else {	// 서쪽 방향을 바라보는 경우
			if(row < N - 1) {
				if(room[row+1][col] == 0 && isClean[row+1][col] == false) return true;
			}
			// 청소할 공간 없었다면 false 반환
			return false;
		}
	}
	
	// 청소 시행 및 횟수 카운트 메서드
	static void clean() {
		if(isClean[row][col] == false && room[row][col] == 0) {
			isClean[row][col] = true;
			count++;
		}
	}
}
