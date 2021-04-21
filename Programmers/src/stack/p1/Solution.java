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
            
            // ���� ��� Ʈ���� ���Է� ���� �� �� ���ų� �ٸ��� �� ���ִٸ�
            while(bridge_weight + truck_weights[i] > weight || bridge_length <= bridge.size()){
            	// ���� �տ� �ִ� Ʈ���� ���� 
                Truck out_truck = bridge.poll();
                bridge_weight -= out_truck.weight;

                // ���� �տ� �ִ� Ʈ���� ������ �ð� : �ٸ� ���� - ���� Ʈ���� ��ġ(���� �ð� - Ʈ���� ������ �ð�)
                // ���� �ð��� ���Ծ�� �� Ʈ���̶�� ������� ����
                if(bridge_length - (time - out_truck.in_time) >= 0){
                    time += bridge_length - (time - out_truck.in_time);
                }
                System.out.println("Ʈ�� out, ���� �ð�: "+time+", �ٸ� ����: "+bridge_weight);
            }
            // �ݵ�� ���� ��� Ʈ���� �� �� �����Ƿ� ���� �ð��� ����� ��
            Truck in_truck = new Truck(time, truck_weights[i]);
            bridge.add(in_truck);
            bridge_weight += in_truck.weight;
            System.out.println(i+"��° Ʈ�� in, ���� �ð�: "+time+", �ٸ� ����: "+bridge_weight);
        }
        
        // ������ Ʈ���� ������ �ð��� ���(= �ٸ� ����)
        // �ٸ��� �󸶳� ��� �ֵ� ������ Ʈ���� ���� ������ �ð��� check �ؾ� ��.
        time += bridge_length;
        System.out.println("Ʈ�� out, ���� �ð�: "+time+", �ٸ� ����: "+bridge_weight);
        
        answer = time;
        return answer;
    }
}

class Truck{
	// �ٸ� ���� �ð�, ����
    int in_time, weight;
    
    public Truck(int in_time, int weight){
        this.in_time = in_time;
        this.weight = weight;
    }
}
