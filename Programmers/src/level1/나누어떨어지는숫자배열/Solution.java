package level1.나누어떨어지는숫자배열;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        
        // �迭�� ���� ���ʴ�� �˻� 
        for(int i = 0; i < arr.length; i++){
        	// divisor�� ���� �������� list�� ����
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }
        
        // list�� ������������ ����
        Collections.sort(list);
        
        // list�� ������� ������(= ���� �������� ���� �ϳ��� �����ϸ�)
        if(list.size() != 0){
            // ��ȯ�� answer�� ������� ����
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
        }else{ // list�� ����ִٸ� -1�� ��ȯ
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
}
