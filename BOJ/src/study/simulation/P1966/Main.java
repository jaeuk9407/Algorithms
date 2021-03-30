package study.simulation.P1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int testcase;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st;
		for(int t = 0; t < testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int numDocs = Integer.parseInt(st.nextToken());
			int insNum = Integer.parseInt(st.nextToken());
			
			int[] contents = new int[numDocs];
			int max = -1;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < numDocs; i++) {
				contents[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, contents[i]);
			}
			NewPrinter np = new NewPrinter(contents, numDocs, max);
			int result = np.print(insNum);
			
			System.out.println(result);
		}
		br.close();
	}

}

class NewPrinter{
	int maxImpo;
	int[] contents;
	boolean[] isPrinted;
	int front;
	int rear;
	int size;
	int printedSize;
	
	// 초기 생성시 Queue 동작 원리대로 front, rear를 설정 
	public NewPrinter(int[] contents, int size, int maxImpo) {
		this.contents = contents;
		this.size = size;
		this.front = 0;
		this.rear = size - 1;
		this.isPrinted = new boolean[size];
		this.maxImpo = maxImpo;
		this.printedSize = 0;
	}
	
	// 모든 문서를 출력 동작하는 함수
	public int print(int insNum) {
		
		while(true) {
			// 모든 문서가 출력되었다면 출력 종료
			if(printedSize == size) {
				break;
			}
			// 아직 출력되지 않은 문서에 대해서만 수행 
			if(!isPrinted[front]) {
				// 현재 위치의 중요도가 낮으면 front, rear 포인터를 하나씩 이동 
				// => 맨 뒤로 현재 front를 이동시킴
				if(contents[front] < maxImpo) {
					front++;
					rear++;
					
					// 끝 위치에 포인터 도달하면 0인덱스로 이동(원형큐)
					if(front == size) {
						front = 0;
					}
					if(rear == size) {
						rear = 0;
					}
				}else {
					// 현재 위치의 중요도가 가장 높으면 그대로 출력
//					System.out.println(front+ "번째 문서 출력");
					isPrinted[front] = true;
					printedSize++;
					updateMaxImpo();
					
					// 검사할 문서라면 반복을 멈추고 몇 번째 인쇄인지 반환
					if(front == insNum) {
						return printedSize;
					}
					
					// 출력후 front 포인터 이동
					front++;
					if(front == size) {
						front = 0;
					}
				}
			}else {
				// 이미 출력된 문서라면 다음 문서 탐색
				front++;
				if(front == size) {
					front = 0;
				}
			}
		}
		
		// 동작 도중 return하지 않았다면 오류
		return -1;
	}

	
	// MaxImpo Update 함수
	public void updateMaxImpo() {
		// 현재 위치가 maxImpo라면 maxImpo를 재탐색
		if(contents[front] == maxImpo) {
			// 초기화 후 다시 탐색
			maxImpo = -1;
			for(int i = 0; i < size; i++) {
				if(!isPrinted[i]) {
					maxImpo = Math.max(maxImpo, contents[i]);
				}
			}
		}
	}
	
	public void setMaxImpo(int value) {
		this.maxImpo = value;
	}
	

	@Override
	public String toString() {
		return "NewPrinter [maxImpo=" + maxImpo + ", contents=" + Arrays.toString(contents) + ", front=" + front
				+ ", rear=" + rear + ", size=" + size + "]";
	}
}
