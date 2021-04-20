package hash.p4;

import java.util.*;
import java.util.Map.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, GenresInfo> hm = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            // 아직 추가되지 않은 장르는 새로 만들어서 맵에 추가
            if(!hm.containsKey(genres[i])){
                // 새로운 GenresInfo 객체 생성(노래 정보 제외)
            	hm.put(genres[i], new GenresInfo(plays[i], new ArrayList<SongInfo>()));
                // 새로 생성한 장르 정보에 현재 곡의 정보 입력 
            	hm.get(genres[i]).songInfoList.add(new SongInfo(i, plays[i]));
            
            }else{ // 이미 존재하는 장르의 경우
                GenresInfo genre = hm.get(genres[i]);
                // 총 조회수 추가
                genre.totalPlays += plays[i];
                // 노래정보 추가
                genre.songInfoList.add(new SongInfo(i, plays[i]));
            }
        }
        
        // 장르 정보를 배열 형태로 변환
        GenresInfo[] genresInfoList = new GenresInfo[hm.size()];
        int k = 0;
        for(Entry<String, GenresInfo> entry : hm.entrySet()){
            genresInfoList[k++] = entry.getValue();
            // 각 장르안의 노래 리스트 정렬 
            entry.getValue().songInfoList.sort(new SongInfoListSort());
        }

        
        // 각 장르가 가진 노래 리스트를 조회수 기준 정렬
        Arrays.sort(genresInfoList);
        List<Integer> result = new ArrayList<>();
        
        // 각 장르에서 최대 2개씩 결과 리스트에 저장
        for(GenresInfo g : genresInfoList){
            List<SongInfo> list = g.songInfoList;
            int size = list.size();
            // 현재 장르의 곡이 1개일 경우
            if(size == 1){
                result.add(list.get(0).index);
            }else{  // 2개 이상일 경우
                for(int i = 0; i < 2; i++){
                    result.add(list.get(i).index);
                }
            }
        }
        // 결과 리스트를 answer[]에 담아 반환
        int resultSize = result.size();
        int[] answer = new int[resultSize];
        
        for(int i = 0; i < resultSize; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}

// 장르 정보
class GenresInfo implements Comparable<GenresInfo>{
    // 총 조회수
    int totalPlays;
    // 해당 장르 곡 리스트
    List<SongInfo> songInfoList;
    
    public GenresInfo(int totalPlays, List<SongInfo> songInfoList){
        this.totalPlays = totalPlays;
        this.songInfoList = songInfoList;
    }
    
    @Override
    public int compareTo(GenresInfo o){
        // 총 조회수 내림차순으로 정렬
        if(this.totalPlays < o.totalPlays){
            return 1;
        }
        return -1;
    }
}

// 곡 정보
class SongInfo{
    // 고유 번호, 조회수
    int index, play;
    
    public SongInfo(int index, int play){
        this.index = index;
        this.play = play;
    }
}

// 곡 정렬 방법
class SongInfoListSort implements Comparator<SongInfo>{
    @Override
    public int compare(SongInfo o1, SongInfo o2){
        // 조회수 기준 내림차순, 같은 경우 고유번호 기준 오름차순
        if(o1.play < o2.play || (o1.play == o2.play) && o1.index > o2.index){
            return 1;
        }
        return -1;
    }
}
