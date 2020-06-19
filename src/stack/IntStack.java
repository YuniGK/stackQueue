package stack;

public class IntStack {
	//스택 LIFO(선입후출)
	
	//스택 용량
	private int max;
	//스택 포인트
	private int ptr;
	//스택 본체
	private int[] stk;
	
	// ------------------------- //
	
	//실행 시 예외 - 스택이 비어 있음
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {
			
		}
	}
	
	//실행 시 예외 - 스택이 가득참
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
			//스택 본체용 배열을 생성
			stk = new int[max];
		} catch (Exception e) {
			//생성할 수 없다.
			max= 0;
		}
	}
	
	// ------------------------- //
	
	/*
	throws - 예외 발생 될 경우 자신을 호출한 메소드에서 처리된다.
	throw - 강제 예외 발생 
	*/
	
	//스택에 x를 넣는다.
	public int push(int x) throws OvrflowIntStackException{
		//스택이 가득 참
		if (ptr >= max) 
			throw new OvrflowIntStackException();
		
		return stk[ptr++] = x;
	}
	
	//스택에서 데이터를 팝(정상_마지막에 넣은 데이터를 꺼낸다.)
	public int pop() throws EmptyIntStackException{
		//스택이 비어있다.
		if (ptr<=0) 
			throw new EmptyIntStackException();
		
		return stk[--ptr];
	}
	
	//스택에서 데이터를 피크(정상에 데이터 있는지 확인)
	public int peek() throws EmptyIntStackException{
		//스택이 비어있다.
		if (ptr<=0) 
			throw new EmptyIntStackException();
		
		return stk[ptr-1];
	}
	
	// ------------------------- //
	
	//스택에서 x를 찾아 인덱스를 반환 / 없을 경우 -1을 반환
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x) return i;
		}
		
		return -1;
	}
	
	//스택을 비움
	public void clear() {
		ptr = 0;
	}
	
	//스택의 용량을 반환
	public int capacity() {
		return max;
	}
	
	//스택에 쌓여 있는 데이터 수를 반환
	public int size() {
		return ptr;
	}
	
	//스택이 비어있는지 확인
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	//스택이 가득 찼는가?
	public boolean isFull() {
		return ptr >= max;
	}
	
	//스택 안의 모든 데이터를 바닥부터 출력
	//데이터를 넣었던 순서대로 출력
	public void dump() {
		if (ptr<=0) 
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i]+" ");
			}
			System.out.println();
		}
	}

}
