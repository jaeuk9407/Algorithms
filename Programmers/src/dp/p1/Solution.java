package dp.p1;

class Solution {
    static int n;
    static int target;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {
        // ���������� setting 
        n = N;
        target = number;
        
        // ��� Ž�� 
        dfs(0, 0);
        
        // 8������ ����� Ž���ص� target�� �����ٸ� -1�� ��ȯ
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        
        return answer;
    }
    
    public void dfs(int cnt, int prev){
        // target�� ã���� cnt�� �ּڰ����� ������Ʈ
        if(prev == target){
            answer = Math.min(answer, cnt);
            return;
        }
        
        int temp = n;
        // 8������ ���� �� �� �ִ� n�� Ƚ��: 8-cnt
        for(int i = 0; i < 8 - cnt; i++){
            int newCount = cnt + i + 1;
            dfs(newCount, prev + temp);
            dfs(newCount, prev - temp);
            dfs(newCount, prev * temp);
            dfs(newCount, prev / temp);
            
            // n�� �̾���� ���� ����
            temp = temp * 10 + n;
        }
    }
}
