package level1.문자열내림차순으로배치하기;

import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        // ������ ���� Character �迭 ���� & ���ڿ� ����
        Character[] arr = new Character[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i);
        }
        
        // �������� ����
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
        
        // ���ĵ� �迭�� String���� ��ȯ�ϱ� ���� StringBuilder�� ����
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}
