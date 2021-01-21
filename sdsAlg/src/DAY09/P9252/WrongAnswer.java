package DAY09.P9252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class WrongAnswer {
	/*
	 * 정답: 3, CAP
	 * ==> 단순히 하나의 STR을 먼저 전진시키며 탐색하면 안된다!
	 * ==> 위를 전진시킬지, 아래를 전진시킬지 알기 위해서는 반드시 둘 다 끝까지 가봐야 알 수 있다.
	 * ==> 끝에서 거꾸로 앞을 탐색하는 재귀 형태로 구현 가능하다.
	 * ==> 연산을 줄이기 위해서는 메모이제이션을 활용한 DP를 사용해야 한다. 
	 */
	static String str1, str2;
	
    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("src/DAY09/P9252/input_forWrong.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
		str2 = br.readLine();
		
		int point1 = 0, point2 = 0;
		int last_point1 = 0, last_point2 = 0;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			// str1, str2 끝까지 탐색 완료 ==> 탈출
			if(str1.length() <= point1) {
				break;
			}else if(str2.length() <= point2) {
				//str2를 끝까지 탐색했다면 마지막으로 공통 문자열을 찾았던 인덱스로 돌아가 다시 탐색한다. 
				point2 = last_point2;
				point1++;
				if(str2.length() == 1) break;
			}else {
				// str1, str2 모두 탐색할 부분이 남아있는 경우
//				System.out.println(point1+", "+point2);
				if(str1.charAt(point1) == str2.charAt(point2)) {
					sb.append(str1.charAt(point1));
					cnt++;
					last_point1 = point1;
					last_point2 = point2;
					point1++;
					point2++;
				}else {
					point2++;
				}
			}
		} // end of While
		
		if(cnt == 0) {
			System.out.println(0);
		}else {
			System.out.println(cnt);
			System.out.println(sb.toString());
		}
    }
}