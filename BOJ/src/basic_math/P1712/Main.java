package basic_math.P1712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static Long A, B, C;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.valueOf(st.nextToken());
		B = Long.valueOf(st.nextToken());
		C = Long.valueOf(st.nextToken());
		
		if(B >= C) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(A/(C-B)+1);
		br.close();
	}
}
