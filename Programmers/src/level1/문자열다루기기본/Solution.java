package level1.문자열다루기기본;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        // ���ڷθ� �����Ǿ� �ִ��� �Ǻ�
        for(int i = 0; i < s.length(); i++){
            char now = s.charAt(i);    
            if(now < '0' || now > '9'){
                answer = false;
                break;
            }
        }
        
        // ���̰� 4 �Ǵ� 6���� �����Ǿ� �ִ��� �Ǻ� 
        if(len != 4 && len != 6){
            answer = false;
        }
        
        return answer;
    }
}
