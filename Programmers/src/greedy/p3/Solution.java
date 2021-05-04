package greedy.p3;

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] numArr = number.toCharArray();
        boolean[] isRemoved = new boolean[numArr.length];
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        // 처음부터 끝까지 한 글자씩 반복하며
        for(int i = 0; i < numArr.length; i++){
            
            if(cnt >= k) break;
            pq.add(new Info(i, numArr[i]));
            
            // 힙에서 하나씩 빼며 삭제
            while(pq.peek().value < numArr[i]){
                Info now = pq.poll();
                isRemoved[now.index] = true;
                cnt++;
                // 삭제한 숫자 개수가 k와 같아지면 삭제 멈춤
                if(cnt == k) break;
            }
        }
        // 같은 수가 반복되는 반례 처리: 삭제 개수가 부족하다면 가장 작은 숫자를 앞에서부터 삭제해줌
        if(cnt < k){
            while(!pq.isEmpty()){
                Info removeObj = pq.poll();
                isRemoved[removeObj.index] = true;
                cnt++;
                if(cnt == k) break;
            }
        }
        // 삭제되지 않은 숫자 합치기 
        for(int i = 0; i < numArr.length; i++){
            if(!isRemoved[i]) sb.append(numArr[i]);
        }
        answer = sb.toString();
        return answer;
    }
}

class Info implements Comparable<Info>{
    int index, value;
    public Info(int index, int value){
        this.index = index;
        this.value = value;
    }
    
    @Override
    public int compareTo(Info o){
        if(this.value < o.value){
            return -1;
        }else if(this.value == o.value){
            return 0;
        }else{
            return 1;
        }
    }
}