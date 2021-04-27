package heap.p1;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.add((long)scoville[i]);
        }
        
        // 정렬된 상태에서 맨 앞의 값이 k보다 작으면
        while(pq.peek() < K){
            // 2개를 뽑아 mix
            // 2개 이상 음식이 존재하지 않으면 mix 불가
            if(pq.size() < 2) return -1;
            long smallE = pq.poll();
            long bigE = pq.poll();
            // 결과를 다시 넣어준다
            long mixResult = smallE + (bigE * 2);
            pq.add(mixResult);
            // 섞은 회수 카운트
            answer++;
        }
        
        return answer;
    }
}