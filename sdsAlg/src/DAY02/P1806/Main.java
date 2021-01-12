package DAY02.P1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] A;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, lenCount = 100001, sum = 0;
		sum = A[0];
		
		while(true) {
			if(sum >= S) {
				if((end-start+1) < lenCount) {
					lenCount = end - start + 1;
				}
				sum -= A[start++];
			}else {
				sum += A[++end];
			}
			if(end == N) {
				break;
			}
		}
		if(lenCount == 100001) {
			System.out.println(0);
			return;
		}
		
		br.close();
		System.out.println(lenCount);

	}

}
