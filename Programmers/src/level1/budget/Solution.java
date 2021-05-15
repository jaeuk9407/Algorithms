package level1.budget;

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int index = 0;
        
        // 부서별 요청 금액을 오름차순으로 정렬
        Arrays.sort(d);
        
        // 적은 요청 금액 순으로 부서를 지원
        while(true){
            // 모든 부서를 지원했다면 탐색 종료
            if(index >= d.length){
                break;
            }
            
            // 남은 금액으로 다음 부서를 지원할 수 없다면 탐색 종료
            if(budget < d[index]){
                break;
            }
            
            // 부서를 지원해주고, 인덱스 증가
            budget -= d[index++];
            answer++;
        }
        return answer;
    }
}
