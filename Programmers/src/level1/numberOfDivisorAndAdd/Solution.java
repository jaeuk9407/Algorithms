package level1.numberOfDivisorAndAdd;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int count = getNumDivisor(i);
            
            // ����� ������ ¦���� ������
            if(isEven(count)){
                answer += i;
            }else{ // ����� ������ Ȧ���� ����
                answer -= i;
            }
        }
        return answer;
    }
    // ����� ���� ī��Ʈ �޼���
    public int getNumDivisor(int number){
        int count = 0;
        for(int i = 1; i * i <= number; i++){
            // ��Ʈ number�� ������������ ����� ������ �ϳ��� ����
            if(i * i == number && number % i == 0){
                count++;
            }else if(number % i == 0){ // ��Ʈ���� �ƴ� ���� ������������ ����� ������ 2���� ����
                count += 2;
            }
        }
        return count;
    }
    
    // ¦��, Ȧ�� �Ǻ� �޼���
    public boolean isEven(int number){
        if(number % 2 == 0){
            return true;
        }
        return false;
    }
}
