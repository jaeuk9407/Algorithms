package DAY06.P2458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ANS, visited_cnt, visited_rev_cnt;
	static ArrayList<Integer>[] adj, rev;
	static boolean[] visited, visited_rev;
	
	public static void main(String[] args) throws Exception{
		// 입력으로 그래프를 구성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		rev = new ArrayList[N+1];
		visited = new boolean[N+1];
		visited_rev = new boolean[N+1];
		
		
		for(int i=0; i <= N; i++) {
			adj[i] = new ArrayList<>();
			rev[i] = new ArrayList<>();
		}
		
		// for int i=0 i<m i++
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//a가 b보다 작음
			adj[a].add(b); // ------- a ----> b
			rev[b].add(a); // ------- b ----> a
		}
		
//		System.out.println("adj: "+Arrays.toString(adj));
//		System.out.println("rev: "+Arrays.toString(rev));
		
		// 나보다 큰 학생수를 셈
		for(int i = 1; i<=N ; i++) {
			visited_cnt =0; // 나 + 나보다 큰 학생
			dfs(i);
			
			
			// 나보다 작은 수를 셈
			visited_rev_cnt = 0; // 나 + 나보다 작은 학생
			dfs_rev(i);
			
//			System.out.println(i+"번 학생보다 큰 학생 수: "+visited_cnt+", 작은 학생 수: "+visited_rev_cnt+" 합: "+(visited_cnt+visited_rev_cnt)+" (본인을 2번 포함)");
			
			// i번째 학생의 순서를 알 수 있는지 없는지 판단
			// 나보다 큰 학생수 + 나보다 작은 학생수랑 + 1 == N
			// 모두다 포함이 되었는지 확인해봄
			if(visited_cnt + visited_rev_cnt == N + 1) {
				ANS++;
			}
			
			// 새로운 학생의 DFS를 위해 초기화 
			for(int j = 1; j <= N; j++) {
				visited[j] = false;
				visited_rev[j] = false;
			}
			
		}
		
		System.out.println(ANS);
		
	}
	static void dfs(int cur) {
		// 1. 체크인
//		System.out.println("dfs cur: "+cur);
		visited[cur] = true;
		visited_cnt++;
		// (2. 목적지에 도착했는가?)
		// 3. 연결된 곳을 순회
		if(!adj[cur].isEmpty()) {
			// 4. 갈 수 있는가?
			for(int i = 0; i<adj[cur].size(); i++) {
				int next = adj[cur].get(i);
				if(!visited[next]) {
					// 5. 간다.
					dfs(next);
				}
			}
		}
		// (6. 체크아웃)
	}
	
	static void dfs_rev(int cur) {
		// 1. 체크인
//		System.out.println("dfs_rev cur: "+cur);
		visited_rev[cur] = true;
		visited_rev_cnt++;
		// (2. 목적지에 도착했는가?)
		// 3. 연결된 곳을 순회
		if(!rev[cur].isEmpty()) {
			// 4. 갈 수 있는가?
			for(int i = 0; i<rev[cur].size(); i++) {
				int next = rev[cur].get(i);
				if(!visited_rev[next]) {
					// 5. 간다.
					dfs_rev(next);
				}
			}
		}
		// (6. 체크아웃)
	}

}
