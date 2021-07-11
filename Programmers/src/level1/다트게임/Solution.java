package level1.다트게임;

import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        // ���� ������ parsing
        String[] results = parseGame(dartResult);
        // ���� ���� ������ ���� ����
        Stack<Integer> stack = new Stack<>();
        
        // �� ���� ���� ���
        calc(results[0], stack);
        calc(results[1], stack);
        calc(results[2], stack);
        
        // ���� ����� ���� �� ���� ���
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        
        return answer;
    }
    
    // ���� ���� ���� ���� ���
    public void calc(String game, Stack<Integer> stack){
        int number = -1;
        char bonus = '-';
        char option = '-';
        
        int index = 0;
        // �� ������ ����� �������� ����, ���ʽ�, �ɼ��� �Ľ�
        while(index < game.length()){
            char now = game.charAt(index);
            // ���ʽ� ���� index�� ã���� �� ���� ����, �ڴ� option���� �Ľ�
            if(now == 'S' || now == 'D' || now == 'T'){
                // number�� bonus �Է�
                number = Integer.parseInt(game.substring(0, index));
                bonus = game.charAt(index);
                // bonus �ڿ� ���ڰ� �� �ִٸ� option������ �Է�
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
            // *�� ��� ���� ������ �����ϸ� ������ *2�ؼ� �ٽ� ����
            if(!stack.isEmpty()){
                int before = stack.pop();
                before *= 2;
                stack.push(before);
            }
            // ���� ���� ���� * 2
            stack.push(number * 2);            
        }else if(option == '#'){
            // #�� ��� ���� ���� ������ -1�� ���� ����
            stack.push(number * (-1));
        }else{
            // option�� ���� ��� �״�� ����
            stack.push(number);
        }
    }// end of calc()
    
    // �־��� ���ڿ����� 3�� ���� ����� ���� �Ľ��� ��ȯ
    public String[] parseGame(String dartResult){
        String[] results = new String[3];
        int keyIndex = 0;   // results�� index
        int start = 0;  // parsing�� ������ index
        int end = -1;   // parsing�� ������ index(�ش簪 ������)
        int index = 0;  // dartResult Ž�� �ε���
        
        // dartResult�� ó������ ������ Ž��
        while(index < dartResult.length()){
            char now = dartResult.charAt(index);
            // ���� ��ġ ���� �����̰�
            if(now == 'S' || now == 'D' || now == 'T' 
               || now == '#' || now == '*'){
                // ���� ��ġ�� ���ڿ��� ������ �ε����� ������� ��� �ٷ� break;
                if(index == dartResult.length() - 1){
                    String temp = dartResult.substring(start);
                    results[keyIndex++] = temp;
                    break;
                }
                // ���� ��ġ ���� �����̸� �Ľ�
                char next = dartResult.charAt(index+1);
                if('0' <= next && next <= '9') {
                    end = index + 1;
                    // start �ε������� �Ľ��� ����� ����
                    String temp = dartResult.substring(start, end);
                    results[keyIndex++] = temp;
                    // start�� �� ���� ���� index�� �ٽ� ����
                    start = index + 1;
                }
            }
            index++;
        }
        return results;
    } // end of parseGame()
}
