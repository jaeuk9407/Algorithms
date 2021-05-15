package level1.failureRate;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        // 1. 스테이지별 도달한 사람 수와 도달했지만 통과하지 못한 사람 수를 카운트
        int[] go = new int[N + 1];
        int[] notClear = new int[N + 1];
        
        for(int i = 0; i < stages.length; i++){
            for(int j = 1; j <= stages[i]; j++){
                // 마지막 스테이지까지만 계산
                if(j == N + 1){
                    break;
                }
                // 1부터 해당 스테이지까지 도달은 했으므로 도달값 update
                go[j] += 1;
                
                if(j == stages[i]){ // 해당 스테이지를 clear하지는 못했으므로 notClear값 업데이트
                    notClear[j] += 1;
                }
            }            
        }
        // 2. 실패율을 구하고, 실패율을 기준으로 스테이지를 정렬
        ArrayList<Stage> list = new ArrayList<>();
        for(int i = 1; i < N + 1; i++){
            // 마지막 스테이지까지
            if(i < N + 1){
                // 도달한 유저가 없는 경우 실패율 0인 스테이지
                if(go[i] == 0){
                    list.add(new Stage(i, 0.0));
                }else{
                    list.add(new Stage(i, (double)notClear[i] / go[i]));
                }
            }
        }
        // 각 스테이지를 실패율 기준 내림차순 정렬(실패율 같다면 id 오름차순)
        Collections.sort(list);
        
        // 결과 리스트 배열에 id값만 복사
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
