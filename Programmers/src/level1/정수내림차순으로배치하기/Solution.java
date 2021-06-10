package level1.정수내림차순으로배치하기;

import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        
        // list로 각 자릿수 숫자를 담아줌
        for(int i = 0; i < str.length(); i++){
            list.add(Integer.valueOf(str.charAt(i) - '0'));
        }
        
        // list 내림차순으로 정렬
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
        
        // list 원소를 순서대로 이어붙여 String으로 만든 뒤, Long으로 변환
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }
        answer = Long.valueOf(sb.toString());
        return answer;
    }
}
