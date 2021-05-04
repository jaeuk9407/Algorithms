package es.p1;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        // 각 학생의 패턴
        int[] patternOne = {1, 2, 3, 4, 5};
        int[] patternTwo = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] patternThree = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int one = 0, two = 0, three = 0;    // 각 학생 패턴의 인덱스
        int scoreOne = 0, scoreTwo = 0, scoreThree = 0;     // 각 학생 점수
        
        // 각 문항들을 검사
        for(int i = 0; i < answers.length; i++){
            // 학생별 패턴대로 현재 문항에서의 값과 정답 비교
            if(patternOne[one++] == answers[i]){
                scoreOne++;
            }
            if(patternTwo[two++] == answers[i]){
                scoreTwo++;
            }
            if(patternThree[three++] == answers[i]){
                scoreThree++;
            }
            // 각 학생의 패턴이 끝났다면 처음부터 반복
            if(one == patternOne.length){
                one = 0;
            }
            if(two == patternTwo.length){
                two = 0;
            }
            if(three == patternThree.length){
                three = 0;
            }
        }
        // 각 학생의 최대 점수 저장
        int max = 0;
        ArrayList<Integer> al = new ArrayList<>();
        max = Math.max(max, Math.max(scoreOne, Math.max(scoreTwo, scoreThree)));
        
        // 최대 점수를 가진 학생은 리스트에 추가
        if(scoreOne == max){
            al.add(1);
        }
        if(scoreTwo == max){
            al.add(2);
        }
        if(scoreThree == max){
            al.add(3);
        }
        
        // 정렬 후 반환할 결과 배열에 입력
        Collections.sort(al);
        answer = al.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
