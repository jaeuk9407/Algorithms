package bfsdfs.p2;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            // 방문한 적이 없는 컴퓨터면 새로운 네트워크!
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
        
        // 연결된 곳 순회
        for(int i = 0; i < n; i++){
            // 자기 자신이 아니고 연결된 컴퓨터면서, 방문한 적이 없다면 
            if(i != index && computers[index][i] == 1 && !visited[i]){
                // 계속해서 방문
                dfs(i, n, computers, visited);
            }
        }
        return visited;
    }
}
