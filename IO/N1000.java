package io;

//change Nxxxx -> Main && remove package lines.
import java.util.Scanner;

public class N1000 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close(); //closing helps prevent waste of resources.
		
		System.out.println(a+b);
	}

}
