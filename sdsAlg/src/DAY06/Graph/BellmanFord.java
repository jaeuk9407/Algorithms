package DAY06.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BellmanFord {
	// P11657
	static ArrayList<InfoB> adj[];
	static int n, m;
	static int INF = 100000000;
	static long dist[];
	static boolean has_minus_cycle;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 입력을 받기 위한 초기화
		adj = new ArrayList[n+1];
		dist = new long[n+1];
		for(int i = 0; i<=n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 입력 저장
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			
			adj[a].add(new InfoB(b, c));
		}
		
		// 초기 세팅
		for(int i = 1; i<= n; i++) {
			dist[i] = INF;
		}
		
		
		bell();
		// 예외를 먼저 처리함
		// 시간이 무한히 되돌아가면 -1
		// 어떤 도시까지 가는 경로가 없으면 -1 
		// 각 지점까지 경로 출력
		if(has_minus_cycle) {
			System.out.println(-1);
		}else {
			for(int i =2; i<=n; i++) {
				if(dist[i]==INF)  System.out.println(-1);
				else System.out.println(dist[i]);
			}
		}
	}
	
	static void bell() {
		// 시작점을 초기화 
		dist[1] = 0;
		for(int i = 0; i < n-1; i++) {	// 최대 방문할 수 있는 간선의 개수만큼 돌림
			for(int j =1; j <= n; j++) {	// j점 주변에 있는 점들을 업데이트 할 수 있는지 확인함 
				for(int k =0; k < adj[j].size(); k++) {	
					InfoB nxt = adj[j].get(k);	//nxt.b: j점 주변의 점, nxt.c: 그 점까지 이동하는데 걸리는 비용
					if(dist[j] + nxt.c < dist[nxt.b] && dist[j] != INF) {	// dist[j] == INF, nxt.c ==음수 경우 처리 필수!
						dist[nxt.b] = dist[j] + nxt.c;	// j----->nxt 이동하는데 더 적은 비용으로 이동가능하면 업데이트 
					}
				}
			}
		}
		
		/*
		 * 전제: n - 1번 수행했기 때문에, 가장 먼 경로더라도 충분히 도달했을 것임 
		 * 그리고 그 경로가 최단경로였을 것이다.
		 * 왜냐면 더 추가해서 방문을 했으면 경로의 값이 커질테니까....
		 * 하지만! 중간에 감소하는 구간이 있었다면????
		 * 뭔가 해야 함.
		 * 한번 더 해봄.
		 */
		
		for(int j =1; j <= n; j++) {	// j점 주변에 있는 점들을 업데이트 할 수 있는지 확인함 
			for(int k =0; k < adj[j].size(); k++) {	//
				InfoB nxt = adj[j].get(k);	//nxt.b: j점 주변의 점, nxt.c: 그 점까지 이동하는데 걸리는 비용
				if(dist[j] + nxt.c < dist[nxt.b] && dist[j] != INF) {
					// 이런 일이 일어날 수 있을까??
					has_minus_cycle = true;
					return;
				}
			}
		}
	}
}



class InfoB{
	int b, c;

	public InfoB(int b, int c) {
		this.b = b;
		this.c = c;
	}
	
}