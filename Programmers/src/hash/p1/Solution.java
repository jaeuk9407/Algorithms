package hash.p1;

import java.util.*;
import java.util.Map.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> info = new HashMap<>();
        
        // �� �� Map�� ����, �̹� ��� �ִٸ� ���� value���� +1
        for(String name: participant){
            info.put(name, info.getOrDefault(name, 0) + 1);
        }
        
        // �� �� Map���� ���� value�� �� -1
        for(String name : completion){
            info.replace(name, info.getOrDefault(name, 0) - 1);
            System.out.println(info.get(name));
        }
        
        // �ϳ��� value�� ���� �ִٸ� �������� ���� ����
        for(Entry<String, Integer> entry : info.entrySet()){
            if(entry.getValue() > 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}