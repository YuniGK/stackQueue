package stack;

import java.util.Scanner;

public class IntStackTster {
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		IntStack s = new IntStack(64);
		
		while (true) {
			System.out.printf("현재 데이터 수 %d / %d \n",s.size(), s.capacity());
			
			System.out.println("1.푸시 2.팝 3.피크 4.덤프 0.종료");
			
			int menu = scanner.nextInt();
			
			if (menu == 0) break;
			
			int x;
			
			switch (menu) {
			case 1:
				System.out.println("데이터를 입력하세요.");
				x = scanner.nextInt();
				
				// IntStack에서 push(int x)정의 시, throws 작성으로
				// 예외처리는 push()를 호출한 곳에서 처리한다.
				try {
					s.push(x);
				} catch (IntStack.OvrflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				
				break;

			case 2:
				try {
					x = s.pop();
					System.out.printf("팝한 데이터는 %d입니다. \n", x);
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				
				break;
				
			case 3:
				try {
					x = s.peek();
					System.out.printf("피크한 데이터는 %d입니다. \n", x);
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				
				break;

			case 4:
				s.dump();
				
				break;
			}
		
		}
		
		System.out.println("-- 종료 --");
		
	}//main

}
