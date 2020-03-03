package io;

import java.util.Scanner;

public class N10953 {

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int limit = sc.nextInt();
	
		while(limit-- >0) {
			String[] str = sc.next().split(",");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			System.out.println(a+b);
		}
		
	}

}
