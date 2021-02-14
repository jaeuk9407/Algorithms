package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11437 {
	
	static ArrayList<Integer> edges[];
	static int N, M;
	static int depths[], parents[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		edges = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		depths = new int[N+1];
		for(int i = 0 ; i <= N; i++) {
			depths[i] = 50001;
		}
		parents = new int[N+1];
		
		
		StringTokenizer st;
		// 입력받은 연결 정보 저장 
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			edges[a].add(b);
			edges[b].add(a);
		}
		
		findDepth(1, 0);
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(lca(a, b));
		}
		

	}
	
	// DFS로 모든 노드의 depth 탐색 및 저장  
	private static void findDepth(int index, int depth) {
		depths[index] = depth;
		
		// leaf Node이면 탐색 종료
		if(edges[index].size() == 0) {
			return;
		}
		
		for(int i = 0; i < edges[index].size(); i++) {
			int next = edges[index].get(i);
			// 부모노드와 연결된 edge는 다시 처리하지 않음
			if(depths[index] < depths[next]) {
				parents[next] = index;
				findDepth(next, depth+1);
			}
		}
	}
	
	
	
	private static int lca(int a, int b) {
		
		// 위 코드 2616ms -> 아래 코드 1664ms
		
//		// 공통조상이면 return한다.
//		if(a == b) {
//			return a;
//		}
//		
//		// 두 노드의 depth가 다르면 맞춰준다
//		if(depths[a] < depths[b]) {
//			return lca(a, parents[b]);
//		}else if(depths[b] < depths[a]){
//			return lca(parents[a], b);
//		}else {
//			// 두 노드의 depth가 같으면 공통 조상을 찾아 거슬러 올라간다.
//			return lca(parents[a], parents[b]);
//		}
		
		
		// 두 노드의 depth가 다르면 맞춰준다 
		while(depths[a] != depths[b]) {
			if(depths[a] > depths[b]) a = parents[a];
			else b = parents[b];
		}
		
		// 두 노드의 depth가 같으면 공통 조상을 찾아 거슬러 올라간다
		while(a != b) {
			a = parents[a];
			b = parents[b];
		}
		return a;
	}
}
