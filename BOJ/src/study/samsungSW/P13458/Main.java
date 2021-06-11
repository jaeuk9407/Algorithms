package study.samsungSW.P13458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, B, C;
	static int[] A;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); 
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// �� ������(�������� ���� int ������ ���� �� ���� )
		long subDirector = 0;
		long mainDirector = 0;
		
		// �� ������ ó��
		for(int i = 0; i < N; i++) {
			// �ݵ�� �Ѱ������� �� �� �̻� ����, 
			mainDirector++;
			
			// ������ ��ŭ �ΰ������� �� (���� ����)
			if(A[i] > B) {
				if((A[i] - B) % C == 0) {
					int temp = (A[i] - B)/C;
					subDirector += temp;
				}else {
					int temp = (A[i] - B) / C + 1;
					subDirector += temp;
				}
			}
		}
		
		long answer = mainDirector + subDirector;
		System.out.println(answer);
	}
}
