package dp.p1;

class Solution {
    static int n;
    static int target;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {
        // 전역변수로 setting 
        n = N;
        target = number;
        
        // 재귀 탐색 
        dfs(0, 0);
        
        // 8개까지 사용해 탐색해도 target이 없었다면 -1로 반환
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        
        return answer;
    }
    
    public void dfs(int cnt, int prev){
        // target을 찾으면 cnt를 최솟값으로 업데이트
        if(prev == target){
            answer = Math.min(answer, cnt);
            return;
        }
        
        int temp = n;
        // 8번까지 아직 들어갈 수 있는 n의 횟수: 8-cnt
        for(int i = 0; i < 8 - cnt; i++){
            int newCount = cnt + i + 1;
            dfs(newCount, prev + temp);
            dfs(newCount, prev - temp);
            dfs(newCount, prev * temp);
            dfs(newCount, prev / temp);
            
            // n을 이어붙인 수로 변경
            temp = temp * 10 + n;
        }
    }
}
