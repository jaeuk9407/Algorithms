package io;

import java.util.Scanner;

public class N10991 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int p=0; p<n;p++) {
			for(int q=0; q<n-p-1; q++) {
				System.out.print(" ");
			}
			for(int q=0; q<p+1; q++) {
				System.out.print("*");
				if(q<p+1) {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		
	}

}
