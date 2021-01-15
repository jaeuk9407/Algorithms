package DAY04.P3955;

import java.util.Scanner;

public class Main {
	static int N, A, B;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		// X : 인당 나눠줄 사탕의 수
		// Y : 사탕 봉지의 수
		// A * x + 1 = B * y
		// Ax + By = C 형태로 변환
		// -Ax + By = 1
		// A(-x) + By = 1
		
		// A, B 입력
		for(int i = 0; i < N; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
		// 확장 유클리드 호제법을 이용하여 s, t, r 을 찾아냄
		// D = gcd(A,B)
		// D * K = C ==> C % D == 0 이어야만 해를 가질 수 있습니다 : 베주 항등식
			
			int[] result = eGcd(A, B);
			if(result[2] != 1) {
				System.out.println("IMPOSSIBLE");
			}else {
				int x0 = result[0]; // C = 1, D = 1
				int y0 = result[1];
		
				// x0 = s * C/D
				// y0 = t * C/D
				
				// 일반 해 공식 
				// x = x0 + B/D * k
				// y = y0 - A/D * k
				
				// 0 < x -> 문제 조건에 따라 부호 바뀜 -> x < 0
				// x0 + B/D * k < 0
				// k < -x0 / B * D
				
				// 0 < y <= 1e9
				// 0 < y0 - A/D * k <= 1e9
				// -y0 < - A/D * k <= 1e9 -y0
				// (y0-1e9) / A * D <= k < y0 / A * D
				
				// (y0-1e9) / A * D <= k < y0 / A * D
				//						< -x0 / B * D
		
				long kFromY = (long)Math.ceil((double)y0 / (double)A) - 1;
				long kFromX = (long)Math.ceil((double)-x0 /(double)B) -1;
				// k의 max를 구한 후 그 k를 이용해서 y값을 구해냅니다. => k가 커지면 y가 작아지므로
				long k = Math.min(kFromX,  kFromY);
				// 그렇게 구한 y는 가장 작은 y값 입니다.
				long y = y0 - A * k;
				
				// 그 구한 y 값이 1e9보다 작거나 같으면 가능한 답.
				if(y <= 1e9) {
					System.out.println(y);
				}else {
					// 아니면 불가능한 답.
					System.out.println("IMPOSSIBLE");
				}
			}
		}
		sc.close();
	}
	
	//ax + by = c => as + bt = r 을 만족하는 s,t,r 조합을 찾기(r이 gcd(a,b)일 때)
		static int[] eGcd(int a, int b) {
			int s0 = 1, t0 = 0, r0 = a;
			int s1 = 0, t1 = 1, r1 = b;
			
			int temp;
			while(r1 != 0) {
				int q = r0 / r1;
				
				temp = r0 - q * r1; // 새로운 r값
				r0 = r1;
				r1 = temp;
				
				temp = s0 -q * s1;
				s0 = s1;
				s1= temp;
				
				temp = t0 - q * t1;
				t0 = t1;
				t1 = temp;
			}
			return new int[] {s0, t0, r0};
		}
}
