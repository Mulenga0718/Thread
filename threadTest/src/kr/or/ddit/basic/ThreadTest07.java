package kr.or.ddit.basic;
/*
 * 
 * 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오. 
 * 	
 * 	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고, 
 *  사용자의 가위 바위 보는 showInputDialog()을 이용해서 입력 받는다. 
 *  
 *  입력 시간은 5초로 제한하고 카운트 다운을 진행한다. 
 *  5초 안에 입력이 없으면 게임에 진 것으로 처리한다. 
 *  
 *  5초 안에 입력이 있으면 승패를 구해서 출력한다. 
 *  
 *  결과 예시) 
 *  1) 5초안에 입력이 없을 때 
 *  - 결 과 - 
 *  시간 초과로 당신이 졌습니다. 
 *  
 *  2) 5초안에 입력이 있을 때 
 *  - 결 과 - 
 *  컴퓨터 : 가위 
 *  당 신 : 바위
 *  결 과 : 당신이 이겼습니다. 
 * 
 */

import java.util.Random;

import javax.swing.JOptionPane;

public class ThreadTest07 {
	public static boolean inputCheck= false;

	public static void main(String[] args) {
		Random ran = new Random();
		Timer t = new Timer();
		
		//난수를 이용해서 컴퓨터의 가위바위보 정하기 
		String[] data = {"가위","바위","보"};
		int index = ran.nextInt(3);
		String com = data[index];
		
		//사용자의 가위바위보 정하기 
		
		
		t.start();//카운트 다운 시작 
		String user = null;
		do {
		user = JOptionPane.showInputDialog("'가위' '바위' '보'를 입력하세요 > ");
		}while(!(user.equals("가위") || user.equals("바위")|| user.equals("보")));
		inputCheck = true;
	
		//결과 판정하기 
		String result = "";
		int userresult = 0;
		switch (user) {
		case "가위":
			userresult = 0;
			break;
		case "바위":
			userresult = 1;
			break;
		case "보":
			userresult = 2;
			break;
		}
		
		switch ((userresult - index + 3) % 3) {
		case 0:
			result ="비겼습니다.";
			break;
		case 1:
			result ="당신이 이겼습니다.";
			break;
		case 2:
			result ="당신이 졌습니다.";
			break;
		}
		
		System.out.println("- 결과 - ");
		System.out.println("컴퓨터 : " + com);
		System.out.println("당신 : " + user);
		System.out.print("결과: "+ result);
	}
	
	}

class Timer extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			if (ThreadTest07.inputCheck == true) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(i);
				
			
		}System.out.println("- 결과 -");
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
		
	}
}
