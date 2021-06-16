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
		
		// �Է� ���� ���� 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �� ����
		dfs(0);
		System.out.println(answer);
	}
	
	// dfs�� �� ����
	public static void dfs(int cnt) {
		
		// ������ ���� ������ ������, �Ƿ����� �����
		if(cnt == N) {
			calc();
			return;
		}
		
		// A���� ���� �����ϸ� �����ϰ� ��� ȣ��, ȣ���� ������ �ٽ� �����·� ����
		if(cntA < N / 2) {
			team[cnt] = 'a';
			cntA++;
			dfs(cnt + 1);
			cntA--;
		}
		// B���� ���� �����ϸ� �����ϰ� ��� ȣ��, ȣ���� ������ �ٽ� �����·� ����
		if(cntB < N / 2) {
			team[cnt] = 'b';
			cntB++;
			dfs(cnt + 1);
			cntB--;
		}
	}
	
	// �Ƿ��� ����ϰ�, answer�� ���� �����ϸ� ����
	public static void calc() {
		int diff = 0;	// �� ������ �Ƿ���
		int scoreA = 0;	// A���� �Ƿ� ����
		int scoreB = 0;	// B���� �Ƿ� ����
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// �� ������ ���� ���̰�
				if(team[i] == team[j]) {
					// �ش��ϴ� ���� ���ھ� ����
					if(team[i] == 'a') scoreA += board[i][j];
					else scoreB += board[i][j];
				}
			}
		}
		// �Ƿ��� ����ؼ� answer ���� �����ϸ� ����
		diff = Math.abs(scoreA - scoreB);
		answer = Math.min(diff, answer);
	}
}
