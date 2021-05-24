package level1.두정수사이의합;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);
        
        // 두 수 사이에 속한 모든 정수들의 합
        for(int i = smaller; i <= bigger; i++){
            answer += i;
        }
        
        // 두 수가 같은 수라면 그 값으로 answer를 update
        if(bigger == smaller){
            answer = smaller;
        }
        
        return answer;
    }
}
