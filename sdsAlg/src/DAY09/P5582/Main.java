package DAY09.P5582;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String str1, str2;
	static int len1, len2, ans;
	static int dp[][];		// 활용해서 메모이제이션 
	
	
	
	// p1, p2로 끝나는 문자열의 공통 부분 문자열
	// 반대로 p1, p2부터 시작하는 공통 부분 문자열도 가능하지만, 
	// 메모이제이션 활용성 측면에서 거꾸로 탐색하는 것이 낫다. 
	static int calc(int p1, int p2) {
		if(p1 < 0 || p2 < 0) {
			return 0;
		}
//		if(p1 > len1-1 || p2 > len2-1) {
//			return 0;
//		}
		// 이미 저장된 값이 있는 경우
		if(dp[p1][p2] != -1) {
			return dp[p1][p2];
		}
		// 공통 문자열을 찾은 경우 ==> 두 문자열 모두 한 칸씩 이동
		if(str1.charAt(p1) == str2.charAt(p2)) {
			dp[p1][p2] = calc(p1 -1, p2 - 1) + 1;
			return  dp[p1][p2];
//			dp[p1][p2] = calc(p1 +1, p2 + 1) + 1;
//			return  dp[p1][p2];
		}
		else {
			dp[p1][p2] = 0;
			return dp[p1][p2];
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		
		
		len1 = str1.length();
		len2 = str2.length();
		dp = new int[len1][len2];
		
		for(int i = 0; i < len1; i++) {
			for(int j = 0; j < len2; j++) {
				dp[i][j] = -1;
			}
		}
		
		for(int i = 0; i < len1; i++) {
			for(int j = 0; j < len2; j++) {
				int tmp = calc(i, j);
				ans = Math.max(ans, tmp);
			}
		}
		
		System.out.println(ans);
		
	}
}
