package stack.p3;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {0};
        // ���� ����� ������ �ڿ� ��ɵ� ������ �� �� �ִ�.. Queue<����ε���>
        Queue<Integer> q = new LinkedList<>();
        // ���� ����(K: ���� �ε���, V: ��� ����)
        HashMap<Integer, Integer> deployInfo = new HashMap<>();
        
        // ��� ����� ť�� ����
        for(int i = 0; i < speeds.length; i++){
            q.add(i);
        }
        
        // ���� ������ȣ
        int deployKey = 1;
        while(!q.isEmpty()){
            // �� ����� ��ô�� ������Ʈ
            Iterator<Integer> itr = q.iterator();
            while(itr.hasNext()){
                int funcIndex = itr.next();
                progresses[funcIndex] += speeds[funcIndex];
                
            }
            
            // ���� front ����� 100%��
            // 100%�� ��� ����ŭ out
            int outCount = 0;
            while(progresses[q.peek()] >= 100){
                q.poll();
                outCount++;
                if(q.isEmpty()){
                    break;
                }
            }
            // ������ ����� �־��ٸ� �ش� ���� ����
            if(outCount != 0){
                deployInfo.put(deployKey, outCount);
                deployKey++;
            }
        }
        
        /* ��� ��� ���� �Ϸ� */
        answer = new int[deployInfo.size()];
        for(int i = 0; i < deployInfo.size(); i++){
            answer[i] = deployInfo.get(i + 1);
        }
        
        return answer;
    }
}