package sort.p3;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 1. ����
        Arrays.sort(citations);
        
        // 2. 1���� ������ �� ������ ū ������ Ȯ��
        for(int i = 0; i <= citations.length; i++){
            int count = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[j] >= i){
                    count++;
                }
            }
            // 3. count�� �� �� �̻��̸� �� ������ update
            if(i <= count){
                answer = i;
            }
            // 4. ������ update ����
            else break;
        }
        return answer;
    }
}
