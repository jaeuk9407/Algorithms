package dp.p3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] regions = new int[n + 1][m + 1];
        
        // �����̸� -1�� ó��
        for(int[] puddle : puddles){
            regions[puddle[1]][puddle[0]] = -1;
        }
        
        // ������� �ӽ÷� 1�� ���� 
        regions[1][1] = 1;
        
        // ������κ����� �ִܰŸ� ���ϱ�
        for(int i = 1; i <= n ;i++){
            for(int j = 1; j <= m; j++){
                // �����̰� �ִ� ��ġ�� 0���� �ٲ��ְ� ���� ��ġ ��� 
                if(regions[i][j] == -1){
                    regions[i][j] = 0;
                    continue;
                }
                
                // ù ��° ���� �ƴ϶�� ���� ���� �ִܰŸ���ŭ ������
                if(i != 1){
                    regions[i][j] += regions[i - 1][j] % 1000000007;
                }
                // ù ��° ���� �ƴ϶�� ���� ���� �ִܰŸ���ŭ ������
                if(j != 1){
                    regions[i][j] += regions[i][j - 1] % 1000000007;
                }
            }
        }
        
        return regions[n][m] % 1000000007;
    }  
    @Test
    public void ����(){
      Assert.assertEquals(4, solution(4, 3, new int[][]{{2,2}}));
      Assert.assertEquals(7, solution(4, 4, new int[][]{{3,2}, {2,4}}));
      Assert.assertEquals(7, solution(5, 3, new int[][]{{4,2}}));
      Assert.assertEquals(0, solution(2, 2, new int[][]{{2,1}, {1, 2}}));
      Assert.assertEquals(0, solution(3, 1, new int[][]{{2,1}}));

    }
}