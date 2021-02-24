package sds.graph1.P3830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parents, weight;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	// 종료 조건 
        	if(N == 0 && M == 0) break;
        	
        	// 초기화
        	init(N);
        	
        	for(int i = 0; i < M; i++) {
        		st = new StringTokenizer(br.readLine());
        		String cmd = st.nextToken();
        		
        		if(cmd.equals("!")) {
        			int a = Integer.parseInt(st.nextToken());
        			int b = Integer.parseInt(st.nextToken());
        			int w = Integer.parseInt(st.nextToken());
        			
        			union(a, b, w);
        			
        		}else {
        			int a = Integer.parseInt(st.nextToken());
        			int b = Integer.parseInt(st.nextToken());
        			
        			if(find(a) != find(b)) System.out.println("UNKNOWN");
        			else System.out.println(weight[b] - weight[a]);
        		}
        	}
        	
        	
        }
        
	} // end of main function
	
	private static void init(int N) {
		parents = new int[N+1];
		weight = new int[N+1];
		
		for(int i = 0 ; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static void union(int a, int b, int w) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
		// b의 무게를 a 기준으로 초기화
		weight[bRoot] += (w - weight[b] + weight[a]);
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		else {
			// 같은 집합 내 parent들의 index, weight update 
			int prv = find(parents[a]);
			weight[a] += weight[parents[a]];
			return parents[a] = prv;
		}
	}
}
