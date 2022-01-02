
public class Stack<T>
{
	private Node<T> head;
	private static final String TOP = " __top__ \n";
	// CTOR
	// ---------------------------------------------------------------------------------------
	public Stack()
	{
		this.head = null;
	}

	// Copy constructor
	public Stack(Stack<T> stackToCopy)
	{
		// pop the stackToCopy to a temp stack then push it back to this stack and stackToCopy
		Stack<T> temp = new Stack<>();

		while(!stackToCopy.isEmpty())
		{
			temp.push(stackToCopy.pop());
		}

		while(!temp.isEmpty())
		{
			this.push(temp.top());
			stackToCopy.push(temp.pop());
		}

	}
	// ---------------------------------------------------------------------------------------

	// Basic Methods
	// ---------------------------------------------------------------------------------------
	public void push(T x)
	{
		Node<T> temp = new Node<>(x);
		temp.setNext(head);
		head = temp;
	}

	public T pop()
	{
		T x = head.getValue();
		head = head.getNext();
		return x;
	}

	public T top()
	{
		return head.getValue();
	}

	public boolean isEmpty()
	{
		return head == null;
	}


	public int length()
	{
		Stack<T> temp = new Stack<>(this);
		int len = 0;
		while (!temp.isEmpty())
		{
			temp.pop();
			len++;
		}

		return len;
	}

	public String toString()
	{

		String stackString = TOP;
		Stack<T> temp = new Stack<>(this);

		while (!temp.isEmpty())
		{
			stackString += "|" + String.format("%-7s", temp.pop().toString() ) + "|\n";
			stackString += "|_______|\n";
		}

		if (stackString == TOP) stackString = "No Stack";
		return stackString;
	}
	// ---------------------------------------------------------------------------------------

	// Static Functions
	// ---------------------------------------------------------------------------------------
	public static boolean isSorted(Stack<Integer> stackToCheck)
	{
		Stack<Integer> temp = new Stack<Integer>(stackToCheck);
		int top;

		while (!temp.isEmpty())
		{
			top = temp.pop();
			// if the stack isn't already empty then check for sort validation
			if (!temp.isEmpty() && top < temp.top())
			{
				return false;
			}
		}
		return true;
	}
	// ---------------------------------------------------------------------------------------
}
