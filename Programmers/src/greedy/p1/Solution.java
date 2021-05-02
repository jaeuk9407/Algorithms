package greedy.p1;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] howMany = new int[n + 1];
        Arrays.fill(howMany, 1);
        
        // 여벌을 가져온 학생 처리
        for(int i = 0; i < reserve.length; i++){
            howMany[reserve[i]]++;
        }
        // 여벌을 가져온 학생이 도난당했다면 빌려줄 수 없음
        for(int i = 0; i < lost.length; i++){
            howMany[lost[i]]--;
        }
        // 주위에서 빌릴 수 있으면 빌리고, 체육복 개수를 변경 
        for(int i = 1; i < howMany.length; i++){
            if(howMany[i] == 0){
                if(i - 1 >= 1 && howMany[i - 1] >= 2){
                    howMany[i - 1]--;
                    howMany[i]++;
                }else if(i + 1 < howMany.length && howMany[i + 1] >= 2){
                    howMany[i + 1]--;
                    howMany[i]++;
                }
            }
        }
        
        // 체육복을 갖지 못한 학생 수 계산
        for(int i = 1; i < howMany.length; i++){
            if(howMany[i] == 0){
                answer--;
            }
        }
        
        return answer;
    }
}