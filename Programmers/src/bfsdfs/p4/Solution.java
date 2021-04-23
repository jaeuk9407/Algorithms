package bfsdfs.p4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

class Solution {
	public String[] solution(String[][] tickets) {
        String[] answer = {};
        // 고유번호를 발급할 map
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
        
        // 고유번호를 알파벳 순서로 재배치
        Set<String> keys = map.keySet();
        String[] airports = (String[])keys.toArray(new String[0]);
        Arrays.sort(airports);

        for(int i = 0; i < airports.length; i++){
            String name = airports[i];
            int value = i;
            map.replace(name, value);
        }
        
        // 공항 개수만큼 인접행렬 생성
        int[][] adj = new int[map.size()][map.size()];
        // tickets 정보를 인접행렬에 저장
        for(int i = 0; i < tickets.length; i++){
            String startName = tickets[i][0];
            String endName = tickets[i][1];
            int startID = map.get(startName);
            int endID = map.get(endName);
            
            adj[startID][endID]++;            
        }
        
        
        Info start = new Info(map.get("ICN"), "ICN");
        int ticketsNum = tickets.length;    // 티켓 개수
        Stack<String> visited = new Stack<>(); // 방문 정보를 기록할 스택
        
        dfs(start, 0, visited, adj, ticketsNum, airports);
        // 시작 정보("ICN")를 담아줌
        visited.push(start.name);
        
        // 결과 스택에 담겨있는 정보를 순서대로 저장
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
        
        // 목적지에 도착했는가
        if(count == ticketsNum){
            return true; 
        }
        // 연결된 곳 순회
        for(int i = 0; i < adj[nowID].length; i++){
            // 갈 수 있는가
            if(adj[nowID][i] >= 1){
                int nextID = i;
                String nextName = airports[i];
                Info next = new Info(nextID, nextName);
                
                // 항공권 소멸
                adj[nowID][nextID]--;
                // 가보고 모든 항공권을 쓸 수 있는 여행 경로라면 visited에 추가.
                if(dfs(next, count+1, visited,
                               adj, ticketsNum, airports)){
                    visited.push(next.name);
                    isPossible = true;
                }else{
                    // 올바른 경로가 아니므로 항공권 복구
                    adj[nowID][nextID]++;
                }
            }
        }
        
        // 체크아웃
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