package level1.소수찾기;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isNotPrime = new boolean[n + 1];
        
        // 에라토스테네스의 체
        for(int i = 2; i * i < n; i++){
            for(int j = 2; i * j <= n; j++){
                isNotPrime[i * j] = true;
            }
        }
        
        // 소수 카운트
        for(int i = 2; i <= n; i++){
            if(!isNotPrime[i]) answer++;
        }
        
        return answer;
    }
}
