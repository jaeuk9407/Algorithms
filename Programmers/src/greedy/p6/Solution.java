package greedy.p6;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001; // ī�޶��� ��ġ 
        
        // out ������ �������� ����
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        // out�� ���� ���� ������� 
        for(int[] route : routes){
            // ī�޶� ������ ���� ������
            if(camera < route[0]){
                // ī�޶� out������ ��ġ
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}
