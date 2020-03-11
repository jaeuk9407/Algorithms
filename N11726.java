package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11726 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int d[]= new int[num+1];
		
		for(int i=0; i<num+1; i++) {
			if(i<=2) {
				d[i] = i;
			}
			else {
				d[i] = (d[i-1] + d[i-2])%10007;
			}
		}
		System.out.println(d[num]);
		
	}

}
