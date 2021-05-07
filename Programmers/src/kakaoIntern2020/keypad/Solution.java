package kakaoIntern2020.keypad;

import java.util.*;

class Solution {
    static List<Integer>[] list = new ArrayList[13];
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        // 버튼 인접정보 초기화
        init();
        
        // 초기 시작 위치는 *과 #, -> 10, 12로 매핑
        int left = 10;
        int right = 12;
        
        // 주어진 입력 버튼에 대해 좌우 손 검사 
        for(int i = 0; i < numbers.length; i++){
        	// 0 버튼은 11로 매핑
            if(numbers[i] == 0) numbers[i] = 11;
            
            // 1, 4, 7은 반드시 왼손 입력 
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                left = numbers[i];
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
            	// 3, 6, 9는 반드시 오른손 입력
                sb.append("R");
                right = numbers[i];
            }else if(numbers[i] == 2 || numbers[i] == 5 
                     || numbers[i] == 8 || numbers[i] == 11){
            	// 2, 5, 8, 11은 가까운 손으로 입력
                int[] distances = calcDistance(left, right, numbers[i]);
                // 양손의 거리가 같은 경우 주 사용 손으로 입력
                if(distances[0] == distances[1]){
                    if(hand.equals("right")){
                        sb.append("R");
                        right = numbers[i];
                    }else{
                        sb.append("L");
                        left = numbers[i];
                    }
                }else{
                	// 양손의 거리가 다르다면 가까운 손으로 입력
                    if(distances[0] < distances[1]){
                        sb.append("L");
                        left = numbers[i];
                    }else{
                        sb.append("R");
                        right = numbers[i];
                    }
                }
            }     
        }
        answer = sb.toString();
        return answer;
    }
    
    
    
    // 초기 인접정보 저장 초기화
    public void init(){
    	// 인접리스트 초기화
        for(int i = 1; i <= 12; i++){
            list[i] = new ArrayList<>();
        }
        
        // 인접정보 저장 
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 3; j++){
                int value = 3 * (i-1) + j;
                // 좌측 4개 버튼을 제외하고 좌측 버튼 이동 가능
                if(value != 1 && value != 4 && value != 7 && value != 10){
                    list[value].add(value-1);
                }
                // 우측 4개 버튼을 제외하고 우측 버튼 이동 가능
                if(value != 3 && value != 6 && value != 9 && value != 12){
                    list[value].add(value+1);
                }
                // 상단 3개 버튼을 제외하고 상단 버튼 이동 가능
                if(value != 1 && value != 2 && value != 3){
                    list[value].add(value-3);
                }
                // 하단 3개 버튼을 제외하고 하단 버튼 이동 가능
                if(value != 10 && value != 11 && value != 12){
                    list[value].add(value+3);
                }
            }
        }
    }
    // 거리계산 메서드(왼손 위치, 오른손 위치, 기준 위치) : bfs
    // return result[0: 왼손까지의 거리, 1: 오른손 까지의 거리]
    public int[] calcDistance(int left, int right, int target) {
    	// 거리를 저장할 배열
        int[] dists = new int[13];
        // 방문 여부 체크 배열 -> 중복 방문 방지 
        boolean[] visited = new boolean[13];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(target);
        visited[target] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            // 방문 가능한 버튼 순회 
            for(int i = 0; i < list[now].size(); i++){
                int nxt = list[now].get(i);
                // 방문하지 않은 버튼이면 현재 버튼 거리의 + 1로 저장 및 방문처리
                if(!visited[nxt]){
                    q.add(nxt);
                    visited[nxt] = true;
                    dists[nxt] = dists[now]+1;
                }
            }
        }
        
        int[] result = {dists[left], dists[right]};
        return result;
    }
    
}
