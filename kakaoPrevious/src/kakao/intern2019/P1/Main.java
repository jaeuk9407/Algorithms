package kakao.intern2019.P1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int [][] board;
	static int[] moves;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/kakao/intern2019/p1/input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		M = Integer.parseInt(br.readLine());
		moves = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = new Solution().solution(board, moves); 
		System.out.println(result);
	}

}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        
        Stack<Integer> st[] = new Stack[n + 1];
        for(int i = 0; i < n + 1; i++) {
        	st[i] = new Stack<>();
        }
        
        Stack<Integer> pocket = new Stack<>();
        
        // ���� �迭�� board ���� �Է�
        for(int col = 0; col < n; col++) {
        	for(int row = n - 1; row >= 0; row--) {
        		if(board[row][col] != 0) {
        			st[col + 1].push(board[row][col]);
        		}
        	}
        }
        
        
        // ��� �ϳ��� ����
        for(int move = 0; move < moves.length; move++) {
        	if(!st[moves[move]].isEmpty()) {
        		int doll = st[moves[move]].pop();
        		
        		// pocket�� �� �� ���� �������� ������ �ٸ��� ���� ������ �ְ�,
        		// ������ �� �� �����ְ� count.
        		if(!pocket.isEmpty()) {
	        		int pocketTop = pocket.pop();
	        		if(pocketTop != doll) {
	        			pocket.add(pocketTop);
	        			pocket.add(doll);
	        		}else {
	        			answer += 2;
	        		}
        		}else {
        			// ������ ����ִ� ��� �׳� �־��ش�. 
        			pocket.add(doll);
        		}
        		
        	}
        	
        }
        return answer;
    }
}