package study.dp.P9461;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int T, N;
	static long P[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		P = new long[101];
		
		// ���� ���¸� �����ϱ������ �ʱ�ȭ
		P[1] = 1;	P[2] = 1;	P[3] = 1;
		P[4] = 2;	P[5] = 2;
		
		// �Է� �������� �̸� ����
		for(int i = 6; i <= 100; i++) {
			P[i] = P[i - 5] + P[i - 1];
		}
		
		// �׽�Ʈ���̽� 
		T = Integer.parseInt(br.readLine());
		
		// �׽�Ʈ���̽� ������ŭ �Է¹޾� �ش� value�� ��� 
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(P[N]);
		}
		
		br.close();
	}

}
