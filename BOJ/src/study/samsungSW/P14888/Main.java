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
		
		// �Է� ���� ����
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) operations[i] = Integer.parseInt(st.nextToken());
		
		// �ּڰ��� Int���� �ִ񰪺���, �ִ��� Int ���� �ּڰ����� ����(���� ���� ����)
		MAX_VALUE = Integer.MIN_VALUE;
		MIN_VALUE = Integer.MAX_VALUE;
		
		// Ž��
		dfs(1, arr[0]);
		
		System.out.println(MAX_VALUE);
		System.out.println(MIN_VALUE);
	}
	
	// ��Ʈ��ŷ���� �ִ�, �ּҰ� Ž��
	public static void dfs(int cnt, int num) {
		// �迭 ������ ������ ���� �����ٸ� ��ȯ�� �ִ�, �ּҰ��� �����ϸ� �����ϰ� �Լ� ���� 
		if(cnt == N) {
			MAX_VALUE = Math.max(num, MAX_VALUE);
			MIN_VALUE = Math.min(num, MIN_VALUE);
			return;
		}
		
		// +, -, *, / ������ �����ڰ� ���������� �����ؼ� dfs ȣ��
		for(int i = 0; i < 4; i++) {
			if(operations[i] > 0) {
				operations[i] -= 1;
				if(i == 0) dfs(cnt+1, num + arr[cnt]);
				else if(i == 1) dfs(cnt+1, num - arr[cnt]);
				else if(i == 2) dfs(cnt+1, num * arr[cnt]);
				else if(i == 3) dfs(cnt+1, num / arr[cnt]);
				
				// ȣ���� �������� �ٽ� �ٸ� ��ġ���� ���� �� �ֵ��� ���󺹱�
				operations[i] += 1;
			}
		}
	}
}
