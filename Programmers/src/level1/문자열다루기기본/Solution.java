package level1.문자열다루기기본;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        // 숫자로만 구성되어 있는지 판별
        for(int i = 0; i < s.length(); i++){
            char now = s.charAt(i);    
            if(now < '0' || now > '9'){
                answer = false;
                break;
            }
        }
        
        // 길이가 4 또는 6으로 구성되어 있는지 판별 
        if(len != 4 && len != 6){
            answer = false;
        }
        
        return answer;
    }
}
