package heap.p2;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        ArrayList<Integer> timeCosts = new ArrayList<>();
        boolean[] isCompleted = new boolean[jobs.length];
        int completedCount = 0;
        
        // ���� ���� ������ �� �ִ� �۾����� ��� ť
        PriorityQueue<Job> waitQ = new PriorityQueue<>(new Comparator<>(){
           @Override
            public int compare(Job o1, Job o2){
                if(o1.timeCost <= o2.timeCost){
                    return -1;
                }
                return 1;
            } 
        });
        
        // ���� ���� ������ �� ���� �۾����� ��� ť
        PriorityQueue<Job> restQ = new PriorityQueue<>(new Comparator<>(){
           @Override
            public int compare(Job o1, Job o2){
                if(o1.inTime <= o2.inTime){
                    return -1;
                }
                return 1;
            }
        });
        
        // �ʱ� ���� �ð������� �۾��� ����
        for(int i = 0; i < jobs.length; i++){
            Job job = new Job(jobs[i][0], jobs[i][1]);
            restQ.add(job);
        }
        // getEnableJobs(waitQ, restQ, time);
        
        // 1.ó������ ���� ��û�� �ִٸ�
        while(completedCount < jobs.length){
            getEnableJobs(waitQ, restQ, time);
            // 2. ���� ������ ó���� �� �ִ� ��û�� ������
            if(waitQ.isEmpty()){
                // 2.1. ���� ��û �� ���� ���� ������ ��û���� ���
                Job next = restQ.poll();
                int rest = next.inTime - time;
                time += rest;
                // 2.2. ó���� �� �ִ� �۾����� ó��
                waitQ.add(next);
            }
            // 3. ���� ������ ó���� �� ������(1, 2�� ���� �ݵ�� ����)
            // 3.1. �� �� ����ð��� ���� ª�� �۾� ����
            Job now = waitQ.poll();
            int actTime = now.timeCost;
            time += actTime;
            // 3.2. ���� �۾� ���� �Ϸ�
            completedCount++;
            int totalTime =  time - now.inTime;
            timeCosts.add(totalTime);
        }
        // �۾� ���� �ð����� ��� ���
        answer = getAvg(timeCosts);
        return answer;
    }
    
    // ���� �ð��� ������ �� �ִ� Job�� ��� ť�� ������
    public void getEnableJobs(PriorityQueue<Job> waitQ, PriorityQueue<Job> restQ, int time){
        while(!restQ.isEmpty()){
            Job first = restQ.peek();
            if(time >= first.inTime){
                restQ.poll();
                waitQ.add(first);
            }else{
                break;
            }
        }
    }
    
    
    // �۾����� ����ð��� �޾� ��� ����ð��� ��ȯ��
    public int getAvg(ArrayList<Integer> timeCosts){
        int result = 0;
        
        for(int i = 0; i < timeCosts.size(); i++){
            result += timeCosts.get(i);
        }
        
        result /= timeCosts.size();
        return result;
    }
}

class Job{
    int inTime;
    int timeCost;
    
    public Job(int inTime, int timeCost){
        this.inTime = inTime;
        this.timeCost = timeCost;
    }
    
    @Override
    public String toString(){
        return "["+inTime+", "+timeCost+"]";
    }
}
