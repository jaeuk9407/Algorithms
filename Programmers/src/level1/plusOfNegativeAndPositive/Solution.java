package level1.plusOfNegativeAndPositive;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        // �������� �ϳ��� �̾�
        for(int i = 0; i < absolutes.length; i++){
            // ����� ���ϰ�
            if(signs[i]){
                answer += absolutes[i];
            }else{ // ������ ����
                answer -= absolutes[i];
            }
        }
        
        return answer;
    }
}
