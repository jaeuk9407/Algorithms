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
		
		// �� ���� �˻�
		for(int i = 0; i < N; i++) {
			boolean isPossible = true;
			for(int j = 0; j < N - 1; j++) {
				// ��簡 1 ���̳��� ������ ������ 
				if(Math.abs(board[i][j] - board[i][j + 1]) == 1) {
					// �»��� ������ ���
					// ���θ� ���� �� �ִ� ���̰� �����ϰų�, 
					if(board[i][j] > board[i][j + 1]) {
						if(j + L > N - 1) {
							isPossible = false;
							continue;
						}
						// �� ������ ��Ͽ� �̹� ������ ���ΰ� �̹� �ְų�, ���̰� 1 ���� ��ϵ��� �ƴ϶�� �Ұ�
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
					}else {	// ����� ������ ���
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
			// ���θ� ���� �� �ְų�, ��� ���̰� ���ٸ� answer ����
			if(isPossible) {
				answer++;
			}
		}
		
		// ���� �ʱ�ȭ
		isPlaced = new boolean[N][N];
		
		
		// �� ���� �˻�
		for(int j = 0; j < N; j++) {
			boolean isPossible = true;
			for(int i = 0; i < N - 1; i++) {
				// ��簡 1 ���̳��� ������ ������ 
				if(Math.abs(board[i][j] - board[i + 1][j]) == 1) {
					// ���θ� ���� �� �ִ� ���̰� �����ϰų�, 
					if(board[i][j] > board[i + 1][j]) {
						if(i + L > N - 1) {
							isPossible = false;
							continue;
						}
						// �� ������ ��Ͽ� �̹� ������ ���ΰ� �̹� �ְų�, ���̰� 1 ���� ��ϵ��� �ƴ϶�� �Ұ�
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
			// ���θ� ���� �� �ְų�, ��� ���̰� ���ٸ� answer ����
			if(isPossible) {
				answer++;
			}
		}
		System.out.println(answer);
	} // end of main
}
