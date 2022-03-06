package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 		10마리의 말들이 경주하는 경마 프로그램 작성하기 
 * 		
 * 		말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 
 * 		이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다. 
 * 		그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다. 
 * 		(Compare인터페이스 구현)
 * 		
 * 		경기 구간은 1~ 50 구간으로 되어 있다. 
 * 		경기가 끝나면 등수 순으로 출력한다. 
 * 			
 * 		경기가 진행 중일 때는 중간 중간에 마들의 위치를 아래와 같이 나타낸다. 
 * 
 *  	예) 
 *  	01번말 : --->------------------------------- 
 *  	02번말 : -->--------------------------------
 *  	03번말 : ---->------------------------------
 *  	...   :	------>---------------------------- 
 *  	10번말 :	------->---------------------------
 */
public class ThreadTest13 {
	public static int result;

	public static void main(String[] args) {
		result = 0;
		// 객체 생성
		Horse[] hor = new Horse[] { new Horse("이정규"), new Horse("김기웅"), new Horse("박태정"), new Horse("오지현"),
				new Horse("스테파니"), new Horse("브루스리"), new Horse("독고정규"), new Horse("제갈지현"), new Horse("선우태정"),
				new Horse("주윤발"), };

		// 경기 시작
		for (int j = 0; j < 10; j++) {
			hor[j].start();
		}
		do {
			// 라인 만들기
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 50; j++) {
					hor[i].line[j] = "-";
				}
				hor[i].line[hor[i].current] = ">";
			}

			// 라인 출력
			for (int i = 0; i < 10; i++) {
				System.out.print(hor[i].name + "\t:");
				for (int j = 0; j < 50; j++) {
					System.out.print(hor[i].line[j]);
				}
				System.out.println();

			}
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		} while (result < 10);
		// 등수 정렬
		Arrays.sort(hor);

		// 등수 출력
		for (Horse hr : hor) {
			System.out.println(hr.rank + "등\t:" + hr.name);
		}
	}

}

class Horse extends Thread implements Comparable<Horse> {
	public String name;
	public int rank;
	public int current;
	public String line[] = new String[50];

	public Horse(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			// 현재위치 입력
			current = i;
			try {
				Thread.sleep((int) (Math.random() * 300 + 200));
			} catch (InterruptedException e) {
			}
		}
		// 등수 입력
		ThreadTest13.result++;
		rank = ThreadTest13.result;
	}

	// 내부 정렬
	@Override
	public int compareTo(Horse o) {
		if (this.rank == o.rank) {
			return 0;
		} else if (this.rank < o.rank) {
			return -1;
		} else {
			return 1;
		}
		// TODO Auto-generated method stub

	}

}
