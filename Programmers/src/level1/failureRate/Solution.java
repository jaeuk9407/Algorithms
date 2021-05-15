package level1.failureRate;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        // 1. ���������� ������ ��� ���� ���������� ������� ���� ��� ���� ī��Ʈ
        int[] go = new int[N + 1];
        int[] notClear = new int[N + 1];
        
        for(int i = 0; i < stages.length; i++){
            for(int j = 1; j <= stages[i]; j++){
                // ������ �������������� ���
                if(j == N + 1){
                    break;
                }
                // 1���� �ش� ������������ ������ �����Ƿ� ���ް� update
                go[j] += 1;
                
                if(j == stages[i]){ // �ش� ���������� clear������ �������Ƿ� notClear�� ������Ʈ
                    notClear[j] += 1;
                }
            }            
        }
        // 2. �������� ���ϰ�, �������� �������� ���������� ����
        ArrayList<Stage> list = new ArrayList<>();
        for(int i = 1; i < N + 1; i++){
            // ������ ������������
            if(i < N + 1){
                // ������ ������ ���� ��� ������ 0�� ��������
                if(go[i] == 0){
                    list.add(new Stage(i, 0.0));
                }else{
                    list.add(new Stage(i, (double)notClear[i] / go[i]));
                }
            }
        }
        // �� ���������� ������ ���� �������� ����(������ ���ٸ� id ��������)
        Collections.sort(list);
        
        // ��� ����Ʈ �迭�� id���� ����
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).id;
        }
        
        return answer;
    }
}
class Stage implements Comparable<Stage>{
    int id;
    double failureRate;
    
    public Stage (int id, double failureRate){
        this.id = id;
        this.failureRate = failureRate;
    }
    
    @Override
    public int compareTo(Stage o){
        if(this.failureRate > o.failureRate){
            return -1;
        }else if(this.failureRate == o.failureRate){
            if(this.id < o.id){
                return -1;
            }else if (this.id == o.id){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}
