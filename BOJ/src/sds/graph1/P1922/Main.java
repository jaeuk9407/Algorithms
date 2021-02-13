package sds.graph1.P1922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Edge> edges = new ArrayList<>();
	static int parents[];
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(a, b, c));
		}
		
		Collections.sort(edges);

		ans = 0;
		getMst();
		System.out.println(ans);
	}
	
	private static void getMst() {
		
		// cost가 낮은 edge부터 하나하나
		for(int i = 0 ; i < edges.size(); i++) {
			Edge now = edges.get(i);
			
			// cycle이 존재하지 않는 경우만 연결해준다.
			if(findP(now.a) != findP(now.b)) {
				unionP(now.a, now.b);
				ans += now.c;
			}
		}
	}
	
	private static int findP(int x) {
		if(parents[x] != x) {
			parents[x] = findP(parents[x]);
		}
		return parents[x];
	}
	
	private static void unionP(int a, int b) {
		a = findP(a);
		b = findP(b);
		
		if(a < b) {
			parents[b] = a;
		}else {
			parents[a] = b;
		}
	}

}

class Edge implements Comparable<Edge>{
	int a, b, c;

	public Edge(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public int compareTo(Edge o) {
		if(this.c <= o.c) return -1;
		return 1;
	}
}