package DAY06.P1717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m; 
	static int[] pr = new int[1000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i =0; i <= n; i++) {
			pr[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(cmd == 0) {
				// to do union
				unionF(a, b);
				
			}else {
				// to do find, print yes or no
				int resultA = findF(a);
				int resultB = findF(b);
				
				if(resultA == resultB) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
				
			}
		}

		
	}
	static int findF(int a) {
		if(a == pr[a]) {
			return a;
		}
		//return findF(pr[a]); // 재귀적 .... 시간초과 
		pr[a] = findF(pr[a]); // 시간초과를 해결하기 위한 방법
		return pr[a];
	}
	static void unionF(int a, int b){
		a = findF(a);
		b = findF(b);
		// a의 부모를 b로 setting
		pr[a] = b;
	}

}
