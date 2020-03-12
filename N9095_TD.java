package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9095_TD {

	static int[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testn = Integer.parseInt(br.readLine());
		d = new int[11];
		for(int i=0; i<testn;i++) {
			int n = Integer.parseInt(br.readLine());
			d[i] = calculate(n);
			System.out.println(d[i]);
		}
		
		
		
	}
	public static int calculate(int n) {
		if(n==1) return 1;
		else if(n==2) return 2;
		else if(n==3) return 4;
		else {
			d[n] = calculate(n-1) +calculate(n-2)+ calculate(n-3);
			
			return d[n];
		}
	}

}
