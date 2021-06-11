package study.samsungSW.P12100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, answer, map[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
				
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		game(0);
		System.out.println(answer);
		
	}
	/* 
	 * 매 동작 전 백트래킹이 가능하도록 map을 copy배열에 복사해둔다.
	 * 동작 후 재귀가 끝났을 때 copy 배열의 값을 map으로 불러와 기존 값을 복구한다.
	 */
	
	public static void game(int count) {
		if(count == 5) {
			findMax();
			return;
		}
		// 복사
		int copy[][] = new int[N][N];
		for(int i = 0; i < N; i++)
			copy[i] = map[i].clone();
		
		// 이동
		for(int i = 0; i < 4; i++) {
			move(i);
			game(count + 1);
			// 다른 방향으로 돌려보기 위해 이전 상태로 복사
			for(int a = 0; a < N; a++) {
				map[a] = copy[a].clone();
			}
		}
	}
	
	// 상하좌우로 이동
	public static void move(int dir) {

		if(dir == 0) {	// 위쪽
			for(int i = 0; i < N; i++) {
				int index = 0;	// 값을 넣을 위치 
				int block = 0;	// 최근 블록의 수
				for(int j = 0; j < N; j++) {
					// j행 i열이 0이 아니라면 
					if(map[j][i] != 0) {
						// 이전 블록과 같은 값이면 더해주고 블록값 초기화
						if(block == map[j][i]) {
							map[index - 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						}
						// 이전 블록과 다른 값이면
						else {
							block = map[j][i];	// 블록값 저장 
							map[j][i] = 0;
							map[index][i] = block;	// 다음 위치에 블록값 입력
							index++;
						}
					}
				}
			}
		}else if(dir == 1) {	// 아래 
			for(int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for(int j = N - 1; j >= 0; j--) {
					if(map[j][i] != 0) {
						if(block == map[j][i]) {
							map[index + 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						}
						else {
							block = map[j][i];
							map[j][i] = 0;
							map[index][i] = block;
							index--;
						}
					}
				}
			}
		}else if(dir == 2) {	// 
			for(int i = 0; i < N ; i++) {
				int index = 0;
				int block = 0;
				for(int j = 0; j < N; j++) {
					if(map[i][j] != 0) {
						if(block == map[i][j]) {
							map[i][index - 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						}
						else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index++;
						}
					}
				}
			}
		}else if(dir == 3) {	// 
			for(int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for(int j = N - 1; j >= 0; j--) {
					if(map[i][j] != 0) {
						if(block == map[i][j] ) {
							map[i][index + 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						}
						else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index--;
						}
					}
				}
			}
		}
	}
	
	public static void findMax() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				answer = Math.max(answer, map[i][j]);
			}
		}
	}
}
