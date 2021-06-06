package level1.이상한문자만들기;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 단어 내 인덱스를 기록하는 변수
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            // 문자가 공백이 아닌 경우
            if(s.charAt(i) != ' '){
                // 짝수번 인덱스라면 대문자로 변환
                if(count % 2 == 0){
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }else{  // 홀수번 인덱스면 소문자로 변환
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
                count++;
            }else{ // 문자가 공백인 경우
                count = 0;
                sb.append(" ");
            }
        }
        answer = sb.toString();
        
        return answer;
    }
}
