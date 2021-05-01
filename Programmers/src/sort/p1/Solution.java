package sort.p1;

import java.util.*;

class Solution {
	public static void main(String[] args) {
		int[] arr = {1, 5, 2, 6, 3, 7, 4};
		int[][] coms = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		solution(arr, coms);
	}
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int[] com : commands){
            int[] temp = new int[com[1] - com[0] + 1];
            System.arraycopy(array, com[0] - 1, temp, 0, com[1] - com[0] + 1);
            System.out.println(Arrays.toString(temp));
        }
        
        return answer;
    }
}