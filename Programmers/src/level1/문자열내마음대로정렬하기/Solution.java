package level1.문자열내마음대로정렬하기;

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) < o2.charAt(n)) {
					return -1;
				}else if(o1.charAt(n) == o2.charAt(n)) {
					int shortLen = Math.min(o1.length(), o2.length());
					int index = 0;
					while(index <= shortLen - 1) {
						if(o1.charAt(index) < o2.charAt(index)) {
							return -1;
						}else if(o1.charAt(index) > o2.charAt(index)) {
							return 1;
						}
						index++;
					}
					return 0;
				}else {
					return 1;
				}
			}
        	
        });
        return strings;
    }
}
