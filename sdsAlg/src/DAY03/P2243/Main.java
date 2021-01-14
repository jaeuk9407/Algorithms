package DAY03.P2243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		S = 1;
		while(S < 1000000) {
			S *= 2;
		}
		
		tree = new int[2 * S];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // Type of Action
			int b = Integer.parseInt(st.nextToken()); // Rank to pop || flavor to pop & push
			
			if(a == 1) {
				// internal node에서 범위를 찾아들어간다. 1~S
				int index = query(1, 1, S, b);
				update(1, 1, S, index, -1);
				System.out.println(index);
				
			}else {
				// a == 2
				int c = Integer.parseInt(st.nextToken()); // 조정할 개수
				update(1, 1, S, b, c);
			}
		}
		br.close();
		
	}
	
	static int query(int node, int left, int right, int target) {
		if(left == right) { // leaf node
			return left;
		}else {
			int mid = (left + right) / 2;
			if(tree[node * 2] >= target) { //왼쪽의 값이 쿼리를 포함하는 경우
				return query(node * 2, left, mid, target);
			}else { // 오른쪽으로 가야하는 경우
				return query(node * 2 + 1, mid + 1, right, target - tree[node * 2]);
			}
		}
	}
	
	static void update(int node, int left, int right, int index, int diff) {
		if(left <= index && index <= right) {
			tree[node] += diff;
			if(left != right) { // internal node
				int mid = (left + right) / 2;
				update(node * 2, left, mid, index, diff);
				update(node * 2 + 1, mid+1, right, index, diff);
			}
		}
		
	}

}
