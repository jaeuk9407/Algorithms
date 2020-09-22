package stack_queue;

public class Stock_Price {
	class Solution {
		public int[] solution(int[] prices) {
			// time[i]: prices[i]의 가격이 하락하지 않은 기간
	    	int[] time = new int[prices.length];
	    	
	    	// 이중 반복 탐색
	    	for(int i=0; i<prices.length-1; i++) {
	    		time[i] =0;
	    		for(int j=i+1; j<prices.length; j++) {
	    			// i번째 가격 j번째 가격보다 작다 -> 가격이 하락하지 않았으므로 시간 카운팅
	    			if(prices[i]<=prices[j]) {
	    				time[i]++;
	    				
	    			// i번째 가격이 j번째 가격보다 큰 경우, 최소 1시간 유지했으므로 카운팅 후 break 
	    			}else {
	    				time[i]++;
	    				break;
	    			}
	    		}
	    	}
			
			int[] answer = time;
			return answer;
		}
	}
}
	