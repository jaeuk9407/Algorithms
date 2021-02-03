package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {
	static int N, M;
	static int arr[];
	static int start, end, sum, cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		start = 0; end = 0; sum = arr[0]; cnt = 0;
		
		while(true) {
			if(sum == M) {
				sum -= arr[start++];
				sum += arr[++end];
				cnt++;
			}else if(sum < M) {
				sum += arr[++end];
			}else {
				sum -= arr[start++];
			}
			
			if(end == N) {
				break;
			}
		}
		
		System.out.println(cnt);
	}

}
