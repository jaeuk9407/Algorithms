package level1.���ڿ��������ιٲٱ�;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // ù��° ���ڰ� ���� ��ȣ�̸�, ��ȣ�� �����ϰ� ������ ���ڿ��� ���ڷ� ��ȯ�� ��, -1�� ������
        if(s.charAt(0) == '-'){
            answer = Integer.valueOf(s.substring(1)) * -1;
        }else{
            // ��� ���ڰ� �����̸� �״�� ���ڷ� ��ȯ
            answer = Integer.valueOf(s);
        }
        return answer;
    }
}
