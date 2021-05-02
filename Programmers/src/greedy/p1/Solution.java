package greedy.p1;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] howMany = new int[n + 1];
        Arrays.fill(howMany, 1);
        
        // ������ ������ �л� ó��
        for(int i = 0; i < reserve.length; i++){
            howMany[reserve[i]]++;
        }
        // ������ ������ �л��� �������ߴٸ� ������ �� ����
        for(int i = 0; i < lost.length; i++){
            howMany[lost[i]]--;
        }
        // �������� ���� �� ������ ������, ü���� ������ ���� 
        for(int i = 1; i < howMany.length; i++){
            if(howMany[i] == 0){
                if(i - 1 >= 1 && howMany[i - 1] >= 2){
                    howMany[i - 1]--;
                    howMany[i]++;
                }else if(i + 1 < howMany.length && howMany[i + 1] >= 2){
                    howMany[i + 1]--;
                    howMany[i]++;
                }
            }
        }
        
        // ü������ ���� ���� �л� �� ���
        for(int i = 1; i < howMany.length; i++){
            if(howMany[i] == 0){
                answer--;
            }
        }
        
        return answer;
    }
}