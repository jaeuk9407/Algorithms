package io;

import java.util.Scanner;

public class N2442 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int p=0; p<n; p++) {
			for(int q=0; q<n-p-1; q++){
				System.out.print(" ");
			}
			for(int q=0; q<2*p+1; q++){
				System.out.print("*");
			}
			System.out.println("");
			
		}
	}

}
