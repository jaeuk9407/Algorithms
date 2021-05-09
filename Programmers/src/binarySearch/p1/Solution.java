package binarySearch.p1;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        // 심사속도 가장 빠른 순으로 정렬
        Arrays.sort(times);
        
        long start, mid, end;
        start = 0;
        end = Long.MAX_VALUE;
        // 주어진 시간(mid) 동안 심사를 받을 수 있는 사람 수
        long sum;
        
        while(start <= end){
            mid = (start + end) / 2;
            sum = 0;
            // 주어진 시간동안 몇 명을 검사 할 수 있는가
            for(int i = 0; i < times.length; i++){
                sum += mid/times[i];
                // 모든 인원만큼 검사된다면 바로 최소 시간 탐색
                if(sum >= n) break;
            }
            // 해당 시간동안 검사가 다 안됐다면 다시 절반만큼 수행
            if(n > sum){
                start = mid + 1;
            }else{  // 검사가 다 된 경우 최소 시간 탐색
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        
        }
        return answer;
    }
}