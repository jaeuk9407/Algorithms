package sds.graph1.P2252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static ArrayList<Integer> ans = new ArrayList<>();	// 줄을 세울 순서
	private static int indegree[];
	private static ArrayList<Integer> outEdges[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N+1];
		outEdges = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			outEdges[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			indegree[b] += 1;
			outEdges[a].add(b);
		}
		
		// 위상정렬 시행
		topologicalSort();
		
		
		// 출력처리
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i));
			sb.append(" ");
		}
		System.out.println(sb.toString());
		
	}
	
	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 순서대로 답을 출력할 list에 저장 
			ans.add(now);
			
			for(int i = 0; i < outEdges[now].size(); i++) {
				int next = outEdges[now].get(i);
				indegree[next] -= 1;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
	}
}
