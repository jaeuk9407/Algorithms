package level1.자릿수더하기;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        // �־��� ���ڸ� String���� ��ȯ
        String value = String.valueOf(n);
        
        // �� ��ġ�� ���ڸ� int������ ��ȯ�� ���� ����
        for(int i = 0; i < value.length(); i++){
            answer += (Integer.valueOf(value.charAt(i)) - '0');
        }
        
        return answer;
    }
}
