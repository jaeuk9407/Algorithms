package bfsdfs.p1;

import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = bfs(numbers, target);        
        return answer;
    }
   
    public int bfs(int[] numbers, int target){
        // 큐에 넣는다
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0));
        int cnt = 0;
        
        while(!q.isEmpty()){
            // index: 현재 검사항 인덱스, value: 이전 인덱스까지의 연산 결과
            Info now = q.poll();
            // 현재 인덱스의 값까지 +, - 결과
            int numPlus = plus(now.value, numbers[now.index]);
            int numSubs = substract(now.value, numbers[now.index]);
            Info nextPlus = new Info(now.index+1, numPlus);
            Info nextSubs = new Info(now.index+1, numSubs);
            
            // 더 탐색해야 할 수가 남아있다면 현재까지의 연산 결과를 큐에 넣어줌
            if(now.index < numbers.length - 1){
                q.add(nextPlus);
                q.add(nextSubs);
            }else if(now.index == numbers.length -1){
                // 더 탐색할 수가 남지 않았다면 target과 검사 
                if(numPlus == target){
                    cnt++;
                }
                if(numSubs == target){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public int plus(int num1, int num2){
        return num1 + num2;
    }
    public int substract(int num1, int num2){
        return num1 - num2;
    }   
}

class Info{
    int index, value;
    
    public Info(int index, int value){
        this.index = index;
        this.value = value;
    }
}
