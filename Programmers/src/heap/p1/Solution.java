package heap.p1;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.add((long)scoville[i]);
        }
        
        // ���ĵ� ���¿��� �� ���� ���� k���� ������
        while(pq.peek() < K){
            // 2���� �̾� mix
            // 2�� �̻� ������ �������� ������ mix �Ұ�
            if(pq.size() < 2) return -1;
            long smallE = pq.poll();
            long bigE = pq.poll();
            // ����� �ٽ� �־��ش�
            long mixResult = smallE + (bigE * 2);
            pq.add(mixResult);
            // ���� ȸ�� ī��Ʈ
            answer++;
        }
        
        return answer;
    }
}