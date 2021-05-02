package greedy.p2;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int exp = name.length() - 1;
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            // 상하 방향중 가까운 방향으로 이동
            answer += ('Z'- c + 1) > c - 'A' ? c - 'A' : ('Z' - c + 1);
            // 현재 A이면 다음 연속된 A가 있는지 확인
            if(c == 'A'){
                int nextIdx = i + 1;
                int countA = 0;
                
                // 연속된 A 카운트
                while (nextIdx < name.length() &&
                       name.charAt(nextIdx) == 'A'){
                    countA ++;
                    nextIdx++;
                }
                // 지나온 만큼 다시 되돌아가는 거리: (i-1)*2
                // 연속된 A가 끝난 마지막 인덱스까지 name의 뒤에서부터 거리 (name.length() -1 -i - countA)
                int tmp = (i-1)*2 + (name.length() -1 -i - countA) ;
                // 앞에서부터 순차적으로 탐색하는 거리와 A를 만나 되돌아 가는 거리를 비교
                // 더 작은 거리를 갖는 방법을 채택
                if(exp > tmp) exp = tmp;
            }
        }

        answer += exp;
        return answer;
    }
}