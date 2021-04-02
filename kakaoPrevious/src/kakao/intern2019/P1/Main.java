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
        
        // 스택 배열에 board 정보 입력
        for(int col = 0; col < n; col++) {
        	for(int row = n - 1; row >= 0; row--) {
        		if(board[row][col] != 0) {
        			st[col + 1].push(board[row][col]);
        		}
        	}
        }
        
        
        // 명령 하나씩 수행
        for(int move = 0; move < moves.length; move++) {
        	if(!st[moves[move]].isEmpty()) {
        		int doll = st[moves[move]].pop();
        		
        		// pocket의 맨 윗 값이 넣으려는 인형과 다르면 뽑은 인형을 넣고,
        		// 같으면 둘 다 없애주고 count.
        		if(!pocket.isEmpty()) {
	        		int pocketTop = pocket.pop();
	        		if(pocketTop != doll) {
	        			pocket.add(pocketTop);
	        			pocket.add(doll);
	        		}else {
	        			answer += 2;
	        		}
        		}else {
        			// 포켓이 비어있는 경우 그냥 넣어준다. 
        			pocket.add(doll);
        		}
        		
        	}
        	
        }
        return answer;
    }
}