package level1.시저암호;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] temp = s.toCharArray();
        
        for(int i = 0; i < temp.length; i++){
            // �����̸� ���� �ʰ�, �״�� ����� ����
            if(temp[i] == 32){
                sb.append(" ");
                continue;
            }

            // �ҹ����� ��� �а� ���� 'z'�� �Ѿ�� 'a'���� �ٽ� �о���
            if(temp[i] >= 'a' && temp[i] <= 'z'){
                temp[i] += n;
                if(temp[i] > 'z'){
                    temp[i] -= 26;
                }
            }
            // �빮���� ��� �а� ���� 'Z'�� �Ѿ�� 'A'���� �ٽ� �о���
            else if(temp[i] >= 'A' && temp[i] <= 'Z'){
                temp[i] += n;
                if(temp[i] > 'Z'){
                    temp[i] -= 26;
                }
            }
            sb.append(temp[i]);
        }
        
        answer =sb.toString();
        
        return answer;
    }
}
