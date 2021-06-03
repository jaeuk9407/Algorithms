package level1.문자열을정수로바꾸기;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // 첫번째 글자가 음수 기호이면, 기호를 제외하고 나머지 문자열을 숫자로 변환한 뒤, -1을 곱해줌
        if(s.charAt(0) == '-'){
            answer = Integer.valueOf(s.substring(1)) * -1;
        }else{
            // 모든 글자가 숫자이면 그대로 숫자로 변환
            answer = Integer.valueOf(s);
        }
        return answer;
    }
}
