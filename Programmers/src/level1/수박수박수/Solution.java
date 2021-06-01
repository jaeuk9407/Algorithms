package level1.수박수박수;

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                sb.append("수");
            }else{
                sb.append("박");
            }
        }
        answer = sb.toString();
        
        return answer;
    }
}
