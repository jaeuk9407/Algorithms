package greedy.p5;

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        int cnt = 0;
        
        ArrayList<Edge> list = new ArrayList<>();
        
        // Parent Table init
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        // 간선 비용을 기준으로 오름차순 정렬
        for(int i = 0; i < costs.length; i++){
            list.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        Collections.sort(list);
        
        // 비용이 적은 간선부터 사이클을 형성하지 않으면 union
        for(int i = 0; i < list.size(); i++){
            // 간선이 n-1개 채택되면 최소신장트리를 완성하므로 멈춤
            if(cnt == n - 1){
                break;
            }
            Edge now = list.get(i);
            if(find(parent, now.city1) != find(parent, now.city2)){
                union(parent, now.city1, now.city2);
                cnt++;
                answer += now.value;
            }
        }
        
        return answer;
    }
    
    public int find(int[] parent, int now){
        if(parent[now] != now)
            parent[now] = find(parent, parent[now]);
        return parent[now];
    }
    
    public void union(int[] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
}

// 간선 정보 class
class Edge implements Comparable<Edge>{
    int city1, city2;
    int value;
    
    public Edge(int city1, int city2, int value){
        this.city1 = city1;
        this.city2 = city2;
        this.value = value;
    }
    
    @Override
    public int compareTo(Edge o){
        if(this.value < o.value){
            return -1;
        }else if(this.value == o.value){
            return 0;
        }else{
            return 1;
        }
    }
}