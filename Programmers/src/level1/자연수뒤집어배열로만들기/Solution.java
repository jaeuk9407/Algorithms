package level1.자연수뒤집어배열로만들기;

class Solution {
    public int[] solution(long n) {
        // String으로 변환
        String temp = String.valueOf(n);
        // 자릿수 길이와 같은 배열 생성
        int[] answer = new int[temp.length()];
        // answer 배열의 인덱스로 사용할 변수
        int index = 0;
        
        // temp String을 거꾸로 탐색하며 각 char 값을 int로 변환해 저장
        for(int i = temp.length() - 1; i >= 0; i--){
            answer[index++] = temp.charAt(i) - '0';
        }
        
        return answer;
    }
}
