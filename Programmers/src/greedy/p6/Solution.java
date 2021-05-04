package greedy.p6;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001; // 카메라의 위치 
        
        // out 지점을 기준으로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        // out이 빠른 차량 순서대로 
        for(int[] route : routes){
            // 카메라 범위에 들어가지 않으면
            if(camera < route[0]){
                // 카메라를 out지점에 설치
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}
