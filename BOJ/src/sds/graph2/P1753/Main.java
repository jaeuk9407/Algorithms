package sds.graph2.P1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int V, E;
	static int start;
	static int[] dist;
	static ArrayList<Node> adj[];
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		// initialize
		dist = new int[V + 1];
		adj = new ArrayList[V + 1];
		
		int INF = 300000;
		
		for(int i = 1; i <= V; i++) {
			dist[i] = INF;
			adj[i] = new ArrayList<>();
		}
		
		// input processing
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Node(v, w));
		}
		
		// dijkstra alg
		dijkstra(start);

		
		// output processing
		for(int i = 1; i <= V; i++){
			if(dist[i] == INF) {
				sb.append("INF\n");
			}else {
				sb.append(dist[i]+"\n");
			}
		}
		System.out.println(sb.toString());
		
	}// end of main
	
	private static void dijkstra(int start_node) {
		
		dist[start_node] = 0;
		pq.add(new Node(start_node, 0));
		
		while(!pq.isEmpty()) {
			// 1. 큐에서 꺼낸다.
			Node cur = pq.poll();
			
			// 예외 처리 -> 방문한 적 있으면 건너 뜀
			if(dist[cur.node_num] < cur.node_dist) continue;
			
			// 3. 연결된 곳 순회
			for(int i = 0; i < adj[cur.node_num].size(); i++) {
				Node next = adj[cur.node_num].get(i);
				
				// 4. 갈 수 있는가(갱신할 수 있는가)
				if(cur.node_dist + next.node_dist < dist[next.node_num]) {
					// 5. 간다. + 체크아웃
					dist[next.node_num] = cur.node_dist + next.node_dist;
					pq.add(new Node(next.node_num, dist[next.node_num]));
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