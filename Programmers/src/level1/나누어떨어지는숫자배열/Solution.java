package level1.나누어떨어지는숫자배열;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        
        // 배열의 원소 차례대로 검사 
        for(int i = 0; i < arr.length; i++){
        	// divisor로 나눠 떨어지면 list에 담음
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }
        
        // list를 오름차순으로 정렬
        Collections.sort(list);
        
        // list가 비어있지 않으면(= 나눠 떨어지는 값이 하나라도 존재하면)
        if(list.size() != 0){
            // 반환할 answer에 순서대로 담음
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
        }else{ // list가 비어있다면 -1을 반환
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
}
