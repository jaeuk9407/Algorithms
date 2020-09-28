package test;

public class rectengle {
	// 프로그래머스 나머지 한 점
	// https://programmers.co.kr/learn/courses/18/lessons/1878
	class Solution {
	    public int[] solution(int[][] v) {

	        int[] answer = new int[2];
	        
	        if(v[0][0] ==v[1][0]) {
	        	answer[0] = v[2][0];
	        }else if(v[0][0]==v[2][0]){
	        	answer[0] = v[1][0];
	        }else {
	        	answer[0] = v[0][0];
	        }
	        
	        if(v[0][1]==v[1][1]) {
	        	answer[1] = v[2][1];
	        }else if(v[0][1]==v[2][1]) {
	        	answer[1] = v[1][1];
	        }else {
	        	answer[1] =v[0][1];
	        }
	        return answer;
	    }
	}

}
