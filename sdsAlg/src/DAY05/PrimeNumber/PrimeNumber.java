package DAY05.PrimeNumber;

// 에라토스테네스의 체를 사용해 N보다 작은 소수 구하기

public class PrimeNumber {
	static int MAX= 120;
	static boolean[] checked;
	
	public static void main(String[] args) throws Exception {
		checked = new boolean[MAX + 1];
		for(int i = 2; i <= MAX; i++) {
			if(checked[i] == false) {
				System.out.println(i + ", ");
				for(int j = i + i; j <= MAX; j += i) {
					checked[j] = true;
					
				}
			}
		}
	}
}
