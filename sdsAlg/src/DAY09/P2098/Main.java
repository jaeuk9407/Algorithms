package DAY09.P2098;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N; 
	private static int W[][] = new int[16][16]; // i -> j까지 이동하는 거리
	private static int dp[][] =new int[(1<<16)][16]; 	//dp[선택한 도시들][마지막에 여행한 도시]
	private static final int INF = 20000000;
	// 시작점으로 다시 와야함
	// 0번도시, 1번도시, 2번도시......
	// 0 0 0 0 0 1 1 0 0 0 0 : 6, 7번 도시만 선택함
	
	// x \= 1 << 10 -> masking
	// x&(1<<10); -> check
	// 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
				
		// dp 배열 초기화 
		for(int i = 0; i <(1<<16); i++) {
			for(int j = 0; j <16; j++) {
				dp[i][j] = INF;
			}
		}
		
		// 시작점 셋팅 : 0 번째 도시에서 시작함 .... [0번째 도시를 거쳐왔고][현재 0번째에 있으니까] 
		dp[1][0] = 0;
		for(int i = 0; i <(1<<N); i++) {
			// 전개 dp[i][j]
			for(int j = 0; j < N ; j ++) {
				for(int k = 0; k < N; k++) {
					// k로 갈수 있는지
					if(bit_check(i, k) == true) continue;
					if(W[j][k] == 0) continue;
					// 간다 
					// 값이 최소면 업데이트
					int nxt = bit_set(i, k);
					dp[nxt][k] = Math.min(dp[nxt][k], dp[i][j]+W[j][k]);
				}
			}
		}
		
		// 모든 도시를 순회했고, 시작으로 돌아가야함 
		int answer = INF;
		int last_state = (1<<N) -1;	// 모든 도시를 방문한 상태이고
		for(int i = 0; i < N; i++) {
			if(W[i][0] == 0) continue; // 길이 없음
			int tmp = dp[last_state][i] + W[i][0];
			if(tmp < answer) answer = tmp;
		}
		
		
		// Test
//		for(int i = 0; i< N; i++) {
//			for(int j = 0; j<N;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println("");
//		}
		
		System.out.println(answer);
	} // end of main
	
	
	// pos 번째에 비트를 1로 셋팅함 : 가장 낮은 자리수가 0
	public static int bit_set(int orgbit, int pos) {
		return orgbit | (1<<pos);
	}
	
	// 특정 자리의 비트를 0으로 셋팅
	public static int bit_unset(int orgbit, int pos) {
		return orgbit & (~(1<<pos));
	}
	
	// 특정 자리의 비트가 0인지 1인지 확인 
	public static boolean bit_check(int orgbit, int pos) {
		if((orgbit & (1<<pos))==0) return false;
		return true;
	}

}
