package level1.secretMap;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // int�� �ӽ� ���� ����
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        // �ӽ� ���� ����
        // �ึ�� �ݺ�
        for(int i = 0; i < arr1.length; i++){
            // �������� ��ȣȭ�� ��
            char[] binary1 = Integer.toBinaryString(arr1[i]).toCharArray();
            char[] binary2 = Integer.toBinaryString(arr2[i]).toCharArray();
            
            // map2�� �� index
            int k = n - 1;
            // n�� ���� �� �ڿ������� �������� ä���ִ´� (ex. 10 -> 00010���� �־�� �ϱ� ����)
            // 1�� �ӽ����� ���� �Է�
            for(int j = binary1.length-1; j >= 0; j--){
                if(binary1[j] == '1'){
                    map1[i][k--] = 1;
                }else{
                    map1[i][k--] = 0;
                }
            }
            
            // map2�� �� index
            k = n - 1;
            // 2�� �ӽ����� ���� �Է�
            for(int j = binary2.length-1; j >= 0; j--){
                if(binary2[j] == '1'){
                    map2[i][k--] = 1;
                }else{
                    map2[i][k--] = 0;
                }
            }
        }

        // 2���� �ӽ� ������ ���� ���� ���� ���� ����
        // ��/�� ���� �ݺ������� ����
        for(int i = 0; i < map1.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < map1[i].length; j++){
                // �ش� ��ġ�� �ϳ��� ���̸� ������ ó��
                if(map1[i][j] == 1 || map2[i][j] == 1){
                    sb.append('#');
                }else{ // �� ���� ���� �� ���� ��� ����
                    sb.append(' ');
                }
            }
            // ���� ������ ���� StringBuilder�� answer�� ������ ����
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}