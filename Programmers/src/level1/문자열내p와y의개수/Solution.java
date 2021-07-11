package level1.문자열내p와y의개수;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        int numP = 0;
        int numY = 0;
        
        // ���ڸ� �ϳ��� Ž��
        for(int i = 0; i < s.length(); i++){
            // ���� ��ġ�� ����
            char now = s.charAt(i);
            // p, P�̸� p�� ���� ������Ʈ
            if(now == 'p' || now == 'P'){
                numP++;
            }
            // y, Y�̸� y�� ���� ������Ʈ
            else if(now == 'y' || now == 'Y'){
                numY++;
            }
        }
        
        // p�� ������ y�� ������ ������ true
        if(numP == numY){
            answer = true;
        }

        return answer;
    }
}
