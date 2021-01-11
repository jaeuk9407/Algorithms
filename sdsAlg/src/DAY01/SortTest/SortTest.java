package DAY01.SortTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1, 2, 1));
		list.add(new Person(2, 3, 2));
		list.add(new Person(3, 1, 3));
		
		System.out.println(list);
		
//		list.sort(new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				// -1 = 내가 원하는 순서 = 바꾸지 않음
//				if(o1.count < o2.count) {
//					return -1;
//				}
//				// 0 = 같은값 = 바꾸지 않음
//				if(o1.count == o2.count) {
//					return -1;
//				}
//				// 1 = 내가 원하는 순서가 아님 = 바꿈 
//				else {
//					return 1;
//				}
//			}
//			
//		});
//		list.sort();
		Collections.sort(list);
		System.out.println(list);
		// Comparable 객체의 정렬 조건이 고정적일 때 -> Comparable를 자주 사용
		// Comparable 객체의 정렬 조건이 다양할 때 -> Comparator를 자주 사용
		
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// -1 = 내가 원하는 순서 = 바꾸지 않음
				if(o1.timeStamp < o2.timeStamp) {
					return -1;
				}
				// 0 = 같은값 = 바꾸지 않음
				if(o1.timeStamp == o2.timeStamp) {
					return -1;
				}
				// 1 = 내가 원하는 순서가 아님 = 바꿈 
				else {
					return 1;
				}
			}
			
		});
	}
}
class Person implements Comparable<Person>{
	int num;
	int count;
	int timeStamp;
	public Person(int num, int count, int timeStamp) {
		super();
		this.num = num;
		this.count = count;
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "Person [num=" + num + ", count=" + count + ", timeStamp=" + timeStamp + "]";
	}
	@Override
	public int compareTo(Person o) {
		// -1 = 내가 원하는 순서 = 바꾸지 않음
		if(this.count < o.count) {
			return -1;
		}
		// 0 = 같은값 = 바꾸지 않음
		if(this.count == o.count) {
			// count가 같은 경우 timeStamp로 한 번 더 정렬 
			if(this.timeStamp < o.timeStamp) { // -1
				return -1;
			}else if(this.timeStamp == o.timeStamp) { // 0
				return 0;
			}else { // 1
				return 1;
			}
				
		}
		// 1 = 내가 원하는 순서가 아님 = 바꿈 
		else {
			return 1;
		}
	}
	
}