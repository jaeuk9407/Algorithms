package hash;

import java.util.HashMap;
import java.util.Map.Entry;


public class Marathon {

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "mislav", "stanko", "mislav", "ana" },
				new String[] { "stanko", "ana", "mislav" }));

	}
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		//participant 배열의 값을 HashMap에 넣어주기
		for (String part : participant) {
			//map.getOrDefault(key, defaultValue): map에 존재하는 key의 개수 return, 없다면 defaultValue return
			//key = 문자열, value = 맵에 존재하는 키의 개수 + 1
			map.put(part, map.getOrDefault(part, 0) + 1);
		}
		//completion 배열의 값을 Hashmap에서 찾아 value를 1씩 감소
		for (String comp : completion) {
			//map.get(key): 맵에 존재하는 키의 개수 return
			map.put(comp, map.get(comp) - 1);
		}
		
		//entrySet(): entry 객체로 구성된 Set을 return
		for (Entry<String, Integer> entry : map.entrySet()) {
			//entry 객체의 value가 1이상이면 해당 entry의 key를 저장
			if (entry.getValue() > 0) {
				answer = entry.getKey();
				break;
			}
		}
		return answer;
	}

}
