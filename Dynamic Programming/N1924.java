package io;

import java.util.Scanner;

public class N1924 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int sum=0;
		
		for(int i=0; i<12; i++) {
			if(i+1 == x) break;
			sum += days[i];
		}
		sum += y;
		
		switch(sum%7) {
		case 0: System.out.println("SUN"); break;
		case 1: System.out.println("MON"); break;
		case 2: System.out.println("TUE"); break;
		case 3: System.out.println("WED"); break;
		case 4: System.out.println("THU"); break;
		case 5: System.out.println("FRI"); break;
		case 6: System.out.println("SAT"); break;
		
		
		}
		
	}
}
