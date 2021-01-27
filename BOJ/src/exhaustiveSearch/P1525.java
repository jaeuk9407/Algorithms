package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1525 {
	private static Queue<Integer> q = new LinkedList<>();
	private static Map<Integer, Integer> m = new HashMap<>();
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static int start;
	
	private static void bfs() {
		m.put(start, 0);	// key: 배열 상태, value: 이동 횟수
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			String nowString = String.valueOf(now);
			int nine = nowString.indexOf("9");	// 1차원 배열에서 9의 index
			int x = nine / 3;	// 2차원 배열에서 9의 row index 
			int y = nine % 3;	// 2차원 배열에서 9의 col index
			
			for(int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				int move = nextX * 3 + nextY; // 1차원 배열에서의 이동할 위치 인덱스
				if(0 <= nextX && nextX <= 2 && 0 <= nextY && nextY <= 2) {
					StringBuilder sb = new StringBuilder(nowString);
					char temp = sb.charAt(move);
					sb.setCharAt(move, '9');
					sb.setCharAt(nine, temp);
					int nextNum = Integer.parseInt(sb.toString());
					
					// 다음 이동할 상태가 방문한 적 없을 경우 방문 처리
					if(!m.containsKey(nextNum)) {
						m.put(nextNum, m.get(now)+1);
						q.add(nextNum);
					}
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		start = 0;
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				int k = Integer.parseInt(st.nextToken());
				if(k == 0) {
					k = 9;
				}
				// (3*3)2차원 배열을 늘어뜨려 하나의 9자리 정수로 변환 
				start = (start * 10) + k;
			}
		}
		
//		System.out.println(start);
		bfs();
		
		if(m.containsKey(123456789)) {
			System.out.println(m.get(123456789));
		}else {
			System.out.println(-1);
		}
		
	}

}
