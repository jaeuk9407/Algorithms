package level1.이상한문자만들기;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // �ܾ� �� �ε����� ����ϴ� ����
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            // ���ڰ� ������ �ƴ� ���
            if(s.charAt(i) != ' '){
                // ¦���� �ε������ �빮�ڷ� ��ȯ
                if(count % 2 == 0){
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }else{  // Ȧ���� �ε����� �ҹ��ڷ� ��ȯ
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
                count++;
            }else{ // ���ڰ� ������ ���
                count = 0;
                sb.append(" ");
            }
        }
        answer = sb.toString();
        
        return answer;
    }
}
