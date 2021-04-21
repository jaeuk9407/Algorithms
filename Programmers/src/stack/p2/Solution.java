package stack.p2;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int time = 0;
        
        // ���ʷ� �� ���� ������ ��Ÿ�� �ð��� Ž���ϸ� 2�� Ž���ϹǷ� O(100,000^2)
        // �ֽ��� ���ÿ� ������ �ð��� ������ ���, ���� ������ ������ ��� �ִ� �ֽ��� ��� check�� update O(100,000^2) -> over
        
        // �ִ� ���� �����ϰ�, head ���� ���� ������ ������
        PriorityQueue<Stock> q = new PriorityQueue<>();
        
        for(int i = 0; i < prices.length; i++){    
            time++;
            Stock now = new Stock(i, prices[i], time);
            q.add(now);
            
            // ������ price���� ū head ���Ҹ� ��� ���� result�� ��´�. O(100000 * log 100000)
            // ���� ��� ���� ���� ��쿡�� ����(NullPointerException)
            if(!q.isEmpty()){
                while(now.price < q.peek().price){
                    Stock out_stock = q.poll();
                    answer[out_stock.index] = time - out_stock.in_time;
                    // System.out.println(out_stock.index+"�� �ֽ� out");
                    // System.out.println("��� �ð�:"+answer[out_stock.index]);
                    // System.out.println(q.toString());
                }
            }
            // System.out.println(i+"�� �ֽ� in");
            // System.out.println("���� �ð�:"+time);
            // System.out.println(q.toString());
        }
        
        // �迭�� ������ �ڽź��� ���� �ֽ� ������ �����ٸ�, ��� ���� result�� �ð� �Է�
        while(!q.isEmpty()){
            Stock out_stock = q.poll();
            answer[out_stock.index] = time - out_stock.in_time;
            // System.out.println(out_stock.index+"�� �ֽ� out");
            // System.out.println("��� �ð�:"+answer[out_stock.index]);
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