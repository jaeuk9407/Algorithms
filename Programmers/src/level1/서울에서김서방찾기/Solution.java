package level1.���￡���輭��ã��;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int place = -1;
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                place = i;
            }
        }
        answer = "�輭���� "+place+"�� �ִ�";
        return answer;
    }
}
