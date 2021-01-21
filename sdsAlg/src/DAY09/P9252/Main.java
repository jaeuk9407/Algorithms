package DAY09.P9252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static String str1, str2;
	static int len1, len2;
	static int dp[][];
	static Info tracking[][];
	
	// p1, p2까지의 것들 중에서 LCS(꼭 p1, p2를 포함할 필요는 없음) 
	static int calc(int p1, int p2) {
		if(p1 < 0 || p2 < 0) {
			return 0;
		}
		// 저장된 dp가 있으면 dp 출력
		if(dp[p1][p2] != -1) {
			return dp[p1][p2];
		}
		
		// 문자가 같으면
		if(str1.charAt(p1) == str2.charAt(p2)) {
			tracking[p1][p2].p1 = p1 -1;
			tracking[p1][p2].p2 = p2 -1;
			dp[p1][p2] = calc(p1 -1, p2 -1) + 1;
			
			return dp[p1][p2];
		}
		// 문자가 다르면
		int tmp1, tmp2;
		tmp1 = calc(p1-1, p2);
		tmp2 = calc(p1, p2-1);
		
		if(tmp1 > tmp2) {
			dp[p1][p2] = tmp1;
			tracking[p1][p2].p1 = p1 -1;
			tracking[p1][p2].p2 = p2;
		}else {
			dp[p1][p2] = tmp2;
			tracking[p1][p2].p1 = p1;
			tracking[p1][p2].p2 = p2 -1;
		}
		return dp[p1][p2];
	}
	
	public static void main(String[] args) throws Exception{
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		
		// 초기화
		tracking = new Info[1010][1010];
		dp = new int[str1.length()+1][str2.length()+1];
		len1 = str1.length();
		len2 = str2.length();
		
		for(int i = 0; i <= str1.length(); i++) {
			for(int j = 0; j <= str2.length(); j++) {
				dp[i][j] = -1;
				tracking[i][j] = new Info();
			}
		}
		
		// 출력 LCS Length
		System.out.println(calc(str1.length()-1, str2.length()-1));
		
		// tracking Test
//		for( int i = 0 ; i<len1; i++) {
//			for(int j = 0; j<len2; j++) {
//				System.out.print("("+tracking[i][j].p1+","+tracking[i][j].p2+")");
//			}
//			System.out.println("");
//		}
		
		// 출력 LCS
		int p1 = len1 -1, p2 = len2 -1;
		StringBuilder sb = new StringBuilder();
		
		while(0 <= p1 && 0<= p2) {
			if(str1.charAt(p1) == str2.charAt(p2)) {
				sb.append(str1.charAt(p1));
			}
			Info nxt = tracking[p1][p2];
			p1 = nxt.p1;
			p2 = nxt.p2;
		}
		
		System.out.print(sb.reverse().toString());
		
		
	}

}

class Info{
	int p1,p2;

	
	public Info() {
	}

	public Info(int p1, int p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
}
