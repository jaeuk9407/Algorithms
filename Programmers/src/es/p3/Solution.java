package es.p3;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int height = 0;
        int width = 0;
        
        // brown 개수를 만족시킬 수 있는 범위에서 height 반복
        for(height = 3; height <= (brown + 4)/ 2; height++){
            // 현재 height에서 조건에 부합하는 width
            width = ((brown + 4) / 2) - height;
            // height가 width보다 클 수 없으므로 다음 height 탐색
            if(width < height){
                break;
            }
            // brown 조건에서 yellow 개수가 조건 yellow도 만족하면 탐색 종료
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
