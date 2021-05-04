package es.p1;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        // �� �л��� ����
        int[] patternOne = {1, 2, 3, 4, 5};
        int[] patternTwo = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] patternThree = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int one = 0, two = 0, three = 0;    // �� �л� ������ �ε���
        int scoreOne = 0, scoreTwo = 0, scoreThree = 0;     // �� �л� ����
        
        // �� ���׵��� �˻�
        for(int i = 0; i < answers.length; i++){
            // �л��� ���ϴ�� ���� ���׿����� ���� ���� ��
            if(patternOne[one++] == answers[i]){
                scoreOne++;
            }
            if(patternTwo[two++] == answers[i]){
                scoreTwo++;
            }
            if(patternThree[three++] == answers[i]){
                scoreThree++;
            }
            // �� �л��� ������ �����ٸ� ó������ �ݺ�
            if(one == patternOne.length){
                one = 0;
            }
            if(two == patternTwo.length){
                two = 0;
            }
            if(three == patternThree.length){
                three = 0;
            }
        }
        // �� �л��� �ִ� ���� ����
        int max = 0;
        ArrayList<Integer> al = new ArrayList<>();
        max = Math.max(max, Math.max(scoreOne, Math.max(scoreTwo, scoreThree)));
        
        // �ִ� ������ ���� �л��� ����Ʈ�� �߰�
        if(scoreOne == max){
            al.add(1);
        }
        if(scoreTwo == max){
            al.add(2);
        }
        if(scoreThree == max){
            al.add(3);
        }
        
        // ���� �� ��ȯ�� ��� �迭�� �Է�
        Collections.sort(al);
        answer = al.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
