package level1.서울에서김서방찾기;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int place = -1;
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                place = i;
            }
        }
        answer = "김서방은 "+place+"에 있다";
        return answer;
    }
}
