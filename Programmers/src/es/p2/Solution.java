package es.p2;

import java.util.*;

class Solution {
    static int answer = 0;
    // numbers�� �� ��° �ε��� ���ڸ� ���� �ִ��� üũ�ϴ� �迭
    static boolean[] check = new boolean[7];
    // numbers�� ���� ������ ������ ArrayList
    static ArrayList<Integer> arr = new ArrayList<>();
    
    
    public int solution(String numbers) {        
        String temp = "";
        
        // ���� �� �ִ� ��� ���� ���� ����
        for(int i = 1; i <= numbers.length(); i++){
            rec(numbers, temp, i);
        }
        
        // ��� ���� ���� case�� �Ҽ����� �Ǻ�
        for(int number : arr){
            cal(number);
        }
        
        return answer;
    }
    
    // arr�� ����ִ� ���� �Ҽ����� �Ǻ�
    public static void cal(int n){
        if(n == 0) return;
        if(n == 1) return;
        
        // n�� �Ҽ����� �Ǻ��� �� ��Ʈ n������ �˻��غ��� ��
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return;
        }
        // ��� ������������ ������ �Ҽ��̹Ƿ� answer ����
        answer++;
    }
    
    
    // 1~n�ڸ� ������ �����ϱ� ���� ��� �޼���
    // n: �־��� ���ڿ�, temp: ���� �������� ������ ����, len: ����� �ִ� ���� ����
    public static void rec(String n, String temp, int len){
        // ���� ����: ���� ����� �ִ� �ڸ���
        if(temp.length() == len){
            // �̹� ����ִ� ���̸� �������� ����(e.g. 000 -> 0)
            if(!arr.contains(Integer.parseInt(temp))) arr.add(Integer.parseInt(temp));
            return;
        }
        
        // n���� ���޹��� numbers�� Ž��
        for(int i = 0; i < n.length(); i++){
            // �̹� ������ �ε����� pass
            if(check[i]) continue;
            // �ӽ� ���ڿ��� temp�� ���ڸ� �ٿ������� ���ڸ� ����
            temp += n.charAt(i);
            check[i] = true;
            // ���� �ε��� ���ڸ� ���� ���·� ��� ȣ��
            rec(n, temp, len);
            // ������ ������ �ٽ� ���õ� �� �ֵ��� �湮 ó�� false
            check[i] = false;
            // �ӽ� ���ڿ������� ���� ���ڸ� ����
            temp = temp.substring(0, temp.length()-1);
        }
    }
}
