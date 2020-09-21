package io;

import java.util.Scanner;

public class N11721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int len = str.length();
		
		for(int i =0; i<len; i++) {
			System.out.print(str.charAt(i));
			
			if(i % 10 ==9) {
				System.out.println("");
			}
			
		}
	}
}
