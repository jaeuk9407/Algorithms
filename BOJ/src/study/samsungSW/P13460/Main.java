package study.samsungSW.P13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int RED = 0, BLUE = 1;
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dirX = new int[] {0, 0, 1, -1};
	static int[] dirY = new int[] {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[10][10][10][10];
		
		Node node = new Node();
		node.cnt = 0;
		
		// map 정보 입력
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'R') {
					node.rRow = i;
					node.rCol = j;
				}else if(map[i][j] == 'B') {
					node.bRow = i;
					node.bCol = j;
				}
			}
		}
		
		bfs(node);
	}
	
	public static void bfs(Node ball) {
		Queue<Node> q = new LinkedList<>();
		q.offer(ball);
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			visited[node.rRow][node.rCol][node.bRow][node.bCol] = true;
			
			// 11번 이상 굴린 경우 -1을 출력(0부터 시작하기 때문에 10으로 설정)
			if(node.cnt >= 10) {
				System.out.println(-1);
				return;
			}
			
			// 현재 두 구슬의 위치를 기준으로 동, 서, 남, 북으로 굴려봄
			for(int dir = 0; dir < 4; dir++) {
				int[] bn = rollBlue(node.bRow, node.bCol, dir);
				int[] rn = rollRed(node.rRow, node.rCol, dir);
				
				if(map[bn[0]][bn[1]] == 'O')
					continue;
				if(map[rn[0]][rn[1]] == 'O') {
					System.out.println(node.cnt + 1);
					return;
				}
				// 두 구슬의 위치가 같다면, 위치를 조정한다.
				if(rn[0] == bn[0] && rn[1] == bn[1]) {
					if(dir == 0) {
						if(node.rCol > node.bCol) {
							bn[1] -= 1;
						}else {
							rn[1] -= 1;
						}
					}else if(dir == 1) {
						if(node.rCol > node.bCol) {
							rn[1] += 1;
						}else {
							bn[1] += 1;
						}
					}else if(dir == 2) {
						if(node.rRow > node.bRow) {
							bn[0] -= 1;
						}else {
							rn[0] -= 1;
						}
					}else if(dir == 3) {
						if(node.rRow > node.bRow) {
							rn[0] += 1;
						}else {
							bn[0] += 1;
						}
					}
				} // end of roll
				
				// 두 구슬을 굴린 후의 각각 위치가 처음 탐색하는 모양이면 큐에 넣음
				if(!visited[rn[0]][rn[1]][bn[0]][bn[1]]) {
					q.offer(new Node(rn[0], rn[1], bn[0], bn[1], node.cnt + 1));
				}
			} // end of for(동,서,남,북)
		}
		System.out.println(-1);
	}
	
	// 파란색 구슬을 굴린다
	public static int[] rollBlue(int bRow, int bCol, int dir) {
		int[] nxtB = new int[2];
		int bnRow = bRow;
		int bnCol = bCol;
		
		while(map[bnRow + dirX[dir]][bnCol + dirY[dir]] != '#') {
			bnRow += dirX[dir];
			bnCol += dirY[dir];
			if(map[bnRow][bnCol] == 'O') {
				break;
			}
		}
		nxtB[0] = bnRow;
		nxtB[1] = bnCol;
		return nxtB;
	}
	
	// 빨간색 구슬을 굴린다
	public static int[] rollRed(int rRow, int rCol, int dir) {
		int[] nxtR = new int[2];
		int rnRow = rRow;
		int rnCol = rCol;
		
		while(map[rnRow+dirX[dir]][rnCol + dirY[dir]] != '#') {
			rnRow += dirX[dir];
			rnCol += dirY[dir];
			if(map[rnRow][rnCol] == 'O') {
				break;
			}
		}
		nxtR[0] = rnRow;
		nxtR[1] = rnCol;
		return nxtR;
	}
	// map 정보 출력
	public static void showMap(int[][] map) {
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
}
class Node{
	int rRow; int rCol;
	int bRow; int bCol;
	int cnt;
	
	public Node(int rRow, int rCol, int bRow, int bCol, int cnt) {
		this.rRow = rRow;
		this.rCol = rCol;
		this.bRow = bRow;
		this.bCol = bCol;
		this.cnt = cnt;
	}

	public Node() {
	}
}

