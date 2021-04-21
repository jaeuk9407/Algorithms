package stack.p2;

import java.util.*;

class Solution_Stack {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int time = 0;
        
        // Stack에 시간을 담는다.
        // 첫 주식은 그냥 담는다.
        Stack<Integer> stack = new Stack<>();
        stack.push(time);

        for(int i = 1; i < prices.length; i++){
            time++;
            // Stack의 top보다 큰 경우면 그냥 넣고
            if(prices[i] > prices[stack.peek()]){
                stack.push(time);
            }else{
                // top보다 작으면 현재 주식이 가장 클 때까지 top을 꺼내고, 현재 주식을 삽입한다.
                while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                    int index = stack.pop();
                    // System.out.println(time+", "+ index);
                    int time_stay = time - index;
                    // 꺼낸 주식은 해당 index에 넣어준다.
                    answer[index] = time_stay;
                }
                stack.push(time);
            }
        }
        // 남아 있는 주식이 있다면 꺼내, 시간을 넣어준다.
        while(!stack.isEmpty()){
            int index = stack.pop();
            int time_stay = time - index;
            // 꺼낸 주식은 해당 index에 넣어준다.
            answer[index] = time_stay;
        }
        
        return answer;
    }
}