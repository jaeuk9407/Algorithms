package stack.p2;

import java.util.*;

class Solution_Stack {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int time = 0;
        
        // Stack�� �ð��� ��´�.
        // ù �ֽ��� �׳� ��´�.
        Stack<Integer> stack = new Stack<>();
        stack.push(time);

        for(int i = 1; i < prices.length; i++){
            time++;
            // Stack�� top���� ū ���� �׳� �ְ�
            if(prices[i] > prices[stack.peek()]){
                stack.push(time);
            }else{
                // top���� ������ ���� �ֽ��� ���� Ŭ ������ top�� ������, ���� �ֽ��� �����Ѵ�.
                while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                    int index = stack.pop();
                    // System.out.println(time+", "+ index);
                    int time_stay = time - index;
                    // ���� �ֽ��� �ش� index�� �־��ش�.
                    answer[index] = time_stay;
                }
                stack.push(time);
            }
        }
        // ���� �ִ� �ֽ��� �ִٸ� ����, �ð��� �־��ش�.
        while(!stack.isEmpty()){
            int index = stack.pop();
            int time_stay = time - index;
            // ���� �ֽ��� �ش� index�� �־��ش�.
            answer[index] = time_stay;
        }
        
        return answer;
    }
}