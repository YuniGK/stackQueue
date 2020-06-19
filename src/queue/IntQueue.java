package queue;

public class IntQueue {
	//큐의 용량
	private int max;
	
	//첫번째 요소 커서
	private int front;
	
	//마지막요소 커서
	private int rear;

	//현재 데이터 수
	private int num;
	
	//큐 본체
	private int[] que;
	
	// ------------------------- //
	
	//실행 시 예외 - 큐가 비어있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {};
	}
	
	//실행 시 예외 - 큐가 가득참
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
			//큐 배열 생성
			que = new int [max];
		} catch (Exception e) {
			//생성할 수없음
			max = 0;
		}
	}
	
	// ------------------------- //
	
	//큐에 데이터를 인큐
	public int enque(int x) throws OverfowIntQueueException{
		//큐가 가득참
		if (num >= max)
			throw new OverfowIntQueueException();
		
		que[rear++] = x;
		
		num++;
		
		//마지막을 가리키는 요소가 배열의 용량과 같아질 경우 0으로 초기화
		if (rear == max) 
			rear = 0;
		
		return x;
	}
	
	//큐에서 데이터를 디큐
	public int deque() throws EmptyIntQueueException{
		//큐가 비어있음
		if (num <= 0) 
			throw new EmptyIntQueueException();
		
		int x = que[front++];
		num--;
		
		//처음을 가리키는 요소가 배열의 크기와 같아질 경우 0으로 초기화
		if (front == max)
			front = 0;
		
		return x;
	}
	
	// ------------------------- //
	
	//큐에서 데이터를 피크(프런트 데이터를 본다.)
	public int peek() throws EmptyIntQueueException{
		//큐가 비어있음
		if (num <= 0) 
			throw new EmptyIntQueueException();
		
		return que[front];
	}
	
	//큐에서 x를검색하여 인덱스를 반환
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			
			//검색 성공
			if (que[idx] == x) 
				return idx;
		}
		
		//검색 실패
		return -1;
	}
	
	//큐를 비움
	public void clear() {
		num = front = rear = 0;
	}
	
	//큐의 용량을 반환
	public int capacity() {
		return max;
	}
	
	//큐에 쌓여있는 데이터 수를 반환
	public int size() {
		return num;
	}
	
	//큐가 비어 있는지 여부
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//큐가 가득 차 있는지 여부
	public boolean isFull() {
		return num >= max;
	}
	
	//큐안 모든 데이터 출력
	//프런트 → 리어 순으로 출력
	public void dump() {
		if (num <= 0) 
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++) 
				System.out.println(que[(i + front) % max] + " ");
			System.out.println();
		}
	}

}
