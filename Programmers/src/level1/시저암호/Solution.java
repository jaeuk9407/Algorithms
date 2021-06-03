package level1.시저암호;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] temp = s.toCharArray();
        
        for(int i = 0; i < temp.length; i++){
            // 공백이면 밀지 않고, 그대로 결과로 담음
            if(temp[i] == 32){
                sb.append(" ");
                continue;
            }

            // 소문자인 경우 밀고 나서 'z'를 넘어가면 'a'부터 다시 밀어줌
            if(temp[i] >= 'a' && temp[i] <= 'z'){
                temp[i] += n;
                if(temp[i] > 'z'){
                    temp[i] -= 26;
                }
            }
            // 대문자인 경우 밀고 나서 'Z'를 넘어가면 'A'부터 다시 밀어줌
            else if(temp[i] >= 'A' && temp[i] <= 'Z'){
                temp[i] += n;
                if(temp[i] > 'Z'){
                    temp[i] -= 26;
                }
            }
            sb.append(temp[i]);
        }
        
        answer =sb.toString();
        
        return answer;
    }
}
