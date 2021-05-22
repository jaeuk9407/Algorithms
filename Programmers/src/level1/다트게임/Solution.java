package level1.다트게임;

import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        // 게임 단위로 parsing
        String[] results = parseGame(dartResult);
        // 게임 단위 점수를 담을 스택
        Stack<Integer> stack = new Stack<>();
        
        // 각 게임 점수 계산
        calc(results[0], stack);
        calc(results[1], stack);
        calc(results[2], stack);
        
        // 게임 결과를 더해 총 점수 계산
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        
        return answer;
    }
    
    // 게임 차례 단위 점수 계산
    public void calc(String game, Stack<Integer> stack){
        int number = -1;
        char bonus = '-';
        char option = '-';
        
        int index = 0;
        // 한 게임의 결과를 바탕으로 점수, 보너스, 옵션을 파싱
        while(index < game.length()){
            char now = game.charAt(index);
            // 보너스 값의 index를 찾으면 그 앞은 점수, 뒤는 option으로 파싱
            if(now == 'S' || now == 'D' || now == 'T'){
                // number와 bonus 입력
                number = Integer.parseInt(game.substring(0, index));
                bonus = game.charAt(index);
                // bonus 뒤에 문자가 더 있다면 option값으로 입력
                if(index < game.length() - 1){
                    option = game.charAt(index + 1);
                }
                break;
            }
            index++;
        } // end of while
        
        // bonus processing
        if(bonus == 'D'){
            number = number * number;
        }else if(bonus == 'T'){
            number = number * number * number;
        }
        
        // option processing
        if(option == '*'){
            // *의 경우 이전 게임이 존재하면 꺼내서 *2해서 다시 넣음
            if(!stack.isEmpty()){
                int before = stack.pop();
                before *= 2;
                stack.push(before);
            }
            // 현재 게임 점수 * 2
            stack.push(number * 2);            
        }else if(option == '#'){
            // #의 경우 현재 게임 점수만 -1을 곱해 넣음
            stack.push(number * (-1));
        }else{
            // option이 없는 경우 그대로 넣음
            stack.push(number);
        }
    }// end of calc()
    
    // 주어진 문자열으로 3개 게임 결과를 각각 파싱해 반환
    public String[] parseGame(String dartResult){
        String[] results = new String[3];
        int keyIndex = 0;   // results의 index
        int start = 0;  // parsing을 시작할 index
        int end = -1;   // parsing의 마지막 index(해당값 비포함)
        int index = 0;  // dartResult 탐색 인덱스
        
        // dartResult를 처음부터 끝까지 탐색
        while(index < dartResult.length()){
            char now = dartResult.charAt(index);
            // 현재 위치 값이 문자이고
            if(now == 'S' || now == 'D' || now == 'T' 
               || now == '#' || now == '*'){
                // 현재 위치가 문자열의 마지막 인덱스면 현재까지 담고 바로 break;
                if(index == dartResult.length() - 1){
                    String temp = dartResult.substring(start);
                    results[keyIndex++] = temp;
                    break;
                }
                // 다음 위치 값이 숫자이면 파싱
                char next = dartResult.charAt(index+1);
                if('0' <= next && next <= '9') {
                    end = index + 1;
                    // start 인덱스부터 파싱해 결과를 담음
                    String temp = dartResult.substring(start, end);
                    results[keyIndex++] = temp;
                    // start는 그 다음 숫자 index로 다시 설정
                    start = index + 1;
                }
            }
            index++;
        }
        return results;
    } // end of parseGame()
}
