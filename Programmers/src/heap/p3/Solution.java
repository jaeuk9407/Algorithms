package heap.p3;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        // init
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1 >= o2) return -1;
                return 1;
            }
        });
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        // operations
        for(String op : operations){
            String[] cmd = op.split(" ");
            if(cmd[0].equals("I")){
                maxQ.add(Integer.parseInt(cmd[1]));
                minQ.add(Integer.parseInt(cmd[1]));
            }else if(cmd[0].equals("D")){
                if(cmd[1].equals("1") && !maxQ.isEmpty()){
                    int result = maxQ.poll();
                    minQ.remove(result);
                }else if(cmd[1].equals("-1") && !minQ.isEmpty()){
                    int result = minQ.poll();
                    maxQ.remove(result);
                }
            }
        }
        
        // 반환할 결과 삽입
        answer = new int[2];
        if(!maxQ.isEmpty()){
            answer[0] = maxQ.poll();
        }
        if(!minQ.isEmpty()){
            answer[1] = minQ.poll();
        }
        
        return answer;
    }
}