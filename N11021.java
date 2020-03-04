package io;

import java.util.Scanner;

public class N11021 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1; i<n+1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==0 && b==0) break;
			
			int sum=a+b;
			System.out.println("Case #" +i +": " +sum);
		}
	}

}
