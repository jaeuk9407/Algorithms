package bfsdfs.p4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

class Solution {
	public String[] solution(String[][] tickets) {
        String[] answer = {};
        // ������ȣ�� �߱��� map
        HashMap<String, Integer> map = new HashMap<>();
        int k = 0;
        for(int i = 0; i < tickets.length; i++){
            if(!map.containsKey(tickets[i][0])){
                map.put(tickets[i][0], k++);
            }
            if(!map.containsKey(tickets[i][1])){
                map.put(tickets[i][1], k++);
            }
        }
        
        // ������ȣ�� ���ĺ� ������ ���ġ
        Set<String> keys = map.keySet();
        String[] airports = (String[])keys.toArray(new String[0]);
        Arrays.sort(airports);

        for(int i = 0; i < airports.length; i++){
            String name = airports[i];
            int value = i;
            map.replace(name, value);
        }
        
        // ���� ������ŭ ������� ����
        int[][] adj = new int[map.size()][map.size()];
        // tickets ������ ������Ŀ� ����
        for(int i = 0; i < tickets.length; i++){
            String startName = tickets[i][0];
            String endName = tickets[i][1];
            int startID = map.get(startName);
            int endID = map.get(endName);
            
            adj[startID][endID]++;            
        }
        
        
        Info start = new Info(map.get("ICN"), "ICN");
        int ticketsNum = tickets.length;    // Ƽ�� ����
        Stack<String> visited = new Stack<>(); // �湮 ������ ����� ����
        
        dfs(start, 0, visited, adj, ticketsNum, airports);
        // ���� ����("ICN")�� �����
        visited.push(start.name);
        
        // ��� ���ÿ� ����ִ� ������ ������� ����
        answer = new String[visited.size()];
        int index = 0;
        while(!visited.isEmpty()){
            answer[index++] = visited.pop();
        }
        
        return answer;
    } // end of solution()
    
    public boolean dfs(Info now, int count, Stack<String> visited, 
                      int[][] adj, int ticketsNum, String[] airports){
        // checkin
        int nowID = now.id;
        String nowName = now.name;
        boolean isPossible = false;
        
        // �������� �����ߴ°�
        if(count == ticketsNum){
            return true; 
        }
        // ����� �� ��ȸ
        for(int i = 0; i < adj[nowID].length; i++){
            // �� �� �ִ°�
            if(adj[nowID][i] >= 1){
                int nextID = i;
                String nextName = airports[i];
                Info next = new Info(nextID, nextName);
                
                // �װ��� �Ҹ�
                adj[nowID][nextID]--;
                // ������ ��� �װ����� �� �� �ִ� ���� ��ζ�� visited�� �߰�.
                if(dfs(next, count+1, visited,
                               adj, ticketsNum, airports)){
                    visited.push(next.name);
                    isPossible = true;
                }else{
                    // �ùٸ� ��ΰ� �ƴϹǷ� �װ��� ����
                    adj[nowID][nextID]++;
                }
            }
        }
        
        // üũ�ƿ�
        if(isPossible){
            return true;
        }else{
            return false;
        }
    }
}
class Info{
    int id;
    String name;
    
    public Info(int id, String name){
        this.id = id;
        this.name = name;
    }
}