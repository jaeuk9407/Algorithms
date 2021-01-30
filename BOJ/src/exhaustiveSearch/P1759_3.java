package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759_3 {

	static int L, C;
	static String[] alphas;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphas = br.readLine().split(" ");
		Arrays.sort(alphas);
		
		solve(0, "");
	}
	
	private static void solve(int index, String password) {
		if(password.length() == L) {
			if(count(password)) {
				System.out.println(password);
				return;
			}
		}
		if(index >= alphas.length) return;
		
		solve(index+1, password+alphas[index]);
		solve(index+1, password);
	}
	
	private static boolean count(String password) {
		int ja = 0, mo = 0;
		for(int i = 0; i < password.length(); i++) {
			if(checkM(password.charAt(i))) mo++;
			else ja++;
		}
		if(ja >= 2 && mo >= 1) return true;
		else return false;
	}
	
	private static boolean checkM(char c) {
		if(c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u') return true;
		return false;
	}
}
