package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9019 {
	
	private static int T;
	private static Queue<Integer> q;
	private static int cnt[];	// 방문 횟수 기록하기 위한 배열
	private static String[] strs;	// commands를 기록하기 위한 배열
	
	private static int commandD(int a) {
		a = (2 * a) % 10000;
		return a;
	}
	private static int commandS(int a) {
		a -= 1;
		if(a == -1) return a = 9999;
		return a;
	}
	private static int commandL(int a) {
		char[] tmp = new char[4];
		String aToString = String.valueOf(a);
		// 1000 이상이면 그대로 char배열로 변환
		if(aToString.length() == 4) {
			tmp = aToString.toCharArray();
		}else {
			// 1000 미만이면 가장 높은 자릿수부터 값 채움
			int j = 0;
			for(int i = 4 - aToString.length(); i < 4 ; i++) {
				tmp[i] = aToString.charAt(j);
				j++;
			}
		}
		
		char tmp_2 = tmp[0];	// 1000의 자릿수를 1의 자릿수로 복사하기 전 임시보관 변수
		for(int i = 0; i < 3; i++) {
			tmp[i] = tmp[i+1];
		}
		tmp[3] = tmp_2;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<4; i ++) {
			// 비어 있는 자릿수에는 0을 채워줌
			if(tmp[i] == 0) {
				sb.append('0');
			}else {
				sb.append(tmp[i]);
			}
		}
		int result = Integer.parseInt(sb.toString()); 
			
		return result;
	}
	
	private static int commandR(int a) {
		char[] tmp = new char[4];
		String aToString = String.valueOf(a);
		if(aToString.length() == 4) {
			tmp = aToString.toCharArray();
		}else {
			int j = 0;
			for(int i = 4 - aToString.length(); i < 4 ; i++) {
				tmp[i] = aToString.charAt(j);
				j++;
			}
		}
		
		char tmp_2 = tmp[3];	// 1의 자릿수를 1000의 자릿수로 복사하기 전 임시보관 변수
		for(int i = 3; 1 <= i; i--) {
			tmp[i] = tmp[i-1];
		}
		tmp[0] = tmp_2;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<4; i ++) {
			// 비어 있는 자릿수에는 0을 채워줌
			if(tmp[i] == 0) {
				sb.append('0');
			}else {
				sb.append(tmp[i]);
			}
		}
		int result = Integer.parseInt(sb.toString()); 
			
		return result;
	}
	
	private static void bfs(int start, int end) {
		int now = start;
		q.add(now);
		cnt[now] = 0;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			// 목적지
			if(node == end) {
				break;
			}
			
			// 순회
			int resultD = commandD(node);
			int resultS = commandS(node);
			int resultL = commandL(node);
			int resultR = commandR(node);
			int[] results = {resultD, resultS, resultL,resultR};
			
			for(int i = 0; i < 4; i++) {
				// 방문한 적이 있으면 건너뜀
				if(cnt[results[i]] != -1) {
					continue;
				}else {
					// 아직 방문하지 않은 수일때만 방문
					int next = results[i];
					StringBuilder sb = new StringBuilder();
					if(strs[node] != null) {
						sb.append(strs[node]);
					}
					if(i == 0) {
						sb.append("D");
					}else if(i == 1) {
						sb.append("S");
					}else if(i == 2) {
						sb.append("L");
					}else {
						sb.append("R");
					}
					q.add(next);
					cnt[next] = cnt[node] + 1;
					strs[next] = sb.toString();
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0; i < T; i++) {
			strs = new String[10000];
			q = new LinkedList<>();
			cnt = new int[10000];
			for(int j = 0; j <10000; j++) {
				cnt[j] = -1;
			}
			
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			bfs(A, B);
			
			System.out.println(strs[B]);
		}
		br.close();
	}
}
