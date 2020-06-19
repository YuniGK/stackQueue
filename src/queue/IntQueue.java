package queue;

public class IntQueue {
	//ť�� �뷮
	private int max;
	
	//ù��° ��� Ŀ��
	private int front;
	
	//��������� Ŀ��
	private int rear;

	//���� ������ ��
	private int num;
	
	//ť ��ü
	private int[] que;
	
	// ------------------------- //
	
	//���� �� ���� - ť�� �������
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {};
	}
	
	//���� �� ���� - ť�� ������
	public class OverfowIntQueueException extends RuntimeException {
		public OverfowIntQueueException() {}
	}
	
	// ------------------------- //
	
	public IntQueue() {
		
	}
	
	public IntQueue(int capacity) {
		num = front = rear = 0;
		
		max = capacity;
		
		try {
			//ť �迭 ����
			que = new int [max];
		} catch (Exception e) {
			//������ ������
			max = 0;
		}
	}
	
	// ------------------------- //
	
	//ť�� �����͸� ��ť
	public int enque(int x) throws OverfowIntQueueException{
		//ť�� ������
		if (num >= max)
			throw new OverfowIntQueueException();
		
		que[rear++] = x;
		
		num++;
		
		//�������� ����Ű�� ��Ұ� �迭�� �뷮�� ������ ��� 0���� �ʱ�ȭ
		if (rear == max) 
			rear = 0;
		
		return x;
	}
	
	//ť���� �����͸� ��ť
	public int deque() throws EmptyIntQueueException{
		//ť�� �������
		if (num <= 0) 
			throw new EmptyIntQueueException();
		
		int x = que[front++];
		num--;
		
		//ó���� ����Ű�� ��Ұ� �迭�� ũ��� ������ ��� 0���� �ʱ�ȭ
		if (front == max)
			front = 0;
		
		return x;
	}
	
	// ------------------------- //
	
	//ť���� �����͸� ��ũ(����Ʈ �����͸� ����.)
	public int peek() throws EmptyIntQueueException{
		//ť�� �������
		if (num <= 0) 
			throw new EmptyIntQueueException();
		
		return que[front];
	}
	
	//ť���� x���˻��Ͽ� �ε����� ��ȯ
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			
			//�˻� ����
			if (que[idx] == x) 
				return idx;
		}
		
		//�˻� ����
		return -1;
	}
	
	//ť�� ���
	public void clear() {
		num = front = rear = 0;
	}
	
	//ť�� �뷮�� ��ȯ
	public int capacity() {
		return max;
	}
	
	//ť�� �׿��ִ� ������ ���� ��ȯ
	public int size() {
		return num;
	}
	
	//ť�� ��� �ִ��� ����
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//ť�� ���� �� �ִ��� ����
	public boolean isFull() {
		return num >= max;
	}
	
	//ť�� ��� ������ ���
	//����Ʈ �� ���� ������ ���
	public void dump() {
		if (num <= 0) 
			System.out.println("ť�� ��� �ֽ��ϴ�.");
		else {
			for (int i = 0; i < num; i++) 
				System.out.println(que[(i + front) % max] + " ");
			System.out.println();
		}
	}

}
