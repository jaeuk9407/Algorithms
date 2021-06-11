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
		
		// 각 감독관(감독관의 수는 int 범위를 넘을 수 있음 )
		long subDirector = 0;
		long mainDirector = 0;
		
		// 각 시험장 처리
		for(int i = 0; i < N; i++) {
			// 반드시 총감독관은 한 명 이상 들어가고, 
			mainDirector++;
			
			// 부족한 만큼 부감독관이 들어감 (음수 방지)
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
