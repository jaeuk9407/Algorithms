package graph.p1;

import java.util.*;

class Solution {
    // �Ÿ����̺�, ��������Ʈ, �켱����ť(���⼭�� �Ϲ� ť�� ����)
    static int[] dist;
    static List<Integer> adj[];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // initialize
        dist = new int[n + 1];
        adj = new ArrayList[n + 1];
        int inf = 30000;    // ���� �� �Ÿ��� 20000�� ���� ����
        
        for(int i = 1; i <= n; i++){
            dist[i] = inf;  // max������ �ʱ�ȭ
            adj[i] = new ArrayList<>();
        }
        
        // ���� ���� ���� 
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        // Ž��
        answer = dijkstra(1);
        
        return answer;
    }

    private int dijkstra(int start){
        dist[start] = 0;    // ���� ��ġ�� �Ÿ� 0���� ����
        int longest = 0;    // ���� �� �Ÿ��� ���� ����
        int count = 0;      // ���� �� �Ÿ��� ���� ��� ������ ���� ����
        
        pq.add(start);
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            
            // ����� ��� Ž��
            for(int i = 0; i < adj[cur].size(); i++){
                int next = adj[cur].get(i);
                // ������ �� �ִٸ� ���� �� ť�� ����
                if(dist[cur] + 1 < dist[next]){
                    dist[next] = dist[cur] + 1;
                    pq.add(next);
                }
            }
        }// end of while
        
        // ��ü �Ÿ� �迭���� �ִ� ����
        for(int i = 2; i < dist.length; i++){
            longest = Math.max(dist[i], longest);
        }
        // ���� �հŸ� ��� ���� ����
        for(int i = 2; i < dist.length; i++){
            if(longest == dist[i]){
                count++;
            }
        }
        
        return count;
    }
}