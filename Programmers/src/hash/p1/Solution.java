package hash.p1;

import java.util.*;
import java.util.Map.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> info = new HashMap<>();
        
        // 한 명씩 Map에 담음, 이미 담겨 있다면 기존 value에서 +1
        for(String name: participant){
            info.put(name, info.getOrDefault(name, 0) + 1);
        }
        
        // 한 명씩 Map에서 기존 value의 값 -1
        for(String name : completion){
            info.replace(name, info.getOrDefault(name, 0) - 1);
            System.out.println(info.get(name));
        }
        
        // 하나라도 value가 남아 있다면 완주하지 못한 선수
        for(Entry<String, Integer> entry : info.entrySet()){
            if(entry.getValue() > 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}