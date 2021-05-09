package dp.p3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] regions = new int[n + 1][m + 1];
        
        // 웅덩이를 -1로 처리
        for(int[] puddle : puddles){
            regions[puddle[1]][puddle[0]] = -1;
        }
        
        // 출발지는 임시로 1로 설정 
        regions[1][1] = 1;
        
        // 출발지로부터의 최단거리 구하기
        for(int i = 1; i <= n ;i++){
            for(int j = 1; j <= m; j++){
                // 웅덩이가 있는 위치는 0으로 바꿔주고 다음 위치 고려 
                if(regions[i][j] == -1){
                    regions[i][j] = 0;
                    continue;
                }
                
                // 첫 번째 행이 아니라면 이전 행의 최단거리만큼 더해줌
                if(i != 1){
                    regions[i][j] += regions[i - 1][j] % 1000000007;
                }
                // 첫 번째 열이 아니라면 이전 열의 최단거리만큼 더해줌
                if(j != 1){
                    regions[i][j] += regions[i][j - 1] % 1000000007;
                }
            }
        }
        
        return regions[n][m] % 1000000007;
    }  
    @Test
    public void 정답(){
      Assert.assertEquals(4, solution(4, 3, new int[][]{{2,2}}));
      Assert.assertEquals(7, solution(4, 4, new int[][]{{3,2}, {2,4}}));
      Assert.assertEquals(7, solution(5, 3, new int[][]{{4,2}}));
      Assert.assertEquals(0, solution(2, 2, new int[][]{{2,1}, {1, 2}}));
      Assert.assertEquals(0, solution(3, 1, new int[][]{{2,1}}));

    }
}