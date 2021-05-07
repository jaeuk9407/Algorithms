package kakaoIntern2020.keypad;

import java.util.*;

class Solution {
    static List<Integer>[] list = new ArrayList[13];
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        // ��ư �������� �ʱ�ȭ
        init();
        
        // �ʱ� ���� ��ġ�� *�� #, -> 10, 12�� ����
        int left = 10;
        int right = 12;
        
        // �־��� �Է� ��ư�� ���� �¿� �� �˻� 
        for(int i = 0; i < numbers.length; i++){
        	// 0 ��ư�� 11�� ����
            if(numbers[i] == 0) numbers[i] = 11;
            
            // 1, 4, 7�� �ݵ�� �޼� �Է� 
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                left = numbers[i];
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
            	// 3, 6, 9�� �ݵ�� ������ �Է�
                sb.append("R");
                right = numbers[i];
            }else if(numbers[i] == 2 || numbers[i] == 5 
                     || numbers[i] == 8 || numbers[i] == 11){
            	// 2, 5, 8, 11�� ����� ������ �Է�
                int[] distances = calcDistance(left, right, numbers[i]);
                // ����� �Ÿ��� ���� ��� �� ��� ������ �Է�
                if(distances[0] == distances[1]){
                    if(hand.equals("right")){
                        sb.append("R");
                        right = numbers[i];
                    }else{
                        sb.append("L");
                        left = numbers[i];
                    }
                }else{
                	// ����� �Ÿ��� �ٸ��ٸ� ����� ������ �Է�
                    if(distances[0] < distances[1]){
                        sb.append("L");
                        left = numbers[i];
                    }else{
                        sb.append("R");
                        right = numbers[i];
                    }
                }
            }     
        }
        answer = sb.toString();
        return answer;
    }
    
    
    
    // �ʱ� �������� ���� �ʱ�ȭ
    public void init(){
    	// ��������Ʈ �ʱ�ȭ
        for(int i = 1; i <= 12; i++){
            list[i] = new ArrayList<>();
        }
        
        // �������� ���� 
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 3; j++){
                int value = 3 * (i-1) + j;
                // ���� 4�� ��ư�� �����ϰ� ���� ��ư �̵� ����
                if(value != 1 && value != 4 && value != 7 && value != 10){
                    list[value].add(value-1);
                }
                // ���� 4�� ��ư�� �����ϰ� ���� ��ư �̵� ����
                if(value != 3 && value != 6 && value != 9 && value != 12){
                    list[value].add(value+1);
                }
                // ��� 3�� ��ư�� �����ϰ� ��� ��ư �̵� ����
                if(value != 1 && value != 2 && value != 3){
                    list[value].add(value-3);
                }
                // �ϴ� 3�� ��ư�� �����ϰ� �ϴ� ��ư �̵� ����
                if(value != 10 && value != 11 && value != 12){
                    list[value].add(value+3);
                }
            }
        }
    }
    // �Ÿ���� �޼���(�޼� ��ġ, ������ ��ġ, ���� ��ġ) : bfs
    // return result[0: �޼ձ����� �Ÿ�, 1: ������ ������ �Ÿ�]
    public int[] calcDistance(int left, int right, int target) {
    	// �Ÿ��� ������ �迭
        int[] dists = new int[13];
        // �湮 ���� üũ �迭 -> �ߺ� �湮 ���� 
        boolean[] visited = new boolean[13];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(target);
        visited[target] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            // �湮 ������ ��ư ��ȸ 
            for(int i = 0; i < list[now].size(); i++){
                int nxt = list[now].get(i);
                // �湮���� ���� ��ư�̸� ���� ��ư �Ÿ��� + 1�� ���� �� �湮ó��
                if(!visited[nxt]){
                    q.add(nxt);
                    visited[nxt] = true;
                    dists[nxt] = dists[now]+1;
                }
            }
        }
        
        int[] result = {dists[left], dists[right]};
        return result;
    }
    
}
