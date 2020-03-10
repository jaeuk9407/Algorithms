package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1463_2 {// Top Down

	public static int d[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		d = new int[num+1];
		System.out.println(calculate(num));
	}

	
	public static int calculate(int num) {
		if(num == 1) {
			return 0;
		}
		if(d[num]>0) {
			return d[num];
		}
		d[num] = calculate(num-1)+1;
		if(num%3 ==0) {
			d[num] = Math.min(d[num], calculate(num/3)+1);
		}
		if(num%2 ==0) {
			d[num] = Math.min(d[num], calculate(num/2)+1);
		}
		
		
		return d[num];
	}
}
