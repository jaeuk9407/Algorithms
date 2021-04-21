package stack.p3;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {0};
        // 먼저 기능이 나가야 뒤에 기능도 배포가 될 수 있다.. Queue<기능인덱스>
        Queue<Integer> q = new LinkedList<>();
        // 배포 정보(K: 배포 인덱스, V: 기능 개수)
        HashMap<Integer, Integer> deployInfo = new HashMap<>();
        
        // 모든 기능을 큐에 담음
        for(int i = 0; i < speeds.length; i++){
            q.add(i);
        }
        
        // 배포 고유번호
        int deployKey = 1;
        while(!q.isEmpty()){
            // 각 기능의 진척률 업데이트
            Iterator<Integer> itr = q.iterator();
            while(itr.hasNext()){
                int funcIndex = itr.next();
                progresses[funcIndex] += speeds[funcIndex];
                
            }
            
            // 만약 front 기능이 100%면
            // 100%인 기능 수만큼 out
            int outCount = 0;
            while(progresses[q.peek()] >= 100){
                q.poll();
                outCount++;
                if(q.isEmpty()){
                    break;
                }
            }
            // 배포할 기능이 있었다면 해당 정보 저장
            if(outCount != 0){
                deployInfo.put(deployKey, outCount);
                deployKey++;
            }
        }
        
        /* 모든 기능 배포 완료 */
        answer = new int[deployInfo.size()];
        for(int i = 0; i < deployInfo.size(); i++){
            answer[i] = deployInfo.get(i + 1);
        }
        
        return answer;
    }
}