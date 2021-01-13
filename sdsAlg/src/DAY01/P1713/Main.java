package DAY01.P1713;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int R;
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> counts = new HashMap<>();
		N = sc.nextInt();
		R = sc.nextInt();
		
		// 액자 수 초기화
		List<Person> frames = new ArrayList<Person>(); 
		
		// i: 투표 index, t: 추천 대상자 번호
		for(int i =0; i<R; i++) {
			int t = Integer.parseInt(sc.next());
			
			// 해당 후보자의 정보 입력
			Person person = new Person();
			person.setNum(t);
			person.setTimeStamp(i);
			
			// 액자 안에 해당 후보자가 있는 경우
			// 해당 후보자를 추천 받은 적이 있는 경우 -> counts의 해당 후보 count+1, person과 counts에 저장
			if(counts.get(t) != null) {
				int count = counts.get(t);
				
				// 해당 후보자를 frames에서 찾아 count update
				for(int j = 0; j < frames.size(); j++) {
					if(frames.get(j).num == t) {
						Person updatePerson = frames.get(j);
						updatePerson.setCount(count+1);
					}
				}
				
				counts.replace(t, count+1);
			}else {
				// 액자 안에 해당 후보자가 없는 경우 
				// 해당 후보자를 추천 받은 적이 없는 경우 -> count = 1을 person과 counts에 저장  
				person.setCount(1);
				counts.put(t, 1);
				
				// 액자가 꽉 찬 경우
				if(frames.size() == N) {
					// count, timeStamp 기준 오름차순 정렬
					Collections.sort(frames, new Comparator<Person>() {
						@Override
						public int compare(Person o1, Person o2) {
							if(o1.count < o2.count) {
								return -1;
							}else if(o1.count == o2.count) {
								if(o1.timeStamp < o2.timeStamp) {
									return -1;
								}else {
									return 1;
								}
							}else {
								return 1;
							}
						}
					});
					
					// 가장 앞에 있는 후보 제거 -> frames, counts & 새로운 후보 삽입
					Person removePerson = (Person) frames.get(0);

					counts.remove(removePerson.num);
					frames.remove(0);
					frames.add(person);					
					
				}else {
					// 액자가 꽉차지 않은 경우
					frames.add(person);
				}
			}
			
			
		} // End of All votes
		sc.close();
		Collections.sort(frames, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.num < o2.num) {
					return -1;
				}else if(o1.num == o2.num) {
					return -1;
				}else {
					return 1;
				}
			}
		});
		
		for(int i = 0; i < frames.size(); i++) {
			System.out.print(frames.get(i).num);
			if(i != frames.size()-1) {
				System.out.print(" ");
			}
		}

	}

}

class Person {
	int num;
	int count;
	int timeStamp;
	
	
	
	public Person() {
		super();
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public int getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}



	public Person(int num, int count, int timeStamp) {
		super();
		this.num = num;
		this.count = count;
		this.timeStamp = timeStamp;
	}
	
	
}
