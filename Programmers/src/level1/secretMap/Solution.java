package level1.secretMap;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // int형 임시 지도 정보
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        // 임시 지도 생성
        // 행마다 반복
        for(int i = 0; i < arr1.length; i++){
            // 이진수로 복호화한 뒤
            char[] binary1 = Integer.toBinaryString(arr1[i]).toCharArray();
            char[] binary2 = Integer.toBinaryString(arr2[i]).toCharArray();
            
            // map2의 열 index
            int k = n - 1;
            // n개 열의 맨 뒤에서부터 이진수를 채워넣는다 (ex. 10 -> 00010으로 넣어야 하기 때문)
            // 1번 임시지도 정보 입력
            for(int j = binary1.length-1; j >= 0; j--){
                if(binary1[j] == '1'){
                    map1[i][k--] = 1;
                }else{
                    map1[i][k--] = 0;
                }
            }
            
            // map2의 열 index
            k = n - 1;
            // 2번 임시지도 정보 입력
            for(int j = binary2.length-1; j >= 0; j--){
                if(binary2[j] == '1'){
                    map2[i][k--] = 1;
                }else{
                    map2[i][k--] = 0;
                }
            }
        }

        // 2개의 임시 지도를 토대로 최종 지도 정보 수집
        // 행/열 이중 반복문으로 진행
        for(int i = 0; i < map1.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < map1[i].length; j++){
                // 해당 위치가 하나라도 벽이면 벽으로 처리
                if(map1[i][j] == 1 || map2[i][j] == 1){
                    sb.append('#');
                }else{ // 그 외의 경우는 두 지도 모두 공백
                    sb.append(' ');
                }
            }
            // 행의 정보를 담은 StringBuilder를 answer의 행으로 저장
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}