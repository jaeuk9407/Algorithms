package stack.p1;

import java.util.LinkedList;
import java.util.Queue;

public class Reference {
	private class Truck {
        int weight;	// 트럭 무게
        int move;	// 큐 내 위치 

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    private int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        // 모든 트럭을 대기열에 추가 
        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;	// 현재 다리 하중 

        // 대기열이 비어있지 않거나, 현재 다리 내부가 비어있지 않으면 수행
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            // 다리 내부가 비어있으면 대기열에서 바로 추가, 하중 update, 다음 트럭 검토
            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            // 다리 위 모든 트럭을 이동
            // O(bridge_length * truck_weights.length) = O(10000^2) = O(1억)
            for (Truck t : moveQ) {
                t.moving();
            }

            // 다리를 건넌 트럭 처리
            // 가장 멀리 있는 트럭이 다리를 건넜다면 다리 큐에서 제거, 하중 update
            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            // 대기 큐에 원소가 남아있고, 감당할 수 있다면 대기 큐의 front를 꺼내 다리 큐로 삽입
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}
