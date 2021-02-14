package sds.graph1.P11438;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer> edges[];
	static int LOG = 17; // 2^17 == 131072 > 100000
	static int parents[][], depths[];
	static int root;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		edges = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			edges[i] = new ArrayList<>();
		}
		parents = new int[N+1][LOG+1];
		depths = new int[N+1];
		for(int i = 1; i <= N; i++) {
			depths[i] = 100001;
		}
		
		StringTokenizer st;
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			edges[a].add(b);
			edges[b].add(a);
		}
		root = 1;
		setParents();
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(lca(a, b));
		}
		
	}
	
	private static void findDepth(int index, int depth) {
		depths[index] = depth;
		
		// index가 leaf node이면 종료 
		if(edges[index].size() == 1 && index != root) {
			return;
		}
		
		for(int i = 0; i < edges[index].size(); i++) {
			int next = edges[index].get(i);
			// 부모에서 내려온 edge는 처리하지 않는다.
			if(depths[index] < depths[next]) {
				parents[next][0] = index;
				findDepth(next, depth+1);
			}
		}
	}
	
	// 2^i번째 부모들을 탐색하고 저장 
	private static void setParents() {
		findDepth(root,0);
		
		for(int i = 1; i <= LOG; i++) {
			for(int j = 1; j <= N; j++) {
				parents[j][i] = parents[parents[j][i-1]][i-1];
			}
		}
	}
	
	private static int lca(int a, int b) {
		// depth가 다르면 반드시 b가 높도록 설정하기 위해 swap
		
		
		if(depths[a] > depths[b]) {
			int c = a;
			a = b;
			b = c;
			
		}
		// 깊이가 같아질 때까지 올라감
		if(depths[a] != depths[b]) {
			for(int i = LOG; 0 <= i; i--) {
				// 위에서부터 내려오는데 깊이차 큰순서부터 작은 수까지
				if(depths[b] - depths[a] >= (1 << i)) {
					b = parents[b][i];
				}
			}
		}
		// 한 쪽이 나머지 한 쪽의 최소공통조상이었거나, 두 수가 같은 수라면 return 
		if(a == b) {
			return a;
		}
		
		// 조상을 향해 거슬러 올라가기
		for(int i = LOG; 0 <= i; i--) {
			if(parents[a][i] != parents[b][i]) {
				a = parents[a][i];
				b = parents[b][i];
			}
		}
		
		return parents[a][0];
	}

}
