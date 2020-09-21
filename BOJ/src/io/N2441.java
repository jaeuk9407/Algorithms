package io;

import java.util.Scanner;

public class N2441 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		for(int p =n; p>0; p--) {
			for(int q=0; q<n-p; q++) {
				System.out.print(" ");
			}
			for(int q=p; q>0; q--) {
				System.out.print("*");
			}
			
			System.out.println("");
		}
	}

}
