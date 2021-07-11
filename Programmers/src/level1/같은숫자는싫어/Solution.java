package level1.같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        // ������� �����ϱ� ���� ť
        Queue<Integer> q = new LinkedList<>();
        
        // ���� �ε����� �Է°��� ������ ����
        int key = -1;
        // while�� �ȿ��� arr�� Ž���� index ����
        int index = 0;
        
        while(true){
            // ���� ����: index == arr.length
            if(index == arr.length){
                break;
            }
            // ���� �ε����� �ٸ� ���ڶ�� Q�� ���, key�� ���� �ε��� ������ ����
            if(key != arr[index]){
                q.add(arr[index]);
                key = arr[index];
            }
            // ���� �ε����� ���� ���ڸ� �ƹ��� ó������ ����
            // �� case ���������� ���� �ε����� �Ѿ�� ��
            index++;
        }
        // q�� ���Ҹ� ��� �迭�� ����
        answer = new int[q.size()];
        int i = 0;
        while(!q.isEmpty()){
            answer[i++] = q.poll();
        }

        return answer;
    }
}
