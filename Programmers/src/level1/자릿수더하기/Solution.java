package level1.자릿수더하기;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        // 주어진 숫자를 String으로 변환
        String value = String.valueOf(n);
        
        // 각 위치의 숫자를 int형으로 변환해 덧셈 연산
        for(int i = 0; i < value.length(); i++){
            answer += (Integer.valueOf(value.charAt(i)) - '0');
        }
        
        return answer;
    }
}
