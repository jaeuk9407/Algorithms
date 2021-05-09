package binarySearch.p1;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        // �ɻ�ӵ� ���� ���� ������ ����
        Arrays.sort(times);
        
        long start, mid, end;
        start = 0;
        end = Long.MAX_VALUE;
        // �־��� �ð�(mid) ���� �ɻ縦 ���� �� �ִ� ��� ��
        long sum;
        
        while(start <= end){
            mid = (start + end) / 2;
            sum = 0;
            // �־��� �ð����� �� ���� �˻� �� �� �ִ°�
            for(int i = 0; i < times.length; i++){
                sum += mid/times[i];
                // ��� �ο���ŭ �˻�ȴٸ� �ٷ� �ּ� �ð� Ž��
                if(sum >= n) break;
            }
            // �ش� �ð����� �˻簡 �� �ȵƴٸ� �ٽ� ���ݸ�ŭ ����
            if(n > sum){
                start = mid + 1;
            }else{  // �˻簡 �� �� ��� �ּ� �ð� Ž��
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        
        }
        return answer;
    }
}