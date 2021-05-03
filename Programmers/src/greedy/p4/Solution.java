package greedy.p4;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean[] isOnBoard = new boolean[people.length];
        
        // 정렬
        Arrays.sort(people);
        
        int i = 0;
        int j = people.length - 1;
        
        while(true){
            if(i == people.length || j < 0) break;
            // 아직 타지 않았다면 매칭 대상
            if(!isOnBoard[i]){
                // j번째 사람도 타지 않았고, 함께 탈 수 있는 몸무게면 함께 탐
                if(!isOnBoard[j] && people[i] + people[j] <= limit){
                    isOnBoard[i] = true;
                    isOnBoard[j] = true;
                    answer++;
                }
                // j번째가 탔든, 타지 못했든 다음 j 매칭 준비
                j--;
            }else{
                // i번째가 매칭 완료됐다면 다음 i 탐색
                i++;
            }
        }
        
        // 몸무게가 작은 사람부터 같이 탈 수 있는 사람중 가장 큰사람과 매칭
        // for(int i = 0; i < people.length; i++){
        //     // 아직 타지 않았다면 매칭 대상
        //     if(!isOnBoard[i]){
        //         for(int j = people.length-1; j >= 0; j--){
        //             if(!isOnBoard[j] && people[i] + people[j] <= limit){
        //                 isOnBoard[i] = true;
        //                 isOnBoard[j] = true;
        //                 answer++;
        //                 break;
        //             }
        //         }
        //     }
        // }
        
        // matching되지 않은 사람들은 혼자 탐
        for(int p = 0; p < people.length; p++){
            if(!isOnBoard[p]) answer++;
        }
        return answer;
    }
}