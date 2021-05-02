package greedy.p2;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int exp = name.length() - 1;
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            // ���� ������ ����� �������� �̵�
            answer += ('Z'- c + 1) > c - 'A' ? c - 'A' : ('Z' - c + 1);
            // ���� A�̸� ���� ���ӵ� A�� �ִ��� Ȯ��
            if(c == 'A'){
                int nextIdx = i + 1;
                int countA = 0;
                
                // ���ӵ� A ī��Ʈ
                while (nextIdx < name.length() &&
                       name.charAt(nextIdx) == 'A'){
                    countA ++;
                    nextIdx++;
                }
                // ������ ��ŭ �ٽ� �ǵ��ư��� �Ÿ�: (i-1)*2
                // ���ӵ� A�� ���� ������ �ε������� name�� �ڿ������� �Ÿ� (name.length() -1 -i - countA)
                int tmp = (i-1)*2 + (name.length() -1 -i - countA) ;
                // �տ������� ���������� Ž���ϴ� �Ÿ��� A�� ���� �ǵ��� ���� �Ÿ��� ��
                // �� ���� �Ÿ��� ���� ����� ä��
                if(exp > tmp) exp = tmp;
            }
        }

        answer += exp;
        return answer;
    }
}