package level1.정수내림차순으로배치하기;

import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        
        // list�� �� �ڸ��� ���ڸ� �����
        for(int i = 0; i < str.length(); i++){
            list.add(Integer.valueOf(str.charAt(i) - '0'));
        }
        
        // list ������������ ����
        Collections.sort(list, new Comparator<Integer>(){
           @Override
            public int compare(Integer o1, Integer o2){
                if(o1 > o2){
                    return -1;
                }else if(o1 == o2){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        
        // list ���Ҹ� ������� �̾�ٿ� String���� ���� ��, Long���� ��ȯ
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }
        answer = Long.valueOf(sb.toString());
        return answer;
    }
}
