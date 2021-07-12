package level1.제일작은수제거하기;

class Solution {
    public int[] solution(int[] arr) {
        int min_value = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = 0; i < arr.length; i++){
            if(min_value > arr[i]){
                min_value = arr[i];
                min_index = i;
            }
        }
        int[] answer = new int[arr.length - 1];
        for(int i = 0; i < min_index; i++){
            answer[i] = arr[i];
        }
        for(int i = min_index + 1; i < arr.length; i++){
            answer[i - 1] = arr[i];
        }
        if(answer.length == 0) return new int[] {-1};
        return answer;
    }
}
