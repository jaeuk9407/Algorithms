package bfsdfs.p2;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            // �湮�� ���� ���� ��ǻ�͸� ���ο� ��Ʈ��ũ!
            if(!visited[i]){
                visited = dfs(i, n, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public boolean[] dfs(int index, int n, int[][] computers, boolean[] visited){
        // check in
        visited[index] = true;
        
        // ����� �� ��ȸ
        for(int i = 0; i < n; i++){
            // �ڱ� �ڽ��� �ƴϰ� ����� ��ǻ�͸鼭, �湮�� ���� ���ٸ� 
            if(i != index && computers[index][i] == 1 && !visited[i]){
                // ����ؼ� �湮
                dfs(i, n, computers, visited);
            }
        }
        return visited;
    }
}
