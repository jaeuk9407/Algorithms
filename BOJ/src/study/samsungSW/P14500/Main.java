package study.samsungSW.P14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] board;
	static List<Info> list = new ArrayList<>();
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		// board ���� �Է�
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ��Ʈ�ι̳� ���� ���� 
		setUp();
		
		// ��ġ ������ ��Ʈ�ι̳� ���
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				// �� ��Ʈ�ι̳� ��ġ ��� ���� �ݺ�
				for(int i = 0; i < list.size(); i++) {
					Info now = list.get(i);
					boolean nowPossible = true;
					int sum = 0;
					
					// 4�� ��� ���
					for(int n = 0; n < 4; n++) {
						int nx = row + now.pointX[n];
						int ny = col + now.pointY[n];
						// ��� �� �ϳ��� ���带 ����� ���� ��ġ ��� Ȯ��
						if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
							nowPossible = false;
							break;
						}
						else {
							sum += board[nx][ny];
						}
					}
					// 4�� ��� ��� �� �ȿ� �����ϸ� ��ġ �����ϹǷ� ������Ʈ
					if(nowPossible) {
						if(answer < sum) {
							answer = sum;
						}
					}
				}
			}
		} // end of ��ġ ������ ��Ʈ�ι̳� ���
		System.out.println(answer);
	}
	
	public static void setUp() {
		// shape1
		list.add(new Info(0, 0, 1, 0, 2, 0, 2, 1));
		list.add(new Info(0, 0, 1, 0, 1, -1, 1, -2));
		list.add(new Info(0, 0, 0, 1, 1, 1, 2, 1));
		list.add(new Info(0, 0, 1, 0, 0, 1, 0, 2));
		
		
		list.add(new Info(0, 0, 0, 1, -1, 1, -2, 1));
		list.add(new Info(0, 0, 0, 1, 0, 2, 1, 2));
		list.add(new Info(0, 0, 0, 1, 1, 0, 2, 0));
		list.add(new Info(0, 0, 1, 0, 1, 1, 1, 2));
		
		// shape2
		list.add(new Info(0, 0, 0, 1, 0, 2, 0, 3));
		list.add(new Info(0, 0, 1, 0, 2, 0, 3, 0));
		
		// shape3
		list.add(new Info(0, 0, 1, 0, 1, -1, 2, -1));
		list.add(new Info(0, 0, 1, 0, 1, 1, 2, 1));
		list.add(new Info(0, 0, 0, 1, 1, 1, 1, 2));
		list.add(new Info(0, 0, 0, 1, 1, 0, 1, -1));
		
		// shape4
		list.add(new Info(0, 0, 0, 1, 0, 2, 1, 1));
		list.add(new Info(0, 0, 1, 0, 1, 1, 2, 0));
		list.add(new Info(0, 0, 1, -1, 1, 0, 1, 1));
		list.add(new Info(0, 0, 1, -1, 1, 0, 2, 0));
		
		// shape5
		list.add(new Info(0, 0, 0, 1, 1, 0, 1, 1));
	}
}
class Info{
	int[] pointX;
	int[] pointY;
	
	public Info(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		pointX = new int[4];
		pointY = new int[4];
		setPointX(x1, x2, x3, x4);
		setPointY(y1, y2, y3, y4);
	}

	public void setPointX(int x1, int x2, int x3, int x4) {
		pointX[0] = x1;
		pointX[1] = x2;
		pointX[2] = x3;
		pointX[3] = x4;
	}

	public void setPointY(int y1, int y2, int y3, int y4) {
		pointY[0] = y1;
		pointY[1] = y2;
		pointY[2] = y3;
		pointY[3] = y4;
	}
}