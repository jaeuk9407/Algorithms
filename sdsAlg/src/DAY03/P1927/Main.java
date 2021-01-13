package DAY03.P1927;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		MinHeap mh = new MinHeap();
		
		for (int i = 0; i < N; i++) {
			int request  = sc.nextInt();
			if(request != 0) {
				mh.insert(request);
			}else {
				if(mh.list.size() <= 1) {
					System.out.println(0);
					continue;
				}else {
					System.out.println(mh.delete());
				}
			}
		}
		
		sc.close();

	}

}

class MinHeap{
	List<Integer> list;
	
	public MinHeap() {
		list = new ArrayList<>();
		list.add(0);
	}
	
	public void insert(int val) {
		// 제일 끝에 항목 추가 
		list.add(val);
		
		int current = list.size() - 1;
		int parent = current / 2;
		
		
		while(true) {
			// root에 도달한 경우 
			if(current == 1) {
				break;
			}
			// 부모가 나보다 작은 경우 -> 힙조건 만족
			if (list.get(current) > list.get(parent)) {
				break;
			}else {
				// 부모가 나보다 큰 경우 -> 힙조건 불만족 -> 자리 바꿔주기
				int temp = 0;
				temp = list.get(parent);
				list.set(parent, list.get(current));
				list.set(current, temp);
				
				current = parent;
				parent = current / 2;
				
			}
			
		}
		
	}
	public int delete() {
		// 루트 값을 제거 후 제일 마지막 값을 루트로 가져옴
		int top = list.get(1);
		list.set(1, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int currentPos = 1;
		
		while(true) {
			// 자식 존재 여부 확인
			int leftPos = currentPos * 2;
			int rightPos = currentPos * 2 + 1;
			
			// 자식 존재 X
			if(leftPos >= list.size()) {
				break;
			}
			// 좌측, 우측 중 작은 값 선택
			int minValue = list.get(leftPos);
			int minPos = leftPos;
			
			// 우측에 값이 존재하고, 좌측값보다 작으면 minValue, minPos Update
			if(rightPos < list.size() && list.get(rightPos) < minValue) {
				minValue = list.get(rightPos);
				minPos = rightPos;
			}
			
			// 선택한 자식이 자신보다 작은 경우
			if(minValue < list.get(currentPos)) {
				int temp = list.get(currentPos);
				list.set(currentPos, list.get(minPos));
				list.set(minPos, temp);
				currentPos = minPos;
			}else {
				// 선택한 자식이 자신보다 큰 경우
				break;
			}
		}
		return top;
	}
}