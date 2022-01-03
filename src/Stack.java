
public class Stack<T>
{
	private Node<T> head;
	private static final String TOP = " __top__ \n";
	private static final int INVALID_MIN = -1;
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
	// Advance static Methods
	// ---------------------------------------------------------------------------------------
	public static Stack<Integer> sortStack(Stack<Integer> stackToSort)
	{
		Stack<Integer> temp = new Stack<>(stackToSort);
		Stack<Integer> sortedStack = new Stack<>();

		while (!temp.isEmpty())
		{
			Stack.sinkNode(sortedStack, temp.pop());
		}

		return sortedStack;
	}

	// sink a node to its right value in a sorted stack
	public static void sinkNode(Stack<Integer> stackToSink, int value)
	{
		Stack<Integer> temp = new Stack<>();
		int currVal;

		// go through the stack and pop its values to temp till we find where value needs to be
		while (!stackToSink.isEmpty())
		{
			currVal = stackToSink.top();
			if (currVal > value)
			{
				temp.push(stackToSink.pop());
			}
			// Found place
			else
			{
				break;
			}
		}
		// add the new value to its rightful play in the sorted stack
		stackToSink.push(value);

		// fill the stack with the temp stack values.
		while (!temp.isEmpty())
		{
			stackToSink.push(temp.pop());
		}
	}


	public static Stack<Integer> mergeStacks(Stack<Integer> stack1, Stack<Integer> stack2)
	{
		Stack<Integer> mergedStack = new Stack<>(stack1);
		Stack<Integer> tempSortedS2 = new Stack<>(stack2);

		while (!tempSortedS2.isEmpty())
		{
			Stack.sinkNode(mergedStack, tempSortedS2.pop());
		}

		return mergedStack;
	}
	public static Stack<Integer> shiftStack(Stack<Integer> stackToShift)
	{
		if (stackToShift.isEmpty()) return  stackToShift;

		Stack<Integer> shiftedStack = new Stack<>(stackToShift);
		Stack<Integer> temp = new Stack<>();
		int lastValue;

		// save all values in a temp stack
		while (!shiftedStack.isEmpty())
		{
			temp.push(shiftedStack.pop());
		}
		// save the last value & and add back all the values
		lastValue = temp.pop();
		while (!temp.isEmpty())
		{
			shiftedStack.push(temp.pop());
		}
		// add to the top the last value.
		shiftedStack.push(lastValue);

		return shiftedStack;
	}

	public static boolean valueExists(Stack<Integer> stackToSearch, int value)
	{
		Stack<Integer> temp = new Stack<>(stackToSearch);
		while(!temp.isEmpty())
		{
			if (value == temp.pop())
				return true;
		}
		return false;
	}

	public static int findMin(Stack<Integer> stackToSearch)
	{
		Stack<Integer> temp = new Stack<>(stackToSearch);

		int current, min = (stackToSearch.isEmpty()) ? INVALID_MIN : temp.top();

		while (!temp.isEmpty())
		{
			current = temp.pop();
			if (current < min)
			{
				min = current;
			}
		}

		return min;
	}

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


	public static boolean areEqual(Stack<Integer> stack1, Stack<Integer> stack2)
	{
		Stack<Integer> temp1 = new Stack<Integer>(stack1);
		Stack<Integer> temp2 = new Stack<Integer>(stack2);
		// if one of the stacks is empty
		if (!temp1.isEmpty() ^ !temp2.isEmpty())
			return false;

		while (!temp1.isEmpty() && !temp2.isEmpty())
		{
			if (temp1.pop() != temp2.pop())
				return false;
		}
		return true;
	}
	// ---------------------------------------------------------------------------------------
}
