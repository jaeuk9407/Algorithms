package DAY06.P1922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, Answer;
	private static Info[] edge;
	private static int[] pr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		edge = new Info[M];
		Answer = 0;
		pr = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			pr[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b, c;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			edge[i] = new Info(a, b, c);
		}
		
		
		
		// 간선의 크기 순으로 정렬
		Arrays.sort(edge, new Comparator<Info>(){

			@Override
			public int compare(Info o1, Info o2) {
				if(o1.c < o2.c) return -1;
				else if(o1.c > o2.c) return 1;
				return 0;
			}
		});
		
//		System.out.println(Arrays.toString(edge));
		
		
		int cnt = 0;
		// 크루스칼 알고리즘 사용 = 간의 비용이 작은것부터 트리 구성
		// union-find 이용해서 트리구성
		for(int i = 0; i < M; i++) {
			// 간선 정보를 읽어옴
			int a, b, c;
			a = edge[i].a; // 한쪽 끝 노드 
			b = edge[i].b; // 다른쪽 끝 노드
			c = edge[i].c; // 간선의 비용
			
			// 둘이연결되어 있는지 = 같은 그룹인지 확인
			// 서로 다른 그룹이면 연결해줌, 비용도 추가해 
			// 비용을 게산
			if(find(a) != find(b)) {
//				System.out.println("union a, b"+a+","+b);
				union(a, b);
				Answer += c;
				cnt++;
			}
		}
		
		// 연결 횟수 = MST 간선개수 != N-1 ==> 상황에 따라 MST 구성이 안된 상황 예외처리 필요!!
//		System.out.println("pr : "+Arrays.toString(pr));
		System.out.println(Answer);
		
	}
	
	public static int find(int a) {
		if(a == pr[a]) return a;
		pr[a] = find(pr[a]);
		return pr[a];
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		pr[a] = b;
	}
	
}

class Info{
	public int a, b, c;

	public Info(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Info [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
}