package sds.graph1.P1516;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int minTime[];
	static int timeCost[];
	static boolean[] visited;
	static ArrayList<Integer> pre[];
	static ArrayList<Integer> outs[];
	static Queue<Integer> q = new LinkedList<>();
 	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pre = new ArrayList[N + 1];
		outs = new ArrayList[N + 1]; 
		visited = new boolean[N + 1];
		minTime = new int[N + 1];
		timeCost = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			pre[i] = new ArrayList<>();
			outs[i] = new ArrayList<>();
//			minTime[i] = 60000000;	// 노드 최대 누적시간 50000000 
		}
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			timeCost[i] = Integer.parseInt(st.nextToken());
			
			// 입력 값이 더 있으면 
			while(st.hasMoreTokens()){
				// 받아서 -1이 아니면 현재 노드를 수행하기 위해 필요한 사전방문노드를 저장 
				int num = Integer.parseInt(st.nextToken());
				if(num != -1) {
					pre[i].add(num);
					outs[num].add(i);
				}
			}
		} // end of input processing
		
		topologySort();
		
		for(int i = 1; i <= N; i++) {
			System.out.println(minTime[i]);
		}
		
	} // end of main
	
	private static void topologySort() {
		// 필요한 사전방문노드가 없다면 큐에 넣어줌
		for(int i = 1; i <= N; i++) {
			if(pre[i].isEmpty()) {
				q.add(i);
				minTime[i] = timeCost[i];
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 현재 노드를 진입노드로 갖는 노드들의 진입간선을 지워준다
			if(!outs[now].isEmpty()) {
				// 진출간선을 하나씩 꺼내어
				for(int i = 0; i < outs[now].size(); i++) {
					int next = outs[now].get(i);
					// 진출간선이 연결된 다음 노드의 진입간선을 하나씩 확인해보며
					for(int j = 0; j < pre[next].size(); j++) {
						int preNode = pre[next].get(j);
						// 현재노드에서 진출간선에 해당하는 진입간선을 찾으면 지워준다.
						if(preNode == now) {
							pre[next].remove(j);
							// 지워줄 때마다 최소 시간을 세팅한다. (주의)
							int tmp = minTime[now] + timeCost[next];
							if(minTime[next] < tmp) {
								minTime[next] = tmp;
							}
							// 진입간선을 지워준 다음 노드가 더이상 진입간선이 없으면
							if(pre[next].isEmpty()) {
								// 큐를 추가하고 최소시간을 셋팅한다. 
								q.add(next);
							}
						}
					}
				}
			}
		}
	}
}
