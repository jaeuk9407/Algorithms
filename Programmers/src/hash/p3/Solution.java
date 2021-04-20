package hash.p3;

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // �ǻ� ī�װ�(K), ����(V)�� ����
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String key = clothes[i][1];
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        
        // �� ī�װ��� ����� �� : v + 1(�� �Դ� ���)
        for(Entry<String, Integer> entry : hm.entrySet()){
            answer *= entry.getValue() + 1;
        }
        return answer - 1;
    }
 }
