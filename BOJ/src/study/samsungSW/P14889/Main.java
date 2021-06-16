package study.samsungSW.P14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, answer, cntA, cntB;
	static int[][] board;
	static char[] team;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		team = new char[N];
		answer = Integer.MAX_VALUE;
		board = new int[N][N];
		
		// 입력 정보 저장 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 팀 배정
		dfs(0);
		System.out.println(answer);
	}
	
	// dfs로 팀 배정
	public static void dfs(int cnt) {
		
		// 끝까지 선수 배정이 끝나면, 실력차를 계산함
		if(cnt == N) {
			calc();
			return;
		}
		
		// A팀에 배정 가능하면 배정하고 재귀 호출, 호출이 끝나면 다시 원상태로 복구
		if(cntA < N / 2) {
			team[cnt] = 'a';
			cntA++;
			dfs(cnt + 1);
			cntA--;
		}
		// B팀에 배정 가능하면 배정하고 재귀 호출, 호출이 끝나면 다시 원상태로 복구
		if(cntB < N / 2) {
			team[cnt] = 'b';
			cntB++;
			dfs(cnt + 1);
			cntB--;
		}
	}
	
	// 실력차 계산하고, answer를 갱신 가능하면 갱신
	public static void calc() {
		int diff = 0;	// 두 팀간의 실력차
		int scoreA = 0;	// A팀의 실력 점수
		int scoreB = 0;	// B팀의 실력 점수
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 두 선수가 같은 팀이고
				if(team[i] == team[j]) {
					// 해당하는 팀의 스코어 증가
					if(team[i] == 'a') scoreA += board[i][j];
					else scoreB += board[i][j];
				}
			}
		}
		// 실력차 계산해서 answer 갱신 가능하면 갱신
		diff = Math.abs(scoreA - scoreB);
		answer = Math.min(diff, answer);
	}
}
