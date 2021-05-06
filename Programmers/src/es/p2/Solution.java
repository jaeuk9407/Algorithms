package es.p2;

import java.util.*;

class Solution {
    static int answer = 0;
    // numbers의 몇 번째 인덱스 문자를 갖고 있는지 체크하는 배열
    static boolean[] check = new boolean[7];
    // numbers의 숫자 조합을 저장할 ArrayList
    static ArrayList<Integer> arr = new ArrayList<>();
    
    
    public int solution(String numbers) {        
        String temp = "";
        
        // 만들 수 있는 모든 숫자 조합 저장
        for(int i = 1; i <= numbers.length(); i++){
            rec(numbers, temp, i);
        }
        
        // 모든 숫자 조합 case를 소수인지 판별
        for(int number : arr){
            cal(number);
        }
        
        return answer;
    }
    
    // arr에 들어있는 수가 소수인지 판별
    public static void cal(int n){
        if(n == 0) return;
        if(n == 1) return;
        
        // n이 소수인지 판별할 땐 루트 n까지만 검사해봐도 됌
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return;
        }
        // 모두 나눠떨어지지 않으면 소수이므로 answer 증가
        answer++;
    }
    
    
    // 1~n자리 정수를 조합하기 위한 재귀 메서드
    // n: 주어진 문자열, temp: 조합 과정에서 선택한 문자, len: 만들고 있는 수의 길이
    public static void rec(String n, String temp, int len){
        // 종료 조건: 현재 만들고 있는 자릿수
        if(temp.length() == len){
            // 이미 들어있는 값이면 삽입하지 않음(e.g. 000 -> 0)
            if(!arr.contains(Integer.parseInt(temp))) arr.add(Integer.parseInt(temp));
            return;
        }
        
        // n으로 전달받은 numbers를 탐색
        for(int i = 0; i < n.length(); i++){
            // 이미 선택한 인덱스면 pass
            if(check[i]) continue;
            // 임시 문자열인 temp에 문자를 붙여나가며 숫자를 조합
            temp += n.charAt(i);
            check[i] = true;
            // 현재 인덱스 문자를 담은 상태로 재귀 호출
            rec(n, temp, len);
            // 저장이 끝나면 다시 선택될 수 있도록 방문 처리 false
            check[i] = false;
            // 임시 문자열에서도 현재 문자를 제거
            temp = temp.substring(0, temp.length()-1);
        }
    }
}
