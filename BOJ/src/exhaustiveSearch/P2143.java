package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2143 {
	static int A[];
	static int B[];
	static int N, M, T;
	static long subA[][];
	static long subB[][];
	static ArrayList<Long> listA = new ArrayList<>();
	static ArrayList<Long> listB = new ArrayList<>();
	static int pA, pB;
	static long ans;
	
	public static void main(String[] args) throws Exception{
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		subA = new long[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			subA[i][i] = A[i];
			listA.add((long) A[i]);
		}
		M = Integer.parseInt(br.readLine());
		B = new int[M];
		subB = new long[M][M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			subB[i][i] = B[i];
			listB.add((long) B[i]);
		}
		br.close();
		
		// 부배열의 합을 담는 2차원배열, list에 값을 넣어줌
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				subA[i][j] = subA[i][j-1] + A[j];
				listA.add(subA[i][j]);
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = i+1; j < M; j++) {
				subB[i][j] = subB[i][j-1] + B[j];
				listB.add(subB[i][j]);
			}
		}
		
		// list를 오름차순으로 정렬
		Collections.sort(listA);
		Collections.sort(listB);
		
//		System.out.println(listA.toString());
//		System.out.println(listB.toString());
		
		ans = 0;
		
		// list 2개를 투포인터로 탐색하며 합을 T와 비교해 cnt 계산
		compareT();
		System.out.println(ans);
	}

	private static void compareT() {
		pA = 0;
		pB = listB.size() - 1;
		
		while(0 <= pB && pA < listA.size()) {
			long vA = listA.get(pA);
			long vB = listB.get(pB);
			long sum = vA + vB;
			
			if(sum == T) {
				int cA = 0;
				while(pA < listA.size() && listA.get(pA) == vA) {
					cA++;
					pA++;
				}
				int cB = 0;
				while(0 <= pB && listB.get(pB) == vB) {
					cB++;
					pB--;
				}
				
				ans += (long)cA * (long)cB;
			}else if(sum < T) {
				pA++;
			}else {
				// sum > T
				pB--;
			}
		}
	}
}
