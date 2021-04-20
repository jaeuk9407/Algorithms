package hash.p4;

import java.util.*;
import java.util.Map.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, GenresInfo> hm = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            // ���� �߰����� ���� �帣�� ���� ���� �ʿ� �߰�
            if(!hm.containsKey(genres[i])){
                // ���ο� GenresInfo ��ü ����(�뷡 ���� ����)
            	hm.put(genres[i], new GenresInfo(plays[i], new ArrayList<SongInfo>()));
                // ���� ������ �帣 ������ ���� ���� ���� �Է� 
            	hm.get(genres[i]).songInfoList.add(new SongInfo(i, plays[i]));
            
            }else{ // �̹� �����ϴ� �帣�� ���
                GenresInfo genre = hm.get(genres[i]);
                // �� ��ȸ�� �߰�
                genre.totalPlays += plays[i];
                // �뷡���� �߰�
                genre.songInfoList.add(new SongInfo(i, plays[i]));
            }
        }
        
        // �帣 ������ �迭 ���·� ��ȯ
        GenresInfo[] genresInfoList = new GenresInfo[hm.size()];
        int k = 0;
        for(Entry<String, GenresInfo> entry : hm.entrySet()){
            genresInfoList[k++] = entry.getValue();
            // �� �帣���� �뷡 ����Ʈ ���� 
            entry.getValue().songInfoList.sort(new SongInfoListSort());
        }

        
        // �� �帣�� ���� �뷡 ����Ʈ�� ��ȸ�� ���� ����
        Arrays.sort(genresInfoList);
        List<Integer> result = new ArrayList<>();
        
        // �� �帣���� �ִ� 2���� ��� ����Ʈ�� ����
        for(GenresInfo g : genresInfoList){
            List<SongInfo> list = g.songInfoList;
            int size = list.size();
            // ���� �帣�� ���� 1���� ���
            if(size == 1){
                result.add(list.get(0).index);
            }else{  // 2�� �̻��� ���
                for(int i = 0; i < 2; i++){
                    result.add(list.get(i).index);
                }
            }
        }
        // ��� ����Ʈ�� answer[]�� ��� ��ȯ
        int resultSize = result.size();
        int[] answer = new int[resultSize];
        
        for(int i = 0; i < resultSize; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}

// �帣 ����
class GenresInfo implements Comparable<GenresInfo>{
    // �� ��ȸ��
    int totalPlays;
    // �ش� �帣 �� ����Ʈ
    List<SongInfo> songInfoList;
    
    public GenresInfo(int totalPlays, List<SongInfo> songInfoList){
        this.totalPlays = totalPlays;
        this.songInfoList = songInfoList;
    }
    
    @Override
    public int compareTo(GenresInfo o){
        // �� ��ȸ�� ������������ ����
        if(this.totalPlays < o.totalPlays){
            return 1;
        }
        return -1;
    }
}

// �� ����
class SongInfo{
    // ���� ��ȣ, ��ȸ��
    int index, play;
    
    public SongInfo(int index, int play){
        this.index = index;
        this.play = play;
    }
}

// �� ���� ���
class SongInfoListSort implements Comparator<SongInfo>{
    @Override
    public int compare(SongInfo o1, SongInfo o2){
        // ��ȸ�� ���� ��������, ���� ��� ������ȣ ���� ��������
        if(o1.play < o2.play || (o1.play == o2.play) && o1.index > o2.index){
            return 1;
        }
        return -1;
    }
}
