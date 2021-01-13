package DAY03.P1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] bags;
	static Jewelry[] jewelries;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		jewelries = new Jewelry[N];
		bags = new int[K];
		
		// jewelries 정보 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken()); 
			int v = Integer.parseInt(st.nextToken());
			
			Jewelry temp = new Jewelry(m, v);
			jewelries[i] = temp;
		}
		
		// bags 정보 입력
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()); 
			bags[i] = c;
		}
		
		// 가방 정렬 
		Arrays.sort(bags);
		
		// 보석 무게순 정렬
		Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
		
		// 보석 높은값 기준 힙 
		PriorityQueue<Jewelry> pq = new PriorityQueue<Jewelry>(Comparator.comparing(Jewelry::getValue).reversed());
		
		int jIndex = 0;
		long result = 0;
		// 1. 남은 가방 중 제일 작은 가방을 선택 <- 정렬 
		for(int i = 0; i < bags.length; i++) {
			// 2. 선택된 가방에 넣을 수 있는 남은 보석 중 가장 비싼 보석을 선택 <- 힙을 사용
			while(jIndex < N && jewelries[jIndex].weight <= bags[i]) {
				pq.add(jewelries[jIndex++]);
			}
			// 앞서 가방에 보석을 넣었다면 가장 비싼 보석을 빼서 result에 넣어줌
			if(!pq.isEmpty()) {
				result += pq.poll().value;
			}
		}
		System.out.println(result);
	}

}

class Jewelry {
	int weight;
	int value;
	
	public Jewelry(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	public int getWeight() {
		return weight;
	}
	public int getValue() {
		return value;
	}
}
