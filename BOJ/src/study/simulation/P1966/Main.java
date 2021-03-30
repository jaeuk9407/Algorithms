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
	
	// �ʱ� ������ Queue ���� ������� front, rear�� ���� 
	public NewPrinter(int[] contents, int size, int maxImpo) {
		this.contents = contents;
		this.size = size;
		this.front = 0;
		this.rear = size - 1;
		this.isPrinted = new boolean[size];
		this.maxImpo = maxImpo;
		this.printedSize = 0;
	}
	
	// ��� ������ ��� �����ϴ� �Լ�
	public int print(int insNum) {
		
		while(true) {
			// ��� ������ ��µǾ��ٸ� ��� ����
			if(printedSize == size) {
				break;
			}
			// ���� ��µ��� ���� ������ ���ؼ��� ���� 
			if(!isPrinted[front]) {
				// ���� ��ġ�� �߿䵵�� ������ front, rear �����͸� �ϳ��� �̵� 
				// => �� �ڷ� ���� front�� �̵���Ŵ
				if(contents[front] < maxImpo) {
					front++;
					rear++;
					
					// �� ��ġ�� ������ �����ϸ� 0�ε����� �̵�(����ť)
					if(front == size) {
						front = 0;
					}
					if(rear == size) {
						rear = 0;
					}
				}else {
					// ���� ��ġ�� �߿䵵�� ���� ������ �״�� ���
//					System.out.println(front+ "��° ���� ���");
					isPrinted[front] = true;
					printedSize++;
					updateMaxImpo();
					
					// �˻��� ������� �ݺ��� ���߰� �� ��° �μ����� ��ȯ
					if(front == insNum) {
						return printedSize;
					}
					
					// ����� front ������ �̵�
					front++;
					if(front == size) {
						front = 0;
					}
				}
			}else {
				// �̹� ��µ� ������� ���� ���� Ž��
				front++;
				if(front == size) {
					front = 0;
				}
			}
		}
		
		// ���� ���� return���� �ʾҴٸ� ����
		return -1;
	}

	
	// MaxImpo Update �Լ�
	public void updateMaxImpo() {
		// ���� ��ġ�� maxImpo��� maxImpo�� ��Ž��
		if(contents[front] == maxImpo) {
			// �ʱ�ȭ �� �ٽ� Ž��
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
