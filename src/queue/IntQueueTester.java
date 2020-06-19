package queue;

import java.util.Scanner;

public class IntQueueTester {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		IntQueue s = new IntQueue(64);
		
		while (true) {
			System.out.printf("현재 데이터 수 %d / %d \n", s.size(), s.capacity());
			
			System.out.println("1.인큐 2.디큐 3.피큐 4.덤프 0.종료");
			
			int menu = scanner.nextInt();
			
			if (menu == 0)
				break;
			
			int x;
			
			switch (menu) {
			case 1:
				System.out.println("데이터를 입력하세요.");
				
				x = scanner.nextInt();
				try {
					s.enque(x);
				} catch (IntQueue.OverfowIntQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				
				break;
				
			case 2:
				try {
					x = s.deque();
					
					System.out.println("디큐하 데이터는 "+ x +"입니다.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어있습니다.");
				}	
				
				break;
				
			case 3:
				try {
					x = s.peek();
					
					System.out.println("피크한 데이터는 "+ x +"입니다.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어있습니다.");
				}	
				
				break;	
			
			case 4:
				s.dump();
				
				break;
				
			}
		}
		
		System.out.println("- 종료 -");
		
	}

}
