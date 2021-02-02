package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1182 {
	
	static int arr[];
	static int N, S, cnt = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0,0);
		
		// S가 0인 경우 하나도 고르지 않은 경우가 카운팅되므로 빼준다.
		if(S == 0) {
			System.out.println(cnt-1);
		}else {
			System.out.println(cnt);
		}
	}
	
	private static void dfs(int v, int su) {
		if(v == N) {
			if(su == S) cnt++;
			return;
		}
		
		dfs(v+1, su + arr[v]);
		dfs(v+1, su);
	}

}
