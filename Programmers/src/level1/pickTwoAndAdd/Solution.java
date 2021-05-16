package level1.pickTwoAndAdd;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k = 0;
        
        // �迭 �� ������ set�� ���� (�ߺ� ����)
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // ������ ���� �켱����ť�� ���� ����
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            pq.add(it.next());
        }
        
        // �켱����ť�� �� ������ �����Ƿ� set ������� ����迭 ���� �� ��ȯ�� ����
        answer = new int[set.size()];
        while(!pq.isEmpty()){
            answer[k++] = pq.poll();
        }
        
        
        return answer;
    }
}
