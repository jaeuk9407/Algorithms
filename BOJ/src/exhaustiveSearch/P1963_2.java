package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1963_2 {

	static int MAX = 10001;
	static int N, Start, End;
	static boolean prime[];
	static int check[];
	
	static void eratos() {
		for(int i = 2; i*i<MAX; i++) {
			for(int j = i*i; j<MAX; j+=i) {
				prime[j] = false;
			}
		}
	}
	
	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		check[s] = 0;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i =0; i<4; i++) {
				char[] node_char = String.valueOf(node).toCharArray();
				for(int j = 0; j<10; j++) {
					node_char[i] = (char) (j+ '0');
					StringBuilder sb = new StringBuilder();
					for(char c:node_char) {
						sb.append(c);
					}
					int next = Integer.parseInt(sb.toString());
					if(next >= 1000 && prime[next] == true && check[next] == -1) {
						check[next] = check[node] + 1;
						q.add(next);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		prime = new boolean[MAX];
		
		for(int i = 1000; i<10001; i++) {
			prime[i] = true;
		}
		
		eratos();
		
		for(int i = 0; i< N; i++) {
			check = new int[MAX];
			for(int j = 1000; j<10001; j++) {
				check[j] = -1;
			}
			st = new StringTokenizer(br.readLine());
			Start = Integer.parseInt(st.nextToken());
			End = Integer.parseInt(st.nextToken());
			
			bfs(Start);
			
			if(check[End] != -1) {
				System.out.println(check[End]);
			}else {
				System.out.println("Impossible");
			}
		}
	}

}
