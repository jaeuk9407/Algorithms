package level1.recommendId;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = stageOne(new_id);
        answer = stageTwo(answer);
        answer = stageThree(answer);
        answer = stageFour(answer);
        answer = stageFive(answer);
        answer = stageSix(answer);
        answer = stageSeven(answer);
        
        return answer;
    }
    // ���̰� 2�� ���϶�� ������ ���ڸ� new_id ���̰� 3�̵ɶ����� �ݺ�
    public String stageSeven(String new_id){
        if(new_id.length() > 2){
            return new_id;
        }
        StringBuilder sb = new StringBuilder();
        char last = new_id.charAt(new_id.length() - 1);
        sb.append(new_id);
        
        while(sb.length() < 3){
            sb.append(last);
        }
        return sb.toString();
    }
    
    // ���̰� 16�� �̻��̸� ù 15���ڸ� ����
    public String stageSix(String new_id){
        if(new_id.length() >= 16){
            String result = new_id.substring(0, 15);
            // ���� ���� �� ��ħǥ�� ���� ��ġ�ϸ� ����
            return stageFour(result);
        }
        return new_id;
    }
    
    // �� ���ڿ��̶�� a ����
    public String stageFive(String new_id){
        if(new_id.length() < 1){
            return "a";
        }
        return new_id;
    }
    
    // ��ħǥ�� ó���̳� ���� ��ġ�Ѵٸ� ����
    public String stageFour(String new_id){
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1, new_id.length());
        }
        if(new_id.length() >= 1 && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }
        return new_id;
    }
    
    // ��ħǥ�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ�� ġȯ
    public String stageThree(String new_id){
        StringBuilder sb = new StringBuilder();
        char[] char_id = new_id.toCharArray();
        int index = 0;
        while(index < char_id.length){
            // ��ħǥ�� ������ ��ħǥ�� ���� ������ index�� ������Ű�� ��ħǥ�� �ϳ��� ������
            if(char_id[index] == '.'){
                while(char_id[index] == '.'){
                    index++;
                    // ��ü Ž���� ���������� �ٷ� ����
                    if(index >= char_id.length) break;
                }
                sb.append('.');
            }else{  // ��ħǥ�� �ƴ� �ٸ� ���ڶ�� �ٷ� ���, index ����
                sb.append(char_id[index]);
                index++;
            }
        }
        return sb.toString();
    }
    
    // ���ĺ� �ҹ���, ����, ����, ����, ��ħǥ�� ������ ���� ����
    public String stageTwo(String new_id){
        char[] char_id = new_id.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < char_id.length; i++){
            // ���ĺ� �ҹ���
            if(char_id[i] >= 'a' && char_id[i] <= 'z'){
                sb.append(char_id[i]);
            }else if(char_id[i] >= '0' && char_id[i] <= '9'){  // ����
                sb.append(char_id[i]);
            }else if(char_id[i] == '-' || char_id[i] == '_' || char_id[i] == '.'){  // ����, ����, ��ħǥ
                sb.append(char_id[i]);
            }
        }
        return sb.toString();
    }
    
    // ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ
    public String stageOne(String new_id){
        return new_id.toLowerCase();
    }
}