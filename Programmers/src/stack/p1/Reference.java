package stack.p1;

import java.util.LinkedList;
import java.util.Queue;

public class Reference {
	private class Truck {
        int weight;	// Ʈ�� ����
        int move;	// ť �� ��ġ 

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

        // ��� Ʈ���� ��⿭�� �߰� 
        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;	// ���� �ٸ� ���� 

        // ��⿭�� ������� �ʰų�, ���� �ٸ� ���ΰ� ������� ������ ����
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            // �ٸ� ���ΰ� ��������� ��⿭���� �ٷ� �߰�, ���� update, ���� Ʈ�� ����
            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            // �ٸ� �� ��� Ʈ���� �̵�
            // O(bridge_length * truck_weights.length) = O(10000^2) = O(1��)
            for (Truck t : moveQ) {
                t.moving();
            }

            // �ٸ��� �ǳ� Ʈ�� ó��
            // ���� �ָ� �ִ� Ʈ���� �ٸ��� �ǳԴٸ� �ٸ� ť���� ����, ���� update
            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            // ��� ť�� ���Ұ� �����ְ�, ������ �� �ִٸ� ��� ť�� front�� ���� �ٸ� ť�� ����
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}
