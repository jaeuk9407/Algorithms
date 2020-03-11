package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11727 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int d[] = new int[n+1];
		
		for(int i=0; i<n+1; i++) {
			if(i ==1) {
				d[i] = 1;
			}else if(i ==2){
				d[i] = 3;
			}else if(i>=3){
				d[i] = d[i-1] + 2*(d[i-2]);
				d[i] %=10007;
			}
		}
		
		System.out.println(d[n]);
	}

}
