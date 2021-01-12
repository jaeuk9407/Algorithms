package DAY02.P1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = 1000000000;
	public static void main(String[] args) throws Exception {
		
		long x, y, z;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());
		z = 100 * y / x;
		
		int low = 0, high = max+1, mid = 0;
		
		// 99, 100%는 더이상 확률이 증가할 수 없음
		if(z >= 99) {
			System.out.println(-1);
		}else {
			while(low < high) {
				mid = (low + high) / 2;
				long temp = (100 * (y + mid) / (x + mid));
				
				if(temp <= z) {
					low = mid + 1;
				} else {
					// mid를 포함해야 함(중요)
					high = mid;
				}
			}
			// 승률이 올라가는 구간이 없는 경우 
			if(high > max) {
				System.out.println(-1);
			}else {
				System.out.println(high);
			}
		}
	}
}
