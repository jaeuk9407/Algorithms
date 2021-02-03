package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
	static int N, S;
	static int arr[];
	static int ans;
	static int start, end, sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		start = 0; end = 0; sum = arr[0]; ans = 100001;
		while(true) {
			if(sum >= S) {
//				System.out.println("ans update");
//				System.out.println(end+"-"+start+"+"+1+"="+(end-start+1));
				ans = Math.min(ans, end-start+1);
				sum -= arr[start++];
			}else {
				sum += arr[++end];
			}
			if(end == N) {
				break;
			}
		}
		if(ans == 100001) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
	}
}
