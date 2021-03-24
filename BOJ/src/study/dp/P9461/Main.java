package study.dp.P9461;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int T, N;
	static long P[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		P = new long[101];
		
		// 나선 형태를 형성하기까지의 초기화
		P[1] = 1;	P[2] = 1;	P[3] = 1;
		P[4] = 2;	P[5] = 2;
		
		// 입력 범위까지 미리 세팅
		for(int i = 6; i <= 100; i++) {
			P[i] = P[i - 5] + P[i - 1];
		}
		
		// 테스트케이스 
		T = Integer.parseInt(br.readLine());
		
		// 테스트케이스 개수만큼 입력받아 해당 value를 출력 
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(P[N]);
		}
		
		br.close();
	}

}
