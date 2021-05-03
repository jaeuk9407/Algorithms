package greedy.p4;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean[] isOnBoard = new boolean[people.length];
        
        // ����
        Arrays.sort(people);
        
        int i = 0;
        int j = people.length - 1;
        
        while(true){
            if(i == people.length || j < 0) break;
            // ���� Ÿ�� �ʾҴٸ� ��Ī ���
            if(!isOnBoard[i]){
                // j��° ����� Ÿ�� �ʾҰ�, �Բ� Ż �� �ִ� �����Ը� �Բ� Ž
                if(!isOnBoard[j] && people[i] + people[j] <= limit){
                    isOnBoard[i] = true;
                    isOnBoard[j] = true;
                    answer++;
                }
                // j��°�� ����, Ÿ�� ���ߵ� ���� j ��Ī �غ�
                j--;
            }else{
                // i��°�� ��Ī �Ϸ�ƴٸ� ���� i Ž��
                i++;
            }
        }
        
        // �����԰� ���� ������� ���� Ż �� �ִ� ����� ���� ū����� ��Ī
        // for(int i = 0; i < people.length; i++){
        //     // ���� Ÿ�� �ʾҴٸ� ��Ī ���
        //     if(!isOnBoard[i]){
        //         for(int j = people.length-1; j >= 0; j--){
        //             if(!isOnBoard[j] && people[i] + people[j] <= limit){
        //                 isOnBoard[i] = true;
        //                 isOnBoard[j] = true;
        //                 answer++;
        //                 break;
        //             }
        //         }
        //     }
        // }
        
        // matching���� ���� ������� ȥ�� Ž
        for(int p = 0; p < people.length; p++){
            if(!isOnBoard[p]) answer++;
        }
        return answer;
    }
}