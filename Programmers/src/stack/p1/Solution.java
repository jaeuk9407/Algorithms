package stack.p1;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;
        int time = 0;
        
        Queue<Truck> bridge = new LinkedList<>();
        

        for(int i = 0; i < truck_weights.length; i++){
            time++;
            
            // 현재 대기 트럭이 무게로 인해 들어갈 수 없거나 다리가 꽉 차있다면
            while(bridge_weight + truck_weights[i] > weight || bridge_length <= bridge.size()){
            	// 가장 앞에 있는 트럭을 꺼냄 
                Truck out_truck = bridge.poll();
                bridge_weight -= out_truck.weight;

                // 가장 앞에 있는 트럭이 나오는 시간 : 다리 길이 - 현재 트럭의 위치(현재 시간 - 트럭이 진입한 시간)
                // 이전 시간에 나왔어야 할 트럭이라면 고려하지 않음
                if(bridge_length - (time - out_truck.in_time) >= 0){
                    time += bridge_length - (time - out_truck.in_time);
                }
                System.out.println("트럭 out, 현재 시간: "+time+", 다리 하중: "+bridge_weight);
            }
            // 반드시 현재 대기 트럭이 들어갈 수 있으므로 현재 시간을 기록해 들어감
            Truck in_truck = new Truck(time, truck_weights[i]);
            bridge.add(in_truck);
            bridge_weight += in_truck.weight;
            System.out.println(i+"번째 트럭 in, 현재 시간: "+time+", 다리 하중: "+bridge_weight);
        }
        
        // 마지막 트럭이 빠지는 시간만 계산(= 다리 길이)
        // 다리에 얼마나 들어 있든 마지막 트럭이 나갈 때까지 시간을 check 해야 함.
        time += bridge_length;
        System.out.println("트럭 out, 현재 시간: "+time+", 다리 하중: "+bridge_weight);
        
        answer = time;
        return answer;
    }
}

class Truck{
	// 다리 진입 시간, 무게
    int in_time, weight;
    
    public Truck(int in_time, int weight){
        this.in_time = in_time;
        this.weight = weight;
    }
}
