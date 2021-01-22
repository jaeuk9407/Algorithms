package DAY10.P10714;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int A[];
	static long dp[][];	// [i][j] 왼쪽은 i번째 cake,오른쪽은 j번째 cake일때 최대로 먹을 수 있는 양
	
	// J가 먹을 차례가 되었는데 바라볼때 왼쪽은 l케이크, 오른쪽은 r케이크가 있을 때 많이 먹는 값
	static long J_eat(int l, int r) {
		if(l==r) return A[l];
		// 먹을 수 있는 경우의 수
		if(dp[l][r] != -1) return dp[l][r];
		int nxtl, nxtr;

		// l을 먹거나...A[l]
		nxtl = l+1;
		if(nxtl == N) nxtl = 0;
		// r을 먹거나...A[r]
		nxtr = r-1;
		if(nxtr<0) nxtr = N-1;
		
		return dp[l][r] = Math.max(A[l] + I_eat(nxtl, r), A[r] + I_eat(l, nxtr));
	}
	// L가 먹을 차례가 되었는데 바라볼때 왼쪽은 l케이크, 오른쪽은 r케이크가 있을 때 많이 먹는 값
	// L가 먹을 차례가 되었는데... J가 많이 먹을 수 있는 값 ==> 선택! 
	static long I_eat(int l, int r) {
		if(l==r) return 0;
		// 먹을 수 있는 경우의 수....가 없고 큰 것만 먹어야 함
		if(dp[l][r] != -1) return dp[l][r];
		int nxtl, nxtr;
		if(A[l] > A[r]) {
			// A[l]을 먹고
			nxtl = l+1;
			if(nxtl == N) nxtl = 0;
			return J_eat(nxtl, r);
		}else {
			// A[r]을 먹음
			nxtr = r-1;
			if(nxtr < 0) nxtr = N-1;
			return J_eat(l, nxtr);
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		dp = new long[N+1][N+1];
		
		for(int i= 0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		if(N == 1) {
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j<N; j++) {
				dp[i][j] = -1;
			}
		}
		
		long ans = 0;
		for(int i =0; i<N; i++) {
			int nxtl, nxtr;
			nxtl = i+1;
			if(nxtl ==N) nxtl = 0;
			nxtr = i-1;
			if(nxtr < 0) nxtr = N-1;
			ans = Math.max(ans, A[i]+I_eat(nxtl, nxtr));
		}
		
		System.out.println(ans);
		
		
	}
}
