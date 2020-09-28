package dp;

public class IntegerTriangle {
	class Solution {
	    public int solution(int[][] triangle) {
	        int[][] dp = new int[triangle.length][triangle.length];
	        
	        //삼각형의 가장자리 입력
	        dp[0][0] = triangle[0][0];
	        for(int i=1;i<triangle.length;i++) {
	        	dp[i][0] = dp[i-1][0]+triangle[i][0];
	        	dp[i][i] = dp[i-1][i-1]+triangle[i][i];
	        }
	        
	        //삼각형 가장자리를 제외한 내부 값 입력
	        for(int i=2; i<triangle.length;i++) {
	        	for(int j=1; j<i; j++) {
	        		dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
	        	}
	        }
	        
	        
	        int answer = 0;
	        //마지막 행의 최댓값 저장
	        for(int i=0; i<triangle.length;i++) {
	        	System.out.println(dp[triangle.length-1][i]);
	        	
	        	answer = Math.max(dp[triangle.length-1][i], answer);
	        	
	        }
	        
	        return answer;
	    }
	}
}
