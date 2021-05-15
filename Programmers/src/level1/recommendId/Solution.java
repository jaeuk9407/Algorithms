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
    // 길이가 2자 이하라면 마지막 문자를 new_id 길이가 3이될때까지 반복
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
    
    // 길이가 16자 이상이면 첫 15문자만 선택
    public String stageSix(String new_id){
        if(new_id.length() >= 16){
            String result = new_id.substring(0, 15);
            // 만일 제거 후 마침표가 끝에 위치하면 제거
            return stageFour(result);
        }
        return new_id;
    }
    
    // 빈 문자열이라면 a 대입
    public String stageFive(String new_id){
        if(new_id.length() < 1){
            return "a";
        }
        return new_id;
    }
    
    // 마침표가 처음이나 끝에 위치한다면 제거
    public String stageFour(String new_id){
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1, new_id.length());
        }
        if(new_id.length() >= 1 && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }
        return new_id;
    }
    
    // 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
    public String stageThree(String new_id){
        StringBuilder sb = new StringBuilder();
        char[] char_id = new_id.toCharArray();
        int index = 0;
        while(index < char_id.length){
            // 마침표를 만나면 마침표가 끝날 때까지 index를 증가시키고 마침표를 하나만 저장함
            if(char_id[index] == '.'){
                while(char_id[index] == '.'){
                    index++;
                    // 전체 탐색이 끝나버리면 바로 종료
                    if(index >= char_id.length) break;
                }
                sb.append('.');
            }else{  // 마침표가 아닌 다른 문자라면 바로 담고, index 증가
                sb.append(char_id[index]);
                index++;
            }
        }
        return sb.toString();
    }
    
    // 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 문자 삭제
    public String stageTwo(String new_id){
        char[] char_id = new_id.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < char_id.length; i++){
            // 알파벳 소문자
            if(char_id[i] >= 'a' && char_id[i] <= 'z'){
                sb.append(char_id[i]);
            }else if(char_id[i] >= '0' && char_id[i] <= '9'){  // 숫자
                sb.append(char_id[i]);
            }else if(char_id[i] == '-' || char_id[i] == '_' || char_id[i] == '.'){  // 빼기, 밑줄, 마침표
                sb.append(char_id[i]);
            }
        }
        return sb.toString();
    }
    
    // 모든 대문자를 대응되는 소문자로 치환
    public String stageOne(String new_id){
        return new_id.toLowerCase();
    }
}