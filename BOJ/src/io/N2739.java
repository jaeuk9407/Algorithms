package io;

import java.util.Scanner;

public class N2739 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<10; i++) {
			int multiple = n*i;
			System.out.println(n +" * " +i +" = " +multiple);
		}
	}

}
