package level1.lottoMaxAndLeast;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] prizes = {6, 6, 5, 4, 3, 2, 1}; // 맞춘 개수(index)에 따른 순위(value)
        int zeroCnt = 0;    // 지워진 숫자 개수
        int correct = 0;    // 지워진 숫자 제외하고 맞춘 개수
        int max = 0;    // 최대 등수
        int least = 0;  // 최소 등수
        
        for(int myNum : lottos){
            // 구매한 번호가 0이면 개수를 세고 맞춰보지 않음
            if(myNum == 0){
                zeroCnt++;
                continue;
            }
            // 번호를 정답 번호와 비교해봄
            for(int winNum : win_nums){
                if(myNum == winNum){
                    correct++;
                }
            }
        }
        // 최소 순위와 최대 순위 검사 후 반환
        least = prizes[correct];
        max = prizes[correct+zeroCnt];
        int[] answer = {max, least};
        
        return answer;
    }
}
