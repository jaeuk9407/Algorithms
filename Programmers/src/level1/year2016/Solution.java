package level1.year2016;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int day = 0;
        // �ٷ� ���� ���� ���� �� ��ŭ ����ְ� 1���� �� ������ �ݺ�
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
        // b ó��
        day += b;
        
        // ���� ���ϱ� 1�� 1���� day�� 1������ �ݿ����̹Ƿ� ������Ͽ�ȭ�� ������ ����
        day %= 7;
        String[] weekDay = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        answer = weekDay[day];
        
        return answer;
    }
}
