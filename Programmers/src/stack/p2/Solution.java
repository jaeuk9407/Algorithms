package stack.p2;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int time = 0;
        
        // 차례로 더 작은 가격이 나타날 시간을 탐색하면 2번 탐색하므로 O(100,000^2)
        // 주식을 스택에 담으며 시간과 가격을 담고, 담을 때마다 이전에 담겨 있는 주식을 모두 check및 update O(100,000^2) -> over
        
        // 최대 힙을 구성하고, head 보다 작은 가격이 들어오면
        PriorityQueue<Stock> q = new PriorityQueue<>();
        
        for(int i = 0; i < prices.length; i++){    
            time++;
            Stock now = new Stock(i, prices[i], time);
            q.add(now);
            
            // 들어오는 price보다 큰 head 원소를 모두 꺼내 result에 담는다. O(100000 * log 100000)
            // 힙이 비어 있지 않은 경우에만 조사(NullPointerException)
            if(!q.isEmpty()){
                while(now.price < q.peek().price){
                    Stock out_stock = q.poll();
                    answer[out_stock.index] = time - out_stock.in_time;
                    // System.out.println(out_stock.index+"번 주식 out");
                    // System.out.println("경과 시간:"+answer[out_stock.index]);
                    // System.out.println(q.toString());
                }
            }
            // System.out.println(i+"번 주식 in");
            // System.out.println("현재 시간:"+time);
            // System.out.println(q.toString());
        }
        
        // 배열의 끝까지 자신보다 작은 주식 가격이 없었다면, 모두 빼서 result에 시간 입력
        while(!q.isEmpty()){
            Stock out_stock = q.poll();
            answer[out_stock.index] = time - out_stock.in_time;
            // System.out.println(out_stock.index+"번 주식 out");
            // System.out.println("경과 시간:"+answer[out_stock.index]);
            // System.out.println(q.toString());
        }
        
        // System.out.println(Arrays.toString(answer));
        
        
        return answer;
    }
}

class Stock implements Comparable<Stock>{
    int index, price, in_time;
    
    public Stock(int index, int price, int in_time){
        this.index = index;
        this.price = price;
        this.in_time = in_time;
    }
    
    @Override
    public int compareTo(Stock o){
        if(this.price > o.price){
            return -1;
        }else{
            return 1;
        }
    }
    @Override
    public String toString(){
        return "[index: "+index+"]";
    }
}