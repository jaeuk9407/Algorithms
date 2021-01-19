package DAY07.P11266;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// 단절점 찾기
	static int v, e, count, num;
	static ArrayList<Integer> adj[];
	static boolean ans[];	// 단절점이면 true로 체크
	static int visit_order[];
	
	static int getmin(int x, int y) {
		if(x < y) return x; 
		else return y;
	}
	
	// 예외 : 루트일 경우
	// 나의 방문순서와 자식들이 만나는 방문순서 중가장 작은 값을 비교
	static int dfs(int parent, int cur, boolean isRoot) {
		int min_visit_order = 20000;	// 내 자식들이 만날 수 있는 점중에서 가장 작은 점
		int chlcnt = 0;	// 자식들의 수
		
		// 현재 노드가 방문순서가 입력되어 있지 않은 경우(방문하지 않은 경우)에만 함수 진행
		if(visit_order[cur] != 0) {	 
			return 0;
		}
		
		// 방문 순서 입력
		num++;
		visit_order[cur] = num;
		
		// 연결된 노드 순회 
		for(int i = 0; i < adj[cur].size(); i++) {
			int nxt = adj[cur].get(i);
			if(nxt == parent) continue;	// 연결된 간선이 부모노드면 건너 뛴다.
			
			if(visit_order[nxt] != 0) { //	다음 노드의 방문순서가 기록되어 있는 경우 
				if(visit_order[nxt] < min_visit_order) {
					min_visit_order = visit_order[nxt];
				}
			}else {	//새롭게 방문하는 경우
				int tmp;
				tmp = dfs(cur, nxt, false);		// 연결된 최소 방문 순서
				min_visit_order = getmin(tmp, min_visit_order);
				if(isRoot != true && tmp >= visit_order[cur]) {
					// 루트노드가 아니고, (루트노드는 따로 예외 처리)
					// 연결된 점의 주변 최소 방문 순서가 현재 점보다 같거나 크면 현재 점은 단절점! 
					ans[cur] = true;
				}
				chlcnt ++;
			}
		}
		
		// 리프노드면 단절점 처리를 해주지 않음.
		if(adj[cur].size() == 1) {
			return visit_order[cur];
		}
		
		// 루트노드 예외 처리 
		if(isRoot) {
			// 자식이 두개 이상이면 단절점
			if(chlcnt >= 2) {
				ans[cur] = true;
			}
		}
		
		return getmin(min_visit_order, visit_order[cur]);	// 내가 만난 점중에서 방문 순서가 가장 낮은 점을 반환...
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[v+1];
		ans = new boolean[v+1];
		visit_order = new int[v+1];
		
		// 초기화 
		for(int i = 1; i <= v; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 입력
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		
		// 단절점을 찾고
		for(int i = 1; i <= v; i++) {
			if(visit_order[i] == 0) { // 그래프가 모두 연결되어 있는 상태가 아니기 때문에...
				dfs(0, i, true);	// 시작하는 점을 root
			}
		}
		
		// 출력 
		// 개수
		for(int i = 1; i <= v; i++) {
			if(ans[i]) count++;
		}
		System.out.println(count);
		for(int i = 1; i <= v; i++) {
			if(ans[i]) {
				System.out.print(i+" ");
			}
		}
	}
}
