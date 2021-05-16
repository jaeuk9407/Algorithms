package level1.reverseBasis3;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int current = n;
        
        // ������ 3������ ��ȯ
        while(current > 0){
            // ���� �������� ������� �ְ�
            sb.append(current % 3);
            // ���� ������ current�� ������Ʈ
            current /= 3;
        }
        
        char[] result = sb.toString().toCharArray();
        // ������ 3������ 10�������� ��ȯ
        int k = 0;  // k�� ����
        for(int i = result.length-1; i >= 0; i--){
            if(result[i] - '0' >= 1){
                // ������ŭ �ݺ����� ���� �ڸ����� �������
                int mul = 1;
                for(int j = 0; j < k; j++){
                    mul *= 3;
                }
                // �ڸ����� �������� �ش� ����ŭ ���ؼ� 10���� ���� �־���(ex. 21(3����) -> (3^1 * 2) + (3^0 * 1))
                answer += mul * (result[i] - '0');
            }
            // ���� 0�̾ �ڸ��� �ٲ�⶧���� �������� ����
            k++;
        }
        return answer;
    }
}
