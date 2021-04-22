package stack.p4;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int time = 0;   // 원하는 문서가 출력되는 순서
        
        Queue<Docs> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            Docs docs = new Docs(i, priorities[i]);
            q.add(docs);
        }
        
        while(!q.isEmpty()){
            // 1. 인쇄 대기목록의 가장 앞에 있는 문서(front)를 대기목록에서 꺼냄
            Docs front = q.peek();
            boolean hasMore = false;
            // 2. 나머지 인쇄 대기목록에 front보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣음
            Iterator<Docs> itr = q.iterator();
            while(itr.hasNext()){
                Docs next = itr.next();
                if(front.priority < next.priority){
                    hasMore = true;
                }
            }
            
            // 3. 그렇지 않으면 front를 인쇄
            if(!hasMore){
                q.poll();
                time++;
                // 찾고자 하는 문서라면 현재 순서를 저장한 채로 반복문 탈출
                if(front.index == location){
                    break;
                }
            }else{
                // 더 중요한 문서가 있으므로 맨 뒤로 보냄
                q.add(front);
                q.poll();
            }
        }
        
        answer = time;
        return answer;
    }
}

// 문서
class Docs{
    int index;
    int priority;
    
    public Docs(int index, int priority){
        this.index = index;
        this.priority = priority;
    }
}