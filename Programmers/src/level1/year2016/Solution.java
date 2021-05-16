package level1.year2016;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int day = 0;
        // 바로 직전 달의 요일 수 만큼 담아주고 1월이 될 때까지 반복
        while(a > 1){
            if(a == 2 || a == 4 || a == 6 || a == 8 || a == 9 || a == 11){
                day += 31;
            }else if(a == 3){
                day += 29;
            }else{
                day += 30;
            }
            a--;
        }
        // b 처리
        day += b;
        
        // 요일 구하기 1월 1일은 day가 1이지만 금요일이므로 목금토일월화수 순서로 진행
        day %= 7;
        String[] weekDay = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        answer = weekDay[day];
        
        return answer;
    }
}
