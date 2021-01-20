package DAY08.P11049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Matrix list[];
	static long dp[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new long[N+1][N+1];
		list = new Matrix[501];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			Matrix tmp = new Matrix(a, b);
			list[i] = tmp;
		}
		
		
		calc(0, N-1);
		System.out.println(dp[0][N-1]);
		
		
	}// end of main function
	
	// 행렬의 s부터 e까지 계산을 해서 최적의 값을 내는 함수
	static long calc(int s, int e) {
		if(e - s == 1) {
			return list[s].a * list[s].b * list[e].b;
		}
		if(e == s) {
			return 0;
		}
		// 부분으로 다 나눠서 괜찮은 값을 구하는데....
		// 처음으로 계산을 하는 경우는 일단 계산함
		
		dp[s][e] = 0;
		
		for(int mid = s; mid <= e-1; mid++) {
			long sum_tmp;
			long last_tmp = list[s].a * list[mid].b * list[e].b;	// (s ~ mid), (mid+1 ~ e) 구간에서 나온 각각의 결과인 두 행렬곱에 필요한 연산
			// calc(s, e)를 계산한 적이 있으면, 그때 계산했던 결과를 사용함 
			if(dp[s][mid] != 0 && dp[mid+1][e] != 0) {
				// 모두 값이 있는 경우
//				System.out.println("case 1");
				sum_tmp = dp[s][mid] + dp[mid+1][e] + last_tmp;
			}else if(dp[s][mid] != 0) {
				// s ~ mid만 있는 경우
//				System.out.println("case 2");
				sum_tmp = dp[s][mid] + calc(mid + 1, e) + last_tmp;
			}else if(dp[mid+1][e] != 0) {
//				System.out.println("case 3");
				// mid+1 ~ e만 있는 경우 
				sum_tmp = calc(s,mid) + dp[mid+1][e] + last_tmp;
			}else {
//				System.out.println("case 4");
				// 모두 값이 없는 경우
				sum_tmp = calc(s,mid) + calc(mid + 1, e) + last_tmp;
			}
//			System.out.println("s, mid, e, dp[s][e], tmp: "+s+", "+mid+", "+e+", "+dp[s][e]+", "+tmp);
			if(dp[s][e] == 0 || sum_tmp < dp[s][e]) dp[s][e] = sum_tmp;	// 초기값이거나 갱신이 필요한 경우
		}
		return dp[s][e];
	}

}

class Matrix{
	int a, b;

	public Matrix(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
}