package level1.plusOfNegativeAndPositive;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        // 정수들을 하나씩 뽑아
        for(int i = 0; i < absolutes.length; i++){
            // 양수면 더하고
            if(signs[i]){
                answer += absolutes[i];
            }else{ // 음수면 뺀다
                answer -= absolutes[i];
            }
        }
        
        return answer;
    }
}
