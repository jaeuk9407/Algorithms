package level1.budget;

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int index = 0;
        
        // �μ��� ��û �ݾ��� ������������ ����
        Arrays.sort(d);
        
        // ���� ��û �ݾ� ������ �μ��� ����
        while(true){
            // ��� �μ��� �����ߴٸ� Ž�� ����
            if(index >= d.length){
                break;
            }
            
            // ���� �ݾ����� ���� �μ��� ������ �� ���ٸ� Ž�� ����
            if(budget < d[index]){
                break;
            }
            
            // �μ��� �������ְ�, �ε��� ����
            budget -= d[index++];
            answer++;
        }
        return answer;
    }
}
