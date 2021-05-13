package level1.makingPrimeNumber;

class Solution {
    public int solution(int[] nums) {
        int answer = 0; 
        
        // 세 수의 합
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) answer++;
                }
            }
        }
        
        return answer;
    }
    
    // 소수 판별 메서드
    public boolean isPrime(int num){
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
