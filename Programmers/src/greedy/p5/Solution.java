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
        
        // ���� ����� �������� �������� ����
        for(int i = 0; i < costs.length; i++){
            list.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        Collections.sort(list);
        
        // ����� ���� �������� ����Ŭ�� �������� ������ union
        for(int i = 0; i < list.size(); i++){
            // ������ n-1�� ä�õǸ� �ּҽ���Ʈ���� �ϼ��ϹǷ� ����
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

// ���� ���� class
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