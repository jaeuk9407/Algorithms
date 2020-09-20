package io;

import java.util.Scanner;

public class N2439 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		for(int p=0; p<n; p++) {
			for(int q=n-1; q>p; q--) {
				System.out.print(" ");
			}
			for(int q=0; q<=p; q++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}

}
