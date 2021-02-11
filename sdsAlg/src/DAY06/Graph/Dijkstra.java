package DAY06.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
	// 인접리스트, 거리테이블, Priority Queue, Class
	// P1753
	static int v, e, start_point;
	static ArrayList<Node> adj[];	// 인접리스트
	static PriorityQueue<Node> pq;	// 우선순위 큐
	static int dist[];
	static int INF = 300000;	// 문제에서 주어진 최대 길이 20만
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[v+1];
		for(int i = 0; i<=v; i++) {
			adj[i] = new ArrayList<>();
		}
		pq = new PriorityQueue<>();
		dist = new int[v+1];
		
		st = new StringTokenizer(br.readLine());
		
		start_point = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
		}
		
		for(int i = 0; i <= v; i++) {
			dist[i] = INF;
		}
		
		dijk();
		
		for(int i = 1; i <= v; i++) {
			if(dist[i] != INF) {
				System.out.println(dist[i]);
			}else {
				System.out.println("INF");
			}
		}
		
	}
	
	static void dijk() {
		// 0. 출발 노드를 설정(거리테이블 초기화, 우선순위 큐 삽입)
		dist[start_point] = 0;
		pq.add(new Node(start_point, 0));
		
		// 1. 큐에서 꺼낸다
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
//			System.out.println("node num: "+cur.node_num+" dist: "+cur.node_dist +"dist[]: "+dist[cur.node_num]);
			
			// 2. 방문한 적이 있는 노드라면 건너뛴다
			if(dist[cur.node_num] < cur.node_dist) continue;
			
			// 3. 연결된 곳을 순회
			for(int i = 0; i < adj[cur.node_num].size(); i++) {
				Node nxt = adj[cur.node_num].get(i);
				int tmp = cur.node_dist + nxt.node_dist; // 현재점(cur) -> 다음점(nxt)로 이동할 때 드는 비용
				
				// 4. 갱신할 수 있는가 (거리테이블 수치보다 누적 거리가 작은가)
				if(tmp < dist[nxt.node_num]) {
					// 5. 갱신
					dist[nxt.node_num] = tmp;
					
					// 6. 큐에 넣는다
					pq.add(new Node(nxt.node_num, tmp));
				}
			}
		}
	}

}

class Node implements Comparable<Node>{
	int node_num, node_dist;

	public Node(int node_num, int node_dist) {
		this.node_num = node_num;
		this.node_dist = node_dist;
	}

	@Override
	public int compareTo(Node o) {
		if(this.node_dist < o.node_dist) {
			return -1;
		}else if(this.node_dist >o.node_dist){
			return 1;
		}else {
			return 0;
		}
	}
}
