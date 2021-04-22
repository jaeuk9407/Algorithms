package bfsdfs.p1;

import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = bfs(numbers, target);        
        return answer;
    }
   
    public int bfs(int[] numbers, int target){
        // ť�� �ִ´�
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0));
        int cnt = 0;
        
        while(!q.isEmpty()){
            // index: ���� �˻��� �ε���, value: ���� �ε��������� ���� ���
            Info now = q.poll();
            // ���� �ε����� ������ +, - ���
            int numPlus = plus(now.value, numbers[now.index]);
            int numSubs = substract(now.value, numbers[now.index]);
            Info nextPlus = new Info(now.index+1, numPlus);
            Info nextSubs = new Info(now.index+1, numSubs);
            
            // �� Ž���ؾ� �� ���� �����ִٸ� ��������� ���� ����� ť�� �־���
            if(now.index < numbers.length - 1){
                q.add(nextPlus);
                q.add(nextSubs);
            }else if(now.index == numbers.length -1){
                // �� Ž���� ���� ���� �ʾҴٸ� target�� �˻� 
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
