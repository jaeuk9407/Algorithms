package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9095 { //Bottom up

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testn = Integer.parseInt(br.readLine());
		int d[] = new int[11];
		
		d[0] = 0;
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		

		for(int i=0; i<testn; i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j=4; j<n+1; j++) {
				d[j] = d[j-1] +d[j-2] +d[j-3];
			}
			System.out.println(d[n]);
		}
	}

}
