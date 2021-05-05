package es.p3;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int height = 0;
        int width = 0;
        
        // brown ������ ������ų �� �ִ� �������� height �ݺ�
        for(height = 3; height <= (brown + 4)/ 2; height++){
            // ���� height���� ���ǿ� �����ϴ� width
            width = ((brown + 4) / 2) - height;
            // height�� width���� Ŭ �� �����Ƿ� ���� height Ž��
            if(width < height){
                break;
            }
            // brown ���ǿ��� yellow ������ ���� yellow�� �����ϸ� Ž�� ����
            int yellowCnt = (width - 2) * (height - 2);
            if(yellow == yellowCnt){
                break;
            }
        }
        
        answer[0] = width;
        answer[1] = height;
        
        return answer;
    }
}
