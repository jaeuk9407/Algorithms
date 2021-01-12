package DAY02.P2003;

// 투 포인터 

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainSolution {
	static int N;
	static int M;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/DAY02/P2003/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		//System.out.println(Arrays.toString(nums));
		
		int start = 0, end = 0, sum = 0, count = 0;
		sum = nums[0];
		
		
		while(true) {
			if(sum == M) {
				count++;
				sum -= nums[start++];
				sum += nums[++end];
			}else if(sum > M) {
				sum -= nums[start++];
			}else {
				sum += nums[++end];
			}
			if(end == N) {
				break;
			}
		}
		br.close();
		System.out.println(count);
		
	}

}
