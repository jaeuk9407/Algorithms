package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2251 {
	
	private static int MAX = 201;
	private static int[] W = new int[3];
	private static boolean[][] check = new boolean[MAX][MAX];
	private static boolean[] ans = new boolean[MAX];
	private static Queue<Info2251> q = new LinkedList<>();
	private static int[] from = {0, 0, 1, 1, 2, 2};
	private static int[] to = {1, 2, 0, 2, 0, 1};
	
	private static void bfs() {
		q.add(new Info2251(0, 0));
		check[0][0] = true;
		ans[W[2]] = true;
		
		while(!q.isEmpty()) {
			Info2251 now = q.poll();
			int x = now.x;
			int y = now.y;
			int z = W[2] - x - y;
			
			for(int k = 0; k < 6; k++) {
				int[] next = {x, y, z};
				next[to[k]] += next[from[k]];
				next[from[k]] = 0;
				
				// 받는 물통의 용량보다 많이 받은 경우 처리
				if(next[to[k]] > W[to[k]]) {
					// 용량을 초과한 만큼 비우는 물통에 다시 넣어준다
					next[from[k]] = next[to[k]] - W[to[k]];
					// 받는 물통은 용량 최대치로 설정 
					next[to[k]] = W[to[k]]; 
				}
				
				if(!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					q.add(new Info2251(next[0], next[1]));
					if(next[0] == 0) {
						ans[next[2]] = true;
					}
				}
			}
		}
	} // end bfs()
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 3; i++) {
			W[i] = Integer.parseInt(st.nextToken()); 
		}
		
		bfs();
		
		for(int i = 0; i <= W[2]; i++) {
			if(ans[i]) {
				System.out.print(i+" ");
			}
		}
	}
}
class Info2251{
	int x,y;

	public Info2251(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

