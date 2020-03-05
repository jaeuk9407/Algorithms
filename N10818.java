package io;

import java.util.Scanner;

public class N10818 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int temp = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			temp = arr[i];
			if(temp < min) {
				min = temp;
			}
			if(temp > max) {
				max = temp;
			}
		}
		System.out.println(min + " " + max);
	}

}
