package DAY09.P2342;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int S[];
	static int Power[][] = new int[5][5];
	static int step[] = new int[100010];
	static int dp[][][] = new int[100010][5][5];
	static int INF = 8000000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int len = line.length() / 2;
		
		S = new int[len + 1];
		StringTokenizer st = new StringTokenizer(line);
		
		for(int i = 1; i <= len; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 중앙에서 이동
		for(int i =0; i <= 4; i++) {
			Power[0][i] = 2;
		}
		
		// 중앙이 아닌 곳에서 근처 이동
		Power[1][2] = Power[1][4] = 3;
		Power[2][1] = Power[2][3] = 3;
		Power[3][2] = Power[3][4] = 3;
		Power[4][1] = Power[4][3] = 3;
		
		// 반대편 이동
		Power[1][3] =Power[3][1] = Power[2][4] = Power[4][2] = 4;
		
		// 같은 곳
		for(int i = 1; i <= 4; i++) {
			Power[i][i] = 1;
		}
		
		for(int i =0; i<= len; i++) {
			for(int l = 0; l<=4; l++) {
				for(int r =0; r <=4; r++) {
					dp[i][l][r] = INF;
				}
			}
		}
		dp[0][0][0] = 0;
				
		// 단계를 진행해보자
		for(int i = 0; i < len; i ++) {
			// 할 일은 <i>단계의 결과는 잘 끝냈고, <i+1>단계로 가고 싶음.
			// 밟아야 할 DDR의 번호는 i + 1을 예정임 
			for(int l = 0; l <= 4; l++) {
				for(int r = 0; r <= 4; r++) {
					int ddr = S[i + 1], used_power;
					// dp[i][l][r] : i단계일 때 왼발 l, 오른발 r일 때 소모된 힘
					
					// 처리할 것들... 같은 위치는 안됨!!!
					// ddr == r, l == ddr
					// 가장 작은 힘일때만 넣고 싶음
					
					
					// 왼발을 움직여봄 -> dp[i+1][S[i+1][r]
					used_power = dp[i][l][r] + Power[l][ddr];
					if(ddr != r && used_power < dp[i+1][ddr][r]) {
						dp[i + 1][ddr][r] = used_power;
					}
					
					// 오른발을 움직여봄 -> dp[i+1][l][S[i+1]
					used_power = dp[i][l][r] + Power[r][ddr];
					if(ddr != l && used_power < dp[i+1][l][ddr]) {
						dp[i + 1][l][ddr] = used_power;
					}
				}
			}
		}
		
		// 무엇을 출력할 것인가?? .... n 단계까지 왔을 때 많은 발의 상태가 있을텐데 그중 가장 작은값 
		int ans = INF;
		for(int l = 0; l <= 4; l++) {
			for(int r = 0; r <= 4; r++) {
				if(dp[len][l][r] < ans) {
					ans = dp[len][l][r];
				}
			}
		}
		
		System.out.println(ans);
	}

}
