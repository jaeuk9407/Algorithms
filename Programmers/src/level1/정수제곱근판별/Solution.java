package level1.정수제곱근판별;

class Solution {
    public long solution(long n) {
        long answer = 0;
        long x = 0;
        
        for(long i = 1; i * i <= n; i++){
            if(i * i == n){
                x = i;
            }
        }
        
        if(x == 0) return -1;
        
        answer = (x+1) * (x+1);
        return answer;
    }
}
