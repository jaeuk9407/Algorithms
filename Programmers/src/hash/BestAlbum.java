package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class BestAlbum {
	
	class Solution {
	    public int[] solution(String[] genres, int[] plays) {

	    	// key(장르이름) + value(총조회수 + 노래 조회수, 인덱스 정보)
	    	HashMap<String,GenresInfo> map = new HashMap<>();
	    	
	    	for(int i=0; i<genres.length; i++) {
	    		
	    		// 아직 추가되지 않은 장르는 새로 만들어서 맵에 추가 
	    		if(!map.containsKey(genres[i])) {
	    			//새로운 GenresInfo 객체 생성(노래정보 제외)
	    			map.put(genres[i], new GenresInfo(plays[i], new ArrayList<SongInfo>()));
	    			
	    			//현재 순서의 노래 정보 추가(조회수, 고유번호)
	    			map.get(genres[i]).getSongInfoList().add(new SongInfo(plays[i],i));
	    			
	    		// 이미 존재하는 장르의 경우
	    		}else {
	    			// 총 조회수 증가
		    		GenresInfo temp = map.get(genres[i]);
		    		temp.setTotalPlays(temp.getTotalPlays()+plays[i]);
	    			
	    			// 노래 정보 추가
		    		temp.getSongInfoList().add(new SongInfo(plays[i],i));
	    		}
	    	}
	    	
	    	//장르 정보를 배열로 바꾸고, 동시에 각 장르가 가진 노래 리스트를 조회수로 정렬
	    	GenresInfo[] genresInfoList = new GenresInfo[map.size()];
	    	int k =0;
	    	for(Entry<String, GenresInfo> e:map.entrySet()) {
	    		genresInfoList[k++] = e.getValue();
	    		
	    		//각 장르안의 노래 리스트 정렬 
	    		e.getValue().getSongInfoList().sort(new SongInfoListSort());
	    	}
	    	
	    	// 장르 배열 정렬 및 각 장르 안의 노래 정보 리스트에서 최대 2개까지 인덱스 정보를 가져오기 
	    	Arrays.sort(genresInfoList);
	    	List<Integer> result = new ArrayList<>();
	    	for(GenresInfo g : genresInfoList) {
	    		List<SongInfo> list = g.getSongInfoList();
	    		int size = list.size();
	    		
	    		// 1개일 경우 
	    		if(size ==1) {
	    			result.add(list.get(0).getIndex());
	    		}else {
	    			for(int i=0; i<2; i++) {
	    				result.add(list.get(i).getIndex());
	    			}
	    		}
	    	}
	    	int resultSize = result.size();
	        int[] answer = new int[resultSize];
	        for(int i=0; i<resultSize; i++) {
	        	answer[i] = result.get(i);
	        }
	        return answer;
	        
	    }
	    
	}
	

	/* 장르별 정보 */
	class GenresInfo implements Comparable<GenresInfo>{
		
		private int totalPlays; //총 조회수
		private List<SongInfo> songInfoList; //장르에 속한 노래 정보 리스트
		
		
		public GenresInfo(int totalPlays, List<SongInfo> songInfoList) {
			super();
			this.totalPlays = totalPlays;
			this.songInfoList = songInfoList;
		}
		//정렬
		@Override
		public int compareTo(GenresInfo o) {
			
			//총 조회수 내림차순
			if(this.totalPlays < o.totalPlays) {
				return 1;
			}
			return -1;
		}
		
		public int getTotalPlays() {
			return totalPlays;
		}
		public void setTotalPlays(int totalPlays) {
			this.totalPlays = totalPlays;
		}
		public List<SongInfo> getSongInfoList() {
			return songInfoList;
		}
		public void setSongInfoList(List<SongInfo> songInfoList) {
			this.songInfoList = songInfoList;
		}
		
		
		
	}
	/* 개별 노래 정보 */
	class SongInfo {
		private int plays; //조회수
		private int index; //인덱스
		
		public SongInfo(int plays, int index) {
			super();
			this.plays = plays;
			this.index = index;
		}
		public int getPlays() {
			return plays;
		}
		public void setPlays(int plays) {
			this.plays = plays;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		
		
	}
	
	class SongInfoListSort implements Comparator<SongInfo>{

		@Override
		public int compare(SongInfo o1, SongInfo o2) {
			
			// 조회수 기준 내림차순 정렬, 같은 경우 고유번호 기준 오름차순 정렬
			if(o1.getPlays() < o2.getPlays()
					|| (o1.getPlays() == o2.getPlays()
					&& o1.getIndex() > o2.getIndex())) {
				return 1;
			}
			return -1;
		}
		
	}
	
}