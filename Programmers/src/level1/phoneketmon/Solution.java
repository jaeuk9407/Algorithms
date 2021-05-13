package level1.phoneketmon;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int k = 0;  // key�� ����
        int halfN = nums.length / 2;    // ���� �� �ִ� 2/N ����
        
        
        Map<Integer, Integer> map = new HashMap<>();
        // <K,V>�� ��ü ���ϸ� ������ �ϳ��� ��ƺ��� ������ ������ ��
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
                k++;
            }
        }
        
        // ���ϸ� ������ ������ 2/N�� ���� ���� ���� return�Ѵ�
        answer = Math.min(k, halfN);

        return answer;
    }
}
