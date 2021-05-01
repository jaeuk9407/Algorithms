package sort.p2;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isAllZero = true;
        
        Info[] infos = new Info[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	Info info = new Info(numbers[i]);
        	infos[i] = info;
            if(numbers[i] != 0){
                isAllZero = false;
            }
        }
        if(isAllZero){
            return "0";
        }
        
        Arrays.sort(infos);
           
        for(Info info : infos){
            sb.append(info.number);
        }
        
        answer = sb.toString();
        return answer;
    }
}

class Info implements Comparable<Info>{
	int number;

	public Info(int number) {
		this.number = number;
	}

	@Override
	public int compareTo(Info o) {
		String s1 = String.valueOf(this.number);
        String s2 = String.valueOf(o.number);
        
        String sum1 = s1 + s2;
        String sum2 = s2 + s1;
        
        int result1 = Integer.parseInt(sum1);
        int result2 = Integer.parseInt(sum2);
        if(result1 > result2) return -1;
        else if(result1 == result2) return 0;
        return 1;
    }
    
	@Override
	public String toString() {
		return number+""; 
	}
}