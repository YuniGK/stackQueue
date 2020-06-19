package stack;

public class IntStack {
	//���� LIFO(��������)
	
	//���� �뷮
	private int max;
	//���� ����Ʈ
	private int ptr;
	//���� ��ü
	private int[] stk;
	
	// ------------------------- //
	
	//���� �� ���� - ������ ��� ����
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {
			
		}
	}
	
	//���� �� ���� - ������ ������
	public class OvrflowIntStackException extends RuntimeException{
		public OvrflowIntStackException() {}
	}
	
	// ------------------------- //
	
	public IntStack() {
		
	}
	
	IntStack(int capacity){
		ptr = 0;
		max = capacity;
		
		try {
			//���� ��ü�� �迭�� ����
			stk = new int[max];
		} catch (Exception e) {
			//������ �� ����.
			max= 0;
		}
	}
	
	// ------------------------- //
	
	/*
	throws - ���� �߻� �� ��� �ڽ��� ȣ���� �޼ҵ忡�� ó���ȴ�.
	throw - ���� ���� �߻� 
	*/
	
	//���ÿ� x�� �ִ´�.
	public int push(int x) throws OvrflowIntStackException{
		//������ ���� ��
		if (ptr >= max) 
			throw new OvrflowIntStackException();
		
		return stk[ptr++] = x;
	}
	
	//���ÿ��� �����͸� ��(����_�������� ���� �����͸� ������.)
	public int pop() throws EmptyIntStackException{
		//������ ����ִ�.
		if (ptr<=0) 
			throw new EmptyIntStackException();
		
		return stk[--ptr];
	}
	
	//���ÿ��� �����͸� ��ũ(���� ������ �ִ��� Ȯ��)
	public int peek() throws EmptyIntStackException{
		//������ ����ִ�.
		if (ptr<=0) 
			throw new EmptyIntStackException();
		
		return stk[ptr-1];
	}
	
	// ------------------------- //
	
	//���ÿ��� x�� ã�� �ε����� ��ȯ / ���� ��� -1�� ��ȯ
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x) return i;
		}
		
		return -1;
	}
	
	//������ ���
	public void clear() {
		ptr = 0;
	}
	
	//������ �뷮�� ��ȯ
	public int capacity() {
		return max;
	}
	
	//���ÿ� �׿� �ִ� ������ ���� ��ȯ
	public int size() {
		return ptr;
	}
	
	//������ ����ִ��� Ȯ��
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	//������ ���� á�°�?
	public boolean isFull() {
		return ptr >= max;
	}
	
	//���� ���� ��� �����͸� �ٴں��� ���
	//�����͸� �־��� ������� ���
	public void dump() {
		if (ptr<=0) 
			System.out.println("������ ����ֽ��ϴ�.");
		else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i]+" ");
			}
			System.out.println();
		}
	}

}
