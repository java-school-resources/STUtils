
/**
 * Java generic stack implementation.
 */
public class Stack<T> {

	private Node<T> head;

	public Stack() {
		this.head = null;
	}

	/**
	 * Pushes an element onto the top of the stack.
	 *
	 * @param x new stack head
	 */
	public void push(T x) {
		Node<T> temp = new Node<>(x);
		temp.setNext(head);
		head = temp;
	}

	/**
	 * Pops an element off the top of the stack.
	 *
	 * @return the head of the stack
	 */
	public T pop() {
		T x = head.getValue();
		head = head.getNext();
		return x;
	}

	/**
	 * Returns the top of the stack.
	 *
	 * @return top of the stack
	 */
	public T top() {
		return head.getValue();
	}

	/**
	 * Checks whether the stack has any elements in it.
	 *
	 * @return if the stack is empty
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Returns the stack in string form.
	 *
	 * <h1>Examples</h1>
	 * *<pre>
	 *  {@code
	 * Stack<Integer> s = new Stack<>();
	 * s.push(5);
	 * s.push(7);
	 * s.toString(); // returns [7,5]
	 * }
	 * </pre>
	 * if the stack is empty however,
	 * * <pre>
	 * * {@code
	 * * Stack<Integer> s = new Stack<>();
	 * s.toString(); //returns []
	 * *}
	 * * </pre>
	 *
	 * @return the stack in string form
	 */
	public String toString() {

		if (this.isEmpty()) return "[]";
		Stack<T> temp = new Stack<T>();

		while (!this.isEmpty())
			temp.push(this.pop());

		String s = "[";

		while (!temp.isEmpty()) {
			s = s + temp.top().toString() + ',';
			this.push(temp.pop());
		}

		s = s.substring(0, s.length() - 1) + "]";
		return s;
	}


	public static boolean isSorted(Stack<Integer> s) {
		int top = s.pop();
		while (!s.isEmpty()) {
			if (top < s.top()) {
				return false;
			}
			top = s.pop();
		}
		return true;
	}

	public static <T> void fill(Stack<T> remove, Stack<T> fill) {
		while (!remove.isEmpty()) {
			fill.push(remove.pop());
		}
	}

	public static <T> void circular(Stack<T> s) {
		Stack<T> tmp = new Stack<>();
		T top = s.pop();
		fill(s, tmp);
		s.push(top);
		fill(tmp, s);
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(8);
		s.push(9);
		s.push(12);
		System.out.println(isSorted(s));

	}

}
