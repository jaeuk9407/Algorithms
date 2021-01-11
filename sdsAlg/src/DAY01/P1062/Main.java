package DAY01.P1062;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	static int N, K;
	static boolean[] visited;
	static String[] words;
	static int selectedCount = 0;
	static int max = 0;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/DAY01/P1062/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.next());
		K = Integer.parseInt(sc.next());
		
		// words 입력
		words = new String[N];
		for(int i=0; i<N; i++) {
			words[i] = sc.next();
		}
		
		visited = new boolean[26];
		
		// a, n, t, i, c
		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;
		
		if(K < 5) {
			System.out.println(0);
			return;
		}
		
		for(int i = 0; i < 26; i++) {
			if(visited[i] == false) {
				dfs(i);
			}
		}
		
		//max 출력
		System.out.println(max);
	}
	
	
	static void dfs(int index) {
		int sentenceCount = 0;
		// 1. 체크인 => visitied[index] = true, selectedCount
		visited[index] = true;
		selectedCount++;
		// 2. 목적지인가? => selectedCount 가 K에 도달했다 -> max 갱신
		if(selectedCount == K-5) {
			WordInspection: for(String str: words) {
				for(int i = 0; i<str.length(); i++) {
					if(visited[str.charAt(i)-'a'] == false) {
						// word안에 선택하지 않은 문자가 있으므로 다음 word로 넘어간다
						continue WordInspection;
					}
				}
				// 모두 있는 글자라 break없이 나온 문장 개수 counting
				sentenceCount++;
			}
			// max 갱신
			if(sentenceCount >= max) {
				max = sentenceCount;
			}
			// 나가기 전 방문 목록 초기화
			visited[index] = false;
			selectedCount--;
			return;
		}
		// 3. 연결된 곳을 순회 -> index +1 ~ 26
		for(int i = index; i < 26; i++) {
			// 4. 갈 수 있는가? => visited[next] == false
			if(visited[i] == false) {
				// 5. 간다 dfs(next)
				dfs(i);
			}
		}
		// 6. 체크아웃 => visited[index] = false, selectedCount
		visited[index] = false;
		selectedCount--;
	}

}
