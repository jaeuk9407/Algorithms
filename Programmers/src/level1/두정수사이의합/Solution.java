package level1.두정수사이의합;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);
        
        // �� �� ���̿� ���� ��� �������� ��
        for(int i = smaller; i <= bigger; i++){
            answer += i;
        }
        
        // �� ���� ���� ����� �� ������ answer�� update
        if(bigger == smaller){
            answer = smaller;
        }
        
        return answer;
    }
}
