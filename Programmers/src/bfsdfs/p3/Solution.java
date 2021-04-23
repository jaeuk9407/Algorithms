package bfsdfs.p3;

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // words �� target �ܾ ������ ��ȯ �Ұ�
        boolean isIn = false;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                isIn = true;
                break;
            }
        }
        if(!isIn){
            return 0;
        }
        
        // words �ȿ� target�� ������ Ž�� ����
        char[] cBegin = begin.toCharArray();
        char[] cTarget = target.toCharArray();
        answer = bfs(cBegin, cTarget, words);
        
        return answer;
    }
    
    // bfs ������� target���� depth�� ã�� ��ȯ�� �Լ�
    public int bfs(char[] begin, char[] target, String[] words){
        // �湮�� �� �ִ� �ܾ����� üũ�� �迭
        boolean[] visited = new boolean[words.length];
        String strTarget = new String(target);
        int result = 0;
        Queue<Info> q = new LinkedList<>();
        
        // charcter �迭�� ��� words �� �ܾ� ��ȯ
        char[][] cWords = new char[words.length][target.length];
        for(int i = 0; i < words.length; i++){
            cWords[i] = words[i].toCharArray();
        }
        
        // �ʱ� begin���� ��ȯ�� ������ �ܾ ã�� ť�� ����
        for(int i = 0; i < words.length; i++){
            if(isPossible(begin, cWords[i])){
                Info word = new Info(1, i, cWords[i]);
                q.add(word);
            }
        }
        
        while(!q.isEmpty()){
            // check in
            Info now = q.poll();
            visited[now.index] = true;
            
            // target�� ���� �ܾ �����ϸ� ����
            String strNow = new String(now.word);
            if(strNow.equals(strTarget)){
                result = now.depth;
                break;
            }
            
            // words ��ȸ
            for(int i = 0; i < cWords.length; i++){
            	// ��ȯ�� �����ϰ�, �湮�� �� ������ ��ȯ 
                if(isPossible(now.word, cWords[i]) && !visited[i]){
                    int nxtDepth = now.depth + 1;
                    int nxtIndex = i;
                    char[] nxtWord = cWords[i];
                    Info nxt = new Info(nxtDepth, nxtIndex, nxtWord);
                    q.add(nxt);
                }
            }
        }
        
        // �̹� �湮�� �ܾ �����ϰ� �� �̻� �湮�� �ܾ ������ 
        // result �� ������Ʈ�� �Ͼ�� �ʾ� 0 ��ȯ
        return result;
        
    } // end of bfs()
    
    // ��ȯ ���� ���� �˻� �޼���
    // ���縵 �ϳ��� ���̳��ٸ� ���� 
    public boolean isPossible(char[] start, char[] end){
        int count = 0; // ���縵 ���� ���� count
        int length = start.length;  // �ܾ� ����
        
        for(int i = 0; i < length; i++){
            if(start[i] != end[i]){
                count++;
            }
        }
        // ���縵 ���̰� 1����� true, �ƴ϶�� false ��ȯ
        if(count == 1){
            return true;
        }else{
            return false;
        }
    }   // end of isPossible()
}

class Info{
    int depth, index;
    char[] word;
    
    public Info(int depth, int index, char[] word){
        this.depth = depth;
        this.index = index;
        this.word = word;
    }
}