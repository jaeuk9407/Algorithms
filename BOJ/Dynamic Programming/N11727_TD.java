package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class N11727_TD {
	public static int d[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int n = Integer.parseInt(br.readLine());
		d = new int[n+1];
		System.out.println(calc(n));
		
		
	}
	
	public static int calc(int n) {
		if(n ==0 || n ==1) return 1;
		if(d[n]>0) return d[n];
		
		d[n] = 2 *calc(n-2) + calc(n-1);
		d[n] %= 10007;
		
		return d[n];
	}

}
