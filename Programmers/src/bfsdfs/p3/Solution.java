package bfsdfs.p3;

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // words 중 target 단어가 없으면 변환 불가
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
        
        // words 안에 target이 있으면 탐색 시작
        char[] cBegin = begin.toCharArray();
        char[] cTarget = target.toCharArray();
        answer = bfs(cBegin, cTarget, words);
        
        return answer;
    }
    
    // bfs 방식으로 target까지 depth를 찾고 반환할 함수
    public int bfs(char[] begin, char[] target, String[] words){
        // 방문한 적 있는 단어인지 체크할 배열
        boolean[] visited = new boolean[words.length];
        String strTarget = new String(target);
        int result = 0;
        Queue<Info> q = new LinkedList<>();
        
        // charcter 배열로 모든 words 내 단어 변환
        char[][] cWords = new char[words.length][target.length];
        for(int i = 0; i < words.length; i++){
            cWords[i] = words[i].toCharArray();
        }
        
        // 초기 begin에서 변환이 가능한 단어를 찾아 큐에 삽입
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
            
            // target과 현재 단어가 동일하면 멈춤
            String strNow = new String(now.word);
            if(strNow.equals(strTarget)){
                result = now.depth;
                break;
            }
            
            // words 순회
            for(int i = 0; i < cWords.length; i++){
            	// 변환이 가능하고, 방문한 적 없으면 변환 
                if(isPossible(now.word, cWords[i]) && !visited[i]){
                    int nxtDepth = now.depth + 1;
                    int nxtIndex = i;
                    char[] nxtWord = cWords[i];
                    Info nxt = new Info(nxtDepth, nxtIndex, nxtWord);
                    q.add(nxt);
                }
            }
        }
        
        // 이미 방문한 단어를 제외하고 더 이상 방문할 단어가 없으면 
        // result 값 업데이트가 일어나지 않아 0 반환
        return result;
        
    } // end of bfs()
    
    // 변환 가능 여부 검사 메서드
    // 스펠링 하나만 차이난다면 가능 
    public boolean isPossible(char[] start, char[] end){
        int count = 0; // 스펠링 차이 개수 count
        int length = start.length;  // 단어 길이
        
        for(int i = 0; i < length; i++){
            if(start[i] != end[i]){
                count++;
            }
        }
        // 스펠링 차이가 1개라면 true, 아니라면 false 반환
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