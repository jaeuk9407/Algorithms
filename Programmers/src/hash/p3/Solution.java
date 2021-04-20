package hash.p3;

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 의상 카테고리(K), 개수(V)를 저장
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String key = clothes[i][1];
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        
        // 각 카테고리별 경우의 수 : v + 1(안 입는 경우)
        for(Entry<String, Integer> entry : hm.entrySet()){
            answer *= entry.getValue() + 1;
        }
        return answer - 1;
    }
 }
