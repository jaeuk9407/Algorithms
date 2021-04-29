package heap.p2;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        ArrayList<Integer> timeCosts = new ArrayList<>();
        boolean[] isCompleted = new boolean[jobs.length];
        int completedCount = 0;
        
        // 현재 시점 실행할 수 있는 작업들의 대기 큐
        PriorityQueue<Job> waitQ = new PriorityQueue<>(new Comparator<>(){
           @Override
            public int compare(Job o1, Job o2){
                if(o1.timeCost <= o2.timeCost){
                    return -1;
                }
                return 1;
            } 
        });
        
        // 현재 시점 실행할 수 없는 작업들의 대기 큐
        PriorityQueue<Job> restQ = new PriorityQueue<>(new Comparator<>(){
           @Override
            public int compare(Job o1, Job o2){
                if(o1.inTime <= o2.inTime){
                    return -1;
                }
                return 1;
            }
        });
        
        // 초기 들어온 시간순으로 작업을 정렬
        for(int i = 0; i < jobs.length; i++){
            Job job = new Job(jobs[i][0], jobs[i][1]);
            restQ.add(job);
        }
        // getEnableJobs(waitQ, restQ, time);
        
        // 1.처리되지 않은 요청이 있다면
        while(completedCount < jobs.length){
            getEnableJobs(waitQ, restQ, time);
            // 2. 현재 시점에 처리할 수 있는 요청이 없으면
            if(waitQ.isEmpty()){
                // 2.1. 남은 요청 중 가장 먼저 들어오는 요청까지 대기
                Job next = restQ.poll();
                int rest = next.inTime - time;
                time += rest;
                // 2.2. 처리할 수 있는 작업으로 처리
                waitQ.add(next);
            }
            // 3. 현재 시점에 처리할 수 있으면(1, 2에 의해 반드시 가능)
            // 3.1. 그 중 수행시간이 가장 짧은 작업 수행
            Job now = waitQ.poll();
            int actTime = now.timeCost;
            time += actTime;
            // 3.2. 현재 작업 수행 완료
            completedCount++;
            int totalTime =  time - now.inTime;
            timeCosts.add(totalTime);
        }
        // 작업 수행 시간들의 평균 계산
        answer = getAvg(timeCosts);
        return answer;
    }
    
    // 현재 시간에 수행할 수 있는 Job을 대기 큐로 삽입함
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
    
    
    // 작업들의 수행시간을 받아 평균 수행시간을 반환함
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
