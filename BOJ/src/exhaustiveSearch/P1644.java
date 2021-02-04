package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1644 {
	static int N;
	static ArrayList<Integer> primes = new ArrayList<>();
	static boolean[] isNotPrime;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		isNotPrime = new boolean[5000000];
		isNotPrime[1] = true;
		
		// 에라토스테네스의 체
		for(int i = 2; i*i < 5000000; i++) {
			for(int j = i*i; j < 5000000; j+=i) {
				isNotPrime[j] = true;
			}
		}
		for(int i = 1; i < 5000000; i++) {
			if(isNotPrime[i] == false) {
				primes.add(i);
//				System.out.println(i);
			}
		}
		
		// two pointer
		int start = 0; int end = 0; int sum = primes.get(0);
		cnt = 0;
		while(true) {
			if(sum == N) {
				cnt++;
				sum += primes.get(++end);
				sum -= primes.get(start++);
			}else if(sum < N) {
				sum += primes.get(++end);
			}else {
				sum -= primes.get(start++);
			}
			
			if(primes.get(end) > N) {
				break;
			}
		}
		
		System.out.println(cnt);
		
	}

}
