package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725 {
	static int N;
	static int parent[];
	static ArrayList<Integer> adj[];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dfs(1, 0);
		
		StringBuilder output = new StringBuilder();
        for (int i=2; i<=N; i++){
            output.append(parent[i]).append("\n");
        }
        System.out.println(output);
	}
	
	private static void dfs(int cur, int depth) {
		// 체크인
		visited[cur] = true;
		
		// 연결된 곳 순회
		for(int i = 0; i < adj[cur].size(); i++) {
			int next = adj[cur].get(i);
			// 갈 수 있는가
			if(!visited[next]) {
				// 간다
				parent[next] = cur;
				dfs(next, depth+1);
			}
		}
	}
}
