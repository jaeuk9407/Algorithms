package level1.lottoMaxAndLeast;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] prizes = {6, 6, 5, 4, 3, 2, 1}; // ���� ����(index)�� ���� ����(value)
        int zeroCnt = 0;    // ������ ���� ����
        int correct = 0;    // ������ ���� �����ϰ� ���� ����
        int max = 0;    // �ִ� ���
        int least = 0;  // �ּ� ���
        
        for(int myNum : lottos){
            // ������ ��ȣ�� 0�̸� ������ ���� ���纸�� ����
            if(myNum == 0){
                zeroCnt++;
                continue;
            }
            // ��ȣ�� ���� ��ȣ�� ���غ�
            for(int winNum : win_nums){
                if(myNum == winNum){
                    correct++;
                }
            }
        }
        // �ּ� ������ �ִ� ���� �˻� �� ��ȯ
        least = prizes[correct];
        max = prizes[correct+zeroCnt];
        int[] answer = {max, least};
        
        return answer;
    }
}
