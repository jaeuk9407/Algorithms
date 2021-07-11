package level1.자연수뒤집어배열로만들기;

class Solution {
    public int[] solution(long n) {
        // String���� ��ȯ
        String temp = String.valueOf(n);
        // �ڸ��� ���̿� ���� �迭 ����
        int[] answer = new int[temp.length()];
        // answer �迭�� �ε����� ����� ����
        int index = 0;
        
        // temp String�� �Ųٷ� Ž���ϸ� �� char ���� int�� ��ȯ�� ����
        for(int i = temp.length() - 1; i >= 0; i--){
            answer[index++] = temp.charAt(i) - '0';
        }
        
        return answer;
    }
}
