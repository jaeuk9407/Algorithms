package level1.phoneketmon;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int k = 0;  // key의 개수
        int halfN = nums.length / 2;    // 담을 수 있는 2/N 개수
        
        
        Map<Integer, Integer> map = new HashMap<>();
        // <K,V>로 전체 폰켓몬 종류를 하나씩 담아보며 종류의 개수를 셈
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
                k++;
            }
        }
        
        // 폰켓몬 종류의 개수와 2/N을 비교해 작은 값을 return한다
        answer = Math.min(k, halfN);

        return answer;
    }
}
