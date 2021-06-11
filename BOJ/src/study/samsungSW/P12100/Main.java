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
	 * �� ���� �� ��Ʈ��ŷ�� �����ϵ��� map�� copy�迭�� �����صд�.
	 * ���� �� ��Ͱ� ������ �� copy �迭�� ���� map���� �ҷ��� ���� ���� �����Ѵ�.
	 */
	
	public static void game(int count) {
		if(count == 5) {
			findMax();
			return;
		}
		// ����
		int copy[][] = new int[N][N];
		for(int i = 0; i < N; i++)
			copy[i] = map[i].clone();
		
		// �̵�
		for(int i = 0; i < 4; i++) {
			move(i);
			game(count + 1);
			// �ٸ� �������� �������� ���� ���� ���·� ����
			for(int a = 0; a < N; a++) {
				map[a] = copy[a].clone();
			}
		}
	}
	
	// �����¿�� �̵�
	public static void move(int dir) {

		if(dir == 0) {	// ����
			for(int i = 0; i < N; i++) {
				int index = 0;	// ���� ���� ��ġ 
				int block = 0;	// �ֱ� ����� ��
				for(int j = 0; j < N; j++) {
					// j�� i���� 0�� �ƴ϶�� 
					if(map[j][i] != 0) {
						// ���� ��ϰ� ���� ���̸� �����ְ� ��ϰ� �ʱ�ȭ
						if(block == map[j][i]) {
							map[index - 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						}
						// ���� ��ϰ� �ٸ� ���̸�
						else {
							block = map[j][i];	// ��ϰ� ���� 
							map[j][i] = 0;
							map[index][i] = block;	// ���� ��ġ�� ��ϰ� �Է�
							index++;
						}
					}
				}
			}
		}else if(dir == 1) {	// �Ʒ� 
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
