package level1.같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        // 순서대로 저장하기 위한 큐
        Queue<Integer> q = new LinkedList<>();
        
        // 이전 인덱스의 입력값을 저장할 변수
        int key = -1;
        // while문 안에서 arr을 탐색할 index 변수
        int index = 0;
        
        while(true){
            // 종료 조건: index == arr.length
            if(index == arr.length){
                break;
            }
            // 이전 인덱스와 다른 글자라면 Q에 담고, key를 현재 인덱스 값으로 변경
            if(key != arr[index]){
                q.add(arr[index]);
                key = arr[index];
            }
            // 이전 인덱스와 같은 글자면 아무런 처리하지 않음
            // 두 case 공통적으로 다음 인덱스로 넘어가야 함
            index++;
        }
        // q의 원소를 결과 배열로 복사
        answer = new int[q.size()];
        int i = 0;
        while(!q.isEmpty()){
            answer[i++] = q.poll();
        }

        return answer;
    }
}
