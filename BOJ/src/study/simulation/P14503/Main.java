package study.simulation.P14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// ȯ�� �Ӽ�
	static int N, M;
	static int room[][];
	static boolean isClean[][];
	// û�ұ� �Ӽ�
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
	
	// û�ұ� �۵� �޼���
	static void run() {
		while(true) {
			// 1. ���� ��ġ�� û��
			clean();
			// 2. ���� ���� ���� ���� ������� Ž�� ����
			
			// a) ���� ���⿡ û���� ���� �ִٸ�
			if(inspectLeft(direction)) {
				// ȸ���ϰ� �� ĭ ������ 1�� ����
				// ȸ��
				direction -= 1;
				if(direction == -1) {
					direction = 3;
				}
				
				// �������� ����
				if(direction == 0) {		// ��
					// �� �� ������
					if(row > 1 && room[row-1][col] != 1)
					row -= 1;
				}else if(direction == 1) {	// ��
					if(col < M && room[row][col+1] != 1)
					col += 1;
				}else if(direction == 2) {	// ��
					if(row < N && room[row+1][col] != 1)	
					row += 1;
				}else {						// �� 
					if(col > 1 && room[row][col-1] != 1)
					col -= 1;
				}
				continue;
				
			}else {
				// c) �� ���� ��� û���� ������ ���ٸ� �� ĭ ����
				if(!inspectLeft(0) && !inspectLeft(1) && !inspectLeft(2) && !inspectLeft(3)) {
					if(direction == 0) {	// ��
						row += 1;
						// d) ������ �Ұ����� ��� �۵��� ���� 
						if(row == N || room[row][col] == 1) {
							break;
						}
					}else if(direction == 1) {	// ��
						col -= 1;
						// d) ������ �Ұ����� ��� �۵��� ���� 
						if(col == -1 || room[row][col] == 1) {
							break;
						}
					}else if(direction == 2) {	// ��
						row -= 1;
						// d) ������ �Ұ����� ��� �۵��� ���� 
						if(row == -1 || room[row][col] == 1) {
							break;
						}
					}else {	// ��
						col += 1;
						// d) ������ �Ұ����� ��� �۵��� ���� 
						if(col == M || room[row][col] == 1) {
							break;
						}
					}
				}else {
					// b) ������ ������ �ٸ� ���� û�Ұ� �����ϸ� ��ȸ���ϰ� 2������ ���ư�
					direction -= 1;
					if(direction == -1) {
						direction = 3;
					}
					// clean �Լ��� �̹� û���� ĭ������ Ƚ���� ���� �ʵ��� ���۽�Ű�� 1������ ���������� ��
					continue;
				}
			}
		}
	}
	
	// ���� ���⿡ û���� ���� �ִ��� Ȯ��
	static boolean inspectLeft(int dir) {
		if(dir == 0) {	// ���� ������ �ٶ󺸴� ���
			// ������ ������ �����ϰ�
			if(col > 0) {
				// ���� �ƴϸ鼭 ���� û������ ���� �����̸� true ��ȯ
				if(room[row][col-1] == 0 && isClean[row][col-1] == false) return true;
			}
			// û���� ���� �����ٸ� false ��ȯ
			return false;
		}
		
		else if(dir == 1) {	// ���� ������ �ٶ󺸴� ���
			if(row > 0) {
				if(room[row-1][col] == 0 && isClean[row-1][col] == false) return true;
			}
			// û���� ���� �����ٸ� false ��ȯ
			return false;
		}
		
		else if(dir == 2) {	// ���� ������ �ٶ󺸴� ���
			if(col < M - 1) {
				if(room[row][col+1] == 0 && isClean[row][col+1] == false) return true;
			}
			// û���� ���� �����ٸ� false ��ȯ
			return false;
		}
		
		else {	// ���� ������ �ٶ󺸴� ���
			if(row < N - 1) {
				if(room[row+1][col] == 0 && isClean[row+1][col] == false) return true;
			}
			// û���� ���� �����ٸ� false ��ȯ
			return false;
		}
	}
	
	// û�� ���� �� Ƚ�� ī��Ʈ �޼���
	static void clean() {
		if(isClean[row][col] == false && room[row][col] == 0) {
			isClean[row][col] = true;
			count++;
		}
	}
}
