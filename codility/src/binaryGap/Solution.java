package binaryGap;

class Solution {
    public int solution(int N) {
    	// Binary Representation of N
        String binaryString = Integer.toBinaryString(N);
        int length = 0;
        // indices of value 1
        int front = -1;
        int rear = -1;
        
        for(int i = 0; i < binaryString.length(); i++){
        	// if meet value 1
            if(binaryString.charAt(i) == '1'){
            	// set front index
                if(front == -1){
                    front = i;
                }else{	// set rear index and calc length and re-initializing indices
                    rear = i;
                    length = Math.max(length, rear - front - 1);
                    front = rear;
                    rear = -1;
                }
            }
        }
        return length;
    }
}
