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
        // ó������ ������ �� ���ھ� �ݺ��ϸ�
        for(int i = 0; i < numArr.length; i++){
            
            if(cnt >= k) break;
            pq.add(new Info(i, numArr[i]));
            
            // ������ �ϳ��� ���� ����
            while(pq.peek().value < numArr[i]){
                Info now = pq.poll();
                isRemoved[now.index] = true;
                cnt++;
                // ������ ���� ������ k�� �������� ���� ����
                if(cnt == k) break;
            }
        }
        // ���� ���� �ݺ��Ǵ� �ݷ� ó��: ���� ������ �����ϴٸ� ���� ���� ���ڸ� �տ������� ��������
        if(cnt < k){
            while(!pq.isEmpty()){
                Info removeObj = pq.poll();
                isRemoved[removeObj.index] = true;
                cnt++;
                if(cnt == k) break;
            }
        }
        // �������� ���� ���� ��ġ�� 
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