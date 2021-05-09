package graph.p1;

import java.util.*;

class Solution {
    // 거리테이블, 인접리스트, 우선순위큐(여기서는 일반 큐도 가능)
    static int[] dist;
    static List<Integer> adj[];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // initialize
        dist = new int[n + 1];
        adj = new ArrayList[n + 1];
        int inf = 30000;    // 가장 먼 거리도 20000을 넘지 않음
        
        for(int i = 1; i <= n; i++){
            dist[i] = inf;  // max값으로 초기화
            adj[i] = new ArrayList<>();
        }
        
        // 인접 정보 저장 
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        // 탐색
        answer = dijkstra(1);
        
        return answer;
    }

    private int dijkstra(int start){
        dist[start] = 0;    // 시작 위치는 거리 0부터 시작
        int longest = 0;    // 가장 먼 거리를 담을 변수
        int count = 0;      // 가장 먼 거리를 갖는 노드 개수를 세는 변수
        
        pq.add(start);
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            
            // 연결된 노드 탐색
            for(int i = 0; i < adj[cur].size(); i++){
                int next = adj[cur].get(i);
                // 갱신할 수 있다면 갱신 및 큐에 담음
                if(dist[cur] + 1 < dist[next]){
                    dist[next] = dist[cur] + 1;
                    pq.add(next);
                }
            }
        }// end of while
        
        // 전체 거리 배열에서 최댓값 저장
        for(int i = 2; i < dist.length; i++){
            longest = Math.max(dist[i], longest);
        }
        // 가장 먼거리 노드 개수 세기
        for(int i = 2; i < dist.length; i++){
            if(longest == dist[i]){
                count++;
            }
        }
        
        return count;
    }
}