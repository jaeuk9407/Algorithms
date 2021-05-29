package level1.문자열내림차순으로배치하기;

import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        // 정렬을 위한 Character 배열 생성 & 문자열 복사
        Character[] arr = new Character[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i);
        }
        
        // 내림차순 정렬
        Arrays.sort(arr, new Comparator<Character>(){
           @Override
            public int compare(Character o1, Character o2){
                if(Integer.valueOf(o1) > Integer.valueOf(o2)){
                    return -1;
                }else if(Integer.valueOf(o1) == Integer.valueOf(o2)){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        
        // 정렬된 배열을 String으로 변환하기 위해 StringBuilder에 삽입
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}
