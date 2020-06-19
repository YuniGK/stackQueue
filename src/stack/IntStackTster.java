package stack;

import java.util.Scanner;

public class IntStackTster {
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		IntStack s = new IntStack(64);
		
		while (true) {
			System.out.printf("���� ������ �� %d / %d \n",s.size(), s.capacity());
			
			System.out.println("1.Ǫ�� 2.�� 3.��ũ 4.���� 0.����");
			
			int menu = scanner.nextInt();
			
			if (menu == 0) break;
			
			int x;
			
			switch (menu) {
			case 1:
				System.out.println("�����͸� �Է��ϼ���.");
				x = scanner.nextInt();
				
				// IntStack���� push(int x)���� ��, throws �ۼ�����
				// ����ó���� push()�� ȣ���� ������ ó���Ѵ�.
				try {
					s.push(x);
				} catch (IntStack.OvrflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				
				break;

			case 2:
				try {
					x = s.pop();
					System.out.printf("���� �����ʹ� %d�Դϴ�. \n", x);
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				
				break;
				
			case 3:
				try {
					x = s.peek();
					System.out.printf("��ũ�� �����ʹ� %d�Դϴ�. \n", x);
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				
				break;

			case 4:
				s.dump();
				
				break;
			}
		
		}
		
		System.out.println("-- ���� --");
		
	}//main

}
