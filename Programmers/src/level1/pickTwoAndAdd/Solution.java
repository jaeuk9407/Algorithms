package level1.pickTwoAndAdd;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k = 0;
        
        // 배열 내 덧셈을 set에 저장 (중복 제거)
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // 정렬을 위해 우선순위큐로 원소 복사
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            pq.add(it.next());
        }
        
        // 우선순위큐는 빈 공간이 있으므로 set 사이즈로 정답배열 생성 후 반환값 저장
        answer = new int[set.size()];
        while(!pq.isEmpty()){
            answer[k++] = pq.poll();
        }
        
        
        return answer;
    }
}
