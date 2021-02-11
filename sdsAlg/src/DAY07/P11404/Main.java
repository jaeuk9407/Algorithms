package DAY07.P11404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// P11404
	static int n, m;
	static int INF = Integer.MAX_VALUE;
	static int graph[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n+1][n+1];
		
		// 초기화
		for(int i =1 ; i <=n; i++) {
			for(int j =1; j<=n; j++) {
				if(i!=j) {	//i == j일때는 0으로 사용하려고....
					graph[i][j] = INF;	
				}
			}
		}
		
		// 입력 
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 노선이 여러개 있더라도 최소값만 유지하기 위함
			if(c < graph[a][b]) {
				graph[a][b] = c; 
			}
		}
		
		floyd();
		
		// 출력
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++){
				if(graph[i][j] == INF) {
					System.out.print(0+" ");
				}
				else System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	
	static void floyd() {
		for(int k = 1; k<=n; k++) { 	// 중간점...
			for(int a = 1; a <=n; a++) {	// 시작점...
				for(int b =1; b <= n; b++) {	// 끝점...
					if(graph[a][k] == INF || graph[k][b] == INF) continue;
					
					// k를 경유해 가는 경로가 weight가 더 작다면 갱신
					if(graph[a][k]+graph[k][b] < graph[a][b]) {
						graph[a][b] = graph[a][k] + graph[k][b];
					}
				}
			}
		}
	}
}
