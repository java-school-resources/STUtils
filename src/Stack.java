
public class Stack<T> {
	private Node<T> head;
	
	public Stack() {
		this.head = null;
	}
	
	
	public void push(T x) {
		Node<T> temp = new Node<T>(x);
		temp.setNext(head);
		head = temp;
	}
	
	public T pop() {
		T x = head.getValue();
		head = head.getNext();
		return x;
	}
	
	public T top() {
		return head.getValue();
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public String toString() {
		
		if(this.isEmpty()) return "[]";
		Stack<T> temp = new Stack<T>();
		
		while(!this.isEmpty())
			temp.push(this.pop());
		
		String s = "[";
		
		while(!temp.isEmpty()) {
			s = s + temp.top() + ',';
			this.push(temp.pop());
		}
		
		s = s.substring(0 , s.length()-1) +"]" ;
		return s;
	}
	
	
	public static boolean isSorted(Stack<Integer> s) {
		
		while(!s.isEmpty()) {
			int top = s.pop();
			if(top < s.top()) {
				return false;
			}
		}
		return true;
	}
	
	public static<T> void fill(Stack<T> remove, Stack<T> fill) {
		while(!remove.isEmpty()) {
			fill.push(remove.pop());
		}
	}
	
	public static<T> void circular(Stack<T> s) {
		Stack<T> tmp = new Stack<T>();
		T top = s.pop();
		fill(s, tmp);
		s.push(top);
		fill(tmp, s);
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(8);
		s.push(9);
		s.push(2);
		s.push(12);
		System.out.println(isSorted(s));

	}

}
