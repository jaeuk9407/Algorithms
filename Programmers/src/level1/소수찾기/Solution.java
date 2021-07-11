package level1.소수찾기;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isNotPrime = new boolean[n + 1];
        
        // �����佺�׳׽��� ü
        for(int i = 2; i * i < n; i++){
            for(int j = 2; i * j <= n; j++){
                isNotPrime[i * j] = true;
            }
        }
        
        // �Ҽ� ī��Ʈ
        for(int i = 2; i <= n; i++){
            if(!isNotPrime[i]) answer++;
        }
        
        return answer;
    }
}
