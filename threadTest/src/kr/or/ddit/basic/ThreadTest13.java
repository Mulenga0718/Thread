package kr.or.ddit.basic;
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
		result =0;
		Horse[] hor = new Horse[] {
				new Horse("이정규"),new Horse("김기웅"),new Horse("박태정"), new Horse("오지현"),
				new Horse("스테파니"), new Horse("브루스리"), new Horse("독고정규"), new Horse("제갈지현"),
				new Horse("선우태정"), new Horse("웅이~"),
		};
			
			for(int j=0; j<10; j++) {
				hor[j].start();
			}
			while(result >9); {
				String line = "--------------------------------------------------";
				System.out.println(hor[0].name+line.replace(0, 0));
			
			
		}
		
	}
}
class Horse extends Thread{
	public String name;
	public int rank;
	public int current;
	
	
	public Horse(String name) {
		super();
		this.name = name;
	}
	@Override
		public void run() {
		for(int i=1; i<=50; i++) {
			current = i;
			try {
				Thread.sleep((int)(Math.random()*300+200));
			} catch (InterruptedException  e) {
			}
		}
		++ThreadTest13.result ;
			
		}
	
	
}
