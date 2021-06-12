package study.samsungSW.P14499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[] dice = new int[7];
	static int[][] board;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 보드 정보 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 이동 명령 이행
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			// 이동할 방향
			int oper = Integer.parseInt(st.nextToken());
			// 이동할 다음 위치
			int nx = x + dx[oper - 1];
			int ny = y + dy[oper - 1];
			// 지도의 밖으로 나가지 않으면 이동
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				move(oper);
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void move(int dir) {
		int[] temp = dice.clone();
		if(dir == 1) {	// 동
			dice[4] = temp[6]; dice[1] = temp[4];
			dice[3] = temp[1]; dice[6] = temp[3];
		}else if(dir == 2) {	// 서 
			dice[4] = temp[1]; dice[1] = temp[3];
			dice[3] = temp[6]; dice[6] = temp[4];
		}else if(dir == 3) {	// 북 
			dice[2] = temp[1]; dice[1] = temp[5];
			dice[5] = temp[6]; dice[6] = temp[2];
		}else {	// 남
			dice[2] = temp[6]; dice[1] = temp[2];
			dice[5] = temp[1]; dice[6] = temp[5];
		}
		// 이동할 다음 위치
		int nx = x + dx[dir - 1];
		int ny = y + dy[dir - 1];
		// 이동한 지도 위치가 값이 0이면 주사위의 밑면의 값을 지도에 입력
		if(board[nx][ny] == 0) {
			board[nx][ny] = dice[6];
		}else {	// 지도에 값이 있다면 주사위의 밑면에 보드의 값을 복사, 보드는 0
			dice[6] = board[nx][ny];
			board[nx][ny] = 0;
		}
		
		x = nx;
		y = ny;
		
		// 이동 후 윗면 값을 저장
		list.add(dice[1]);
	}
}
