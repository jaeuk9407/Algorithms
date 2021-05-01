package sort.p3;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 1. 정렬
        Arrays.sort(citations);
        
        // 2. 1부터 시작해 그 값보다 큰 개수를 확인
        for(int i = 0; i <= citations.length; i++){
            int count = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[j] >= i){
                    count++;
                }
            }
            // 3. count가 그 값 이상이면 그 값으로 update
            if(i <= count){
                answer = i;
            }
            // 4. 작으면 update 멈춤
            else break;
        }
        return answer;
    }
}
