package study.dp.P2011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String N; 
	static int dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		int len = N.length();
		
		dp = new int[len + 1];
		int[] arr = new int[len + 1];
		
		for(int i = 0; i < len; i++) {
			arr[i + 1] = N.charAt(i) - '0';
		}
		
		dp[0] = 1;
		
		for(int i = 1; i <= len; i++) {
			// 현재 자리 글자가 0이 아니라면 a ~ i로 표기 가능
			if(arr[i] != 0) {
				dp[i] = (dp[i - 1] + dp[i]) % 1000000;
			}
			
			// append : 이전 자리 글자와 현재 자리 글자를 이어붙인 수
			int append = arr[i - 1] * 10 + arr[i];
			
			// append가 10~26이라면 두 글자를 하나의 스펠링 j ~ z로 치환 가능
			if(10 <= append && append <= 26) {
				dp[i] = (dp[i - 2] + dp[i]) % 1000000;
			}
		}
		
		System.out.println(dp[len] % 1000000);
		
		
	}
	
}
