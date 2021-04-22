package stack.p4;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int time = 0;   // ���ϴ� ������ ��µǴ� ����
        
        Queue<Docs> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            Docs docs = new Docs(i, priorities[i]);
            q.add(docs);
        }
        
        while(!q.isEmpty()){
            // 1. �μ� ������� ���� �տ� �ִ� ����(front)�� ����Ͽ��� ����
            Docs front = q.peek();
            boolean hasMore = false;
            // 2. ������ �μ� ����Ͽ� front���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� ����
            Iterator<Docs> itr = q.iterator();
            while(itr.hasNext()){
                Docs next = itr.next();
                if(front.priority < next.priority){
                    hasMore = true;
                }
            }
            
            // 3. �׷��� ������ front�� �μ�
            if(!hasMore){
                q.poll();
                time++;
                // ã���� �ϴ� ������� ���� ������ ������ ä�� �ݺ��� Ż��
                if(front.index == location){
                    break;
                }
            }else{
                // �� �߿��� ������ �����Ƿ� �� �ڷ� ����
                q.add(front);
                q.poll();
            }
        }
        
        answer = time;
        return answer;
    }
}

// ����
class Docs{
    int index;
    int priority;
    
    public Docs(int index, int priority){
        this.index = index;
        this.priority = priority;
    }
}