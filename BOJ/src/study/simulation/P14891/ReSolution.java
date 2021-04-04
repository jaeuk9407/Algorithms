package study.simulation.P14891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReSolution {
	static int[][] circles = new int[4][8];
	static int K, result;
	static int[] isRotate;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 4; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0; j < 8; j++) {
				circles[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int circleIndex = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			isRotate = new int[4];
			
			check(circleIndex - 1, direction);
			rotate();
		}
		System.out.println(countScore());
	}
	
	static int countScore() {
		int result = 0;
		for(int i = 0; i < 4; i++) {
			if(circles[i][0] == 1) {
				result += Math.pow(2, i);
			}
		}
		return result;
	}
	
	static void check(int circleNum, int dir) {
		isRotate[circleNum] = dir;
		
		int prev = circleNum - 1;
		int next = circleNum + 1;
		
		if(prev >= 0 && isRotate[prev] == 0) {
			// ¿ÞÂÊ ¹ÙÄû °Ë»ç
			if(circles[prev][2] != circles[circleNum][6]) {
				check(prev, dir * -1);
			}
		}
		
		if(next <= 3 && isRotate[next] == 0) {
			// ¿À¸¥ÂÊ ¹ÙÄû °Ë»ç 
			if(circles[circleNum][2] != circles[next][6]) {
				check(next, dir * -1);
			}
		}
	}
	
	static void rotate() {
		for(int i = 0; i < 4; i++) {
			if(isRotate[i] != 0) {
				int[] result = new int[8];
				
				for(int j = 0; j < 8; j++) {
					int resultIndex = j + isRotate[i];
					
					if(resultIndex == -1) {
						resultIndex = 7;
					}else if(resultIndex == 8) {
						resultIndex = 0;
					}
					
					result[resultIndex] = circles[i][j];
				}
				circles[i] = result;
			}
		}
	}
}
