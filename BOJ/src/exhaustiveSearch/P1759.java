package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {
	static char[] arr;	// 암호로 사용했을 법한 C개의 문자 
	static int[] result;
	static int L;
	static int C;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		result = new int[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
//		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		dfs(0, 0, 0, 0);
		
	}
	
	// 시작점, 선택된 문자 개수, 자음 개수, 모음 개수
	private static void dfs(int start, int depth, int ja, int mo) {
//		System.out.println("dfs 시작! "+start+ ", "+depth+", "+ja+", "+mo);
		for(int i = start; i < C; i++) {
			result[i] = 1;
			
			// 자음과 모음 개수를 파악해서 다음으로 넘겨준다. 
//			System.out.println(start+ ", "+depth+", "+ja+", "+mo+" 가 dfs 호출! "+(i+1)+", "+(depth+1)+", "+(ja + (!check(arr[i]) ? 1 : 0)) +", "+ (mo + (!check(arr[i])? 0 : 1)));
			dfs(i + 1, depth + 1, ja + (!check(arr[i]) ? 1 : 0), mo + (!check(arr[i])? 0 : 1));
//			System.out.println("i: "+i);
			result[i] = 0;
		}
		// 문자 개수가 L개이고, 자음 2개, 모음 1개 이상 들어있는 경우 출력
		if(depth == L && ja >= 2 && mo >= 1) {
//			System.out.println("dfs 출력! "+start+ ", "+depth+", "+ja+", "+mo);
			print();
		}
//		System.out.println("dfs 소멸! "+start+ ", "+depth+", "+ja+", "+mo);
	}
	
	public static void print() {
		for(int i = 0; i < C; i++) {
			if(result[i] == 1) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}
	
	// 자음, 모음 검사
	private static boolean check(char a) {
		if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
			return true;
		}else {
			return false;
		}
	}

}
