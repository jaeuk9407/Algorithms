package DAY04.EuclideanAlg;

public class GCD {

	public static void main(String[] args) throws Exception {
		
		System.out.println(gcd(36, 24));
		
	}
	// gcd(a, b) == gcd(b, r), r = a%b, b이 0이 되는 순간 => gcd
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
			
			if(b == 0) {
				break;
			}
		}
		return a;
	}
}
