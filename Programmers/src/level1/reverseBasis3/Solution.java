package level1.reverseBasis3;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int current = n;
        
        // 뒤집힌 3진수로 변환
        while(current > 0){
            // 나눈 나머지를 순서대로 넣고
            sb.append(current % 3);
            // 나눈 값으로 current를 업데이트
            current /= 3;
        }
        
        char[] result = sb.toString().toCharArray();
        // 뒤집은 3진법을 10진법으로 변환
        int k = 0;  // k의 지수
        for(int i = result.length-1; i >= 0; i--){
            if(result[i] - '0' >= 1){
                // 지수만큼 반복문을 통해 자릿값을 만들어줌
                int mul = 1;
                for(int j = 0; j < k; j++){
                    mul *= 3;
                }
                // 자릿값을 기준으로 해당 수만큼 곱해서 10진수 값을 넣어줌(ex. 21(3진수) -> (3^1 * 2) + (3^0 * 1))
                answer += mul * (result[i] - '0');
            }
            // 값이 0이어도 자리가 바뀌기때문에 지수값도 변경
            k++;
        }
        return answer;
    }
}
