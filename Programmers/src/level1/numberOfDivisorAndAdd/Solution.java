package level1.numberOfDivisorAndAdd;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int count = getNumDivisor(i);
            
            // 약수의 개수가 짝수면 더해줌
            if(isEven(count)){
                answer += i;
            }else{ // 약수의 개수가 홀수면 빼줌
                answer -= i;
            }
        }
        return answer;
    }
    // 약수의 개수 카운트 메서드
    public int getNumDivisor(int number){
        int count = 0;
        for(int i = 1; i * i <= number; i++){
            // 루트 number로 나눠떨어지면 약수의 개수는 하나만 증가
            if(i * i == number && number % i == 0){
                count++;
            }else if(number % i == 0){ // 루트값이 아닌 경우는 나눠떨어지면 약수의 개수는 2개씩 증가
                count += 2;
            }
        }
        return count;
    }
    
    // 짝수, 홀수 판별 메서드
    public boolean isEven(int number){
        if(number % 2 == 0){
            return true;
        }
        return false;
    }
}
