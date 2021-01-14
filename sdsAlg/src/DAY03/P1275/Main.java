package DAY03.P1275;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, Q, S;
	static long[] tree;
	static long[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		// tree에서 leaf Node 시작할 index
		S = 1;
		while(S < N) {
			S *= 2;
		}
		nums = new long[N+1];
		tree = new long[2 * S];
				
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		makeTree(1, 1, S);
		
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());;
			
			if(y < x) {
				int temp = x;
				x = y;
				y = temp;
			}
			
			long result = query(1, 1, S, x, y);
			System.out.println(result);
			
			int a = Integer.parseInt(st.nextToken());;
			long b = Integer.parseInt(st.nextToken());;
			
			
			update(1, 1, S, a, b-nums[a]);
			nums[a] = b;
			
		}
		
	}
	
	static long makeTree(int node, int left, int right){
		if(left == right) {
			if(left <= N) { // 입력 값이 있는 부분 
				return tree[node] = nums[left];
			}else { // 입력 값이 없는 부분
				return 0;
			}
		}
		
		int mid = (left + right) / 2;
		tree[node] = makeTree(node * 2, left, mid);
		tree[node] += makeTree(node * 2 + 1, mid + 1, right);
		
		return tree[node];
	}
	
	static long query(int node, int left, int right, int qLeft, int qRight) {
		if(qRight < left || right < qLeft) { // 쿼리 범위 밖인 경우
			return 0;
		}else if(qLeft <= left && right <= qRight) { // 완전 포함의 경우
			return tree[node];
		}else { // 걸친 경우
			int mid = (left + right) / 2;
			return query(node * 2, left, mid, qLeft, qRight)
					+ query(node * 2 + 1, mid + 1, right, qLeft, qRight);
		}
	}
	
	static void update(int node, int left, int right, int index, long diff) {
		if(left <= index && index <= right) {
			tree[node] += diff;
			if(left != right) {
				int mid = (left + right) / 2;
				update(node * 2, left, mid, index, diff);
				update(node * 2 + 1, mid + 1, right, index, diff);
			}
		}
		
	}
}
