package DAY01.P1713;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainSolution {
	
	static int N, K;
	static int[] inputs;
	static Student[] students;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		
		// 액자
		List<Student> list = new ArrayList<>();
		// 학생의 범위는 1번부터 100번까지
		students = new Student[101];
		
		for(int i= 0; i < K; i++) {
			int num = sc.nextInt();
			if(students[num] == null) {
				students[num] = new Student(num, 0, 0, false);
			}
			if(students[num].inIt == true) {
				students[num].count++;
			}else {
				// 액자의 사이즈가 꽉 찬 경우 
				if(list.size() == N) {
					Collections.sort(list);
					Student p = list.remove(0);
					p.count = 0;
					p.inIt = false;
				}
				students[num].count = 1;
				students[num].inIt = true;
				students[num].timeStamp = i;
				list.add(students[num]);
			}
		}
	
		sc.close();
		
		// 출력 전, 번호순으로 정렬
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.num < o2.num) {
					return -1;
				}else if (o1.num == o2.num) {
					return 0;
				}else {
					return 1;
				}
			}
		});
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).num+" ");
		}
	}
}

class Student implements Comparable<Student>{
	int num;
	int count;
	int timeStamp;
	boolean inIt; // 지금 액자에 있는지 여부
	



	public Student(int num, int count, int timeStamp, boolean inIt) {
		super();
		this.num = num;
		this.count = count;
		this.timeStamp = timeStamp;
		this.inIt = inIt;
	}


	@Override
	public int compareTo(Student o) {
		int r1 = Integer.compare(count,  o.count);
		if(r1 == 0) {
			return Integer.compare(timeStamp, o.timeStamp);
		}else {
			return r1;
		}
	}


	@Override
	public String toString() {
		return "Student [num=" + num + ", count=" + count + ", timeStamp=" + timeStamp + ", inIt=" + inIt + "]";
	}
}