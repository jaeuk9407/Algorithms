package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6603_2 {
	static int[] arr;
	static int[] result;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			arr = new int[N];
			result = new int[N];
			
			if(N == 0) {
				break;
			}
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(str[i + 1]);
			}
			
			// 9 ~ i ~ 2^N -1  
			for(int i = (1<<N) - 1; i >= 9; i--) {
				Arrays.fill(result, 0);
				int count = 0;
				int bit = i;
				for(int j = 0; bit != 0; j++, bit>>=1) {
					if((1 & bit) == 0) {
						continue;
					}
					
					// 사전순 정렬을 위한 반대로 출력
					result[Math.abs((N-1)-j)] = 1;
					count++;
				}
				if(count == 6) {
					for(int k = 0; k < N; k++) {
						if(result[k]==1) {
							System.out.print(arr[k]+ " ");
							
						}
					}
					System.out.println();
				}
			}
			System.out.println();
		}// end of while
	}

}
