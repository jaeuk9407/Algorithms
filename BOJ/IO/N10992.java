package io;

import java.util.Scanner;

public class N10992 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int p=0; p<n-1; p++) {
			System.out.print(" ");
		}
		System.out.print("*");
		System.out.println("");
		
		for(int p=0; p<n-2; p++) {
			for(int q=0; q<n-p-2; q++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for(int q=0; q<2*p+1; q++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println("");
		}
		
		if(n!=1) {
			for(int p=0; p<2*n-1;p++) {
				System.out.print("*");
			}	
		}
		
	}

}
