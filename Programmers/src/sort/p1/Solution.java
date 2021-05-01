package sort.p1;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int k = 0;
        for(int[] com : commands){
            // split
            int[] temp = new int[com[1] - com[0] + 1];
            System.arraycopy(array, com[0] - 1, temp, 0, com[1] - com[0] + 1);
            // sort
            Arrays.sort(temp);
            // result
            answer[k++] = temp[com[2] - 1];
        }
        
        return answer;
    }
}