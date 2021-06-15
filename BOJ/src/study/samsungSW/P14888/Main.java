package study.samsungSW.P14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, MAX_VALUE, MIN_VALUE;
	static int[] arr;
	static int[] operations = new int[4];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 정보 저장
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) operations[i] = Integer.parseInt(st.nextToken());
		
		// 최솟값은 Int범위 최댓값부터, 최댓값은 Int 범위 최솟값으로 설정(음수 존재 가능)
		MAX_VALUE = Integer.MIN_VALUE;
		MIN_VALUE = Integer.MAX_VALUE;
		
		// 탐색
		dfs(1, arr[0]);
		
		System.out.println(MAX_VALUE);
		System.out.println(MIN_VALUE);
	}
	
	// 백트래킹으로 최대, 최소값 탐색
	public static void dfs(int cnt, int num) {
		// 배열 끝까지 연산이 적용 끝났다면 반환할 최대, 최소값을 가능하면 갱신하고 함수 종료 
		if(cnt == N) {
			MAX_VALUE = Math.max(num, MAX_VALUE);
			MIN_VALUE = Math.min(num, MIN_VALUE);
			return;
		}
		
		// +, -, *, / 순으로 연산자가 남아있으면 적용해서 dfs 호출
		for(int i = 0; i < 4; i++) {
			if(operations[i] > 0) {
				operations[i] -= 1;
				if(i == 0) dfs(cnt+1, num + arr[cnt]);
				else if(i == 1) dfs(cnt+1, num - arr[cnt]);
				else if(i == 2) dfs(cnt+1, num * arr[cnt]);
				else if(i == 3) dfs(cnt+1, num / arr[cnt]);
				
				// 호출이 끝났으면 다시 다른 위치에서 쓰일 수 있도록 원상복구
				operations[i] += 1;
			}
		}
	}
}
