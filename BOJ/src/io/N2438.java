package io;

import java.util.Scanner;

public class N2438 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for(int i=1; i<n+1; i++) {
			for(int m=0; m<i;m++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
