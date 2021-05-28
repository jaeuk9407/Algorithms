package level1.문자열내p와y의개수;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        int numP = 0;
        int numY = 0;
        
        // 문자를 하나씩 탐색
        for(int i = 0; i < s.length(); i++){
            // 현재 위치의 문자
            char now = s.charAt(i);
            // p, P이면 p의 개수 업데이트
            if(now == 'p' || now == 'P'){
                numP++;
            }
            // y, Y이면 y의 개수 업데이트
            else if(now == 'y' || now == 'Y'){
                numY++;
            }
        }
        
        // p의 개수와 y의 개수가 같으면 true
        if(numP == numY){
            answer = true;
        }

        return answer;
    }
}
