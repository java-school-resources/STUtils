
public class Stack<T> {
    private Node<T> head;
    private static final String TOP = " __top__ \n";

    // CTOR
    // ---------------------------------------------------------------------------------------
    public Stack() {
        this.head = null;
    }

    // Copy constructor
    public Stack(Stack<T> stackToCopy) {
        // pop the stackToCopy to a temp stack then push it back to this stack and stackToCopy
        Stack<T> temp = new Stack<>();

        while (!stackToCopy.isEmpty()) {
            temp.push(stackToCopy.pop());
        }

        while (!temp.isEmpty()) {
            this.push(temp.top());
            stackToCopy.push(temp.pop());
        }

    }
    // ---------------------------------------------------------------------------------------

    // Basic Methods
    // ---------------------------------------------------------------------------------------
    public void push(T x) {
        Node<T> temp = new Node<>(x);
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


    public int length() {
        Stack<T> temp = new Stack<>(this);
        int len = 0;
        while (!temp.isEmpty()) {
            temp.pop();
            len++;
        }

        return len;
    }

    public String toString() {

        String stackString = TOP;
        Stack<T> temp = new Stack<>(this);

        while (!temp.isEmpty()) {
            stackString += "|" + String.format("%-7s", temp.pop().toString()) + "|\n";
            stackString += "|_______|\n";
        }

        if (stackString == TOP) stackString = "No Stack";
        return stackString;
    }
    // ---------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------
    //mark function


    public Stack<Integer> backSort() {
        Stack<Integer> a = this.copy();
        return a.getSorted().reverse();
    }

    public int getLength() {
        Stack a = this.copy();
        int i = 0;
        while (!a.isEmpty()) {
            i++;
            a.pop();
        }
        return i;
    }

    public Stack<Integer> getSorted() { //the top is the biggest num
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> a = this.copy();
        Stack<Integer> sorted = new Stack<Integer>();

        while (sorted.getLength() != this.getLength()) {
            sorted.push(getMin(a));
            while (a.top() != getMin(a)) {
                temp.push(a.pop());
            }
            a.pop();
            while (!temp.isEmpty()) {
                a.push(temp.pop());
            }
        }
        return sorted;
    }

    public Stack<Integer> deleteNum(int num) {
        Stack neww = new Stack();
        Stack<Integer> a = this.copy();
        a = a.reverse();
        while (!a.isEmpty()) {
            if (a.top() == num) {
                a.pop();
            } else {
                neww.push(a.pop());
            }
        }
        return neww;
    }

    public static int getMin(Stack<Integer> a) {
        Stack<Integer> b = a.copy();
        int k = b.pop();
        while (!b.isEmpty()) {
            k = Math.min(b.pop(), k);
        }
        return k;
    }

    public static int getMax(Stack<Integer> a) {
        Stack<Integer> b = a.copy();
        int k = b.pop();
        while (!b.isEmpty()) {
            k = Math.max(b.pop(), k);
        }
        return k;
    }

    public Stack copy() {
        Stack<T> h1 = new Stack<>();
        Stack<T> h2 = new Stack<>();


        while (!this.isEmpty()) {
            h1.push(this.pop());
        }
        while (!h1.isEmpty()) {
            this.push(h1.top());
            h2.push(h1.pop());
        }
        return h2;
    }

    public Stack reverse() {
        Stack<T> a = this.copy();
        Stack<T> b = new Stack<>();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        return b;
    }

    public boolean isSorted() {
        return (equalsTo(this.copy(), this.copy().getSorted()));
    }

    public static boolean equalsTo(Stack<Integer> a, Stack<Integer> b) {
        Stack<Integer> c = a.copy();
        Stack<Integer> d = b.copy();
        boolean flag = true;
        if (c.getLength() != d.getLength()) {
            return false;
        }
        while (!c.isEmpty() && !d.isEmpty()) {
            if (c.pop() != d.pop()) {
                flag = false;
            }
        }
        return flag;
    }

    public static boolean containsSameNumbers(Stack<Integer> a, Stack<Integer> b) {
        Stack<Integer> c = a.copy();
        Stack<Integer> d = b.copy();
        return equalsTo(c.getSorted(), d.getSorted());
    }

    public static Stack merge(Stack<Integer> g, Stack<Integer> f) {
        Stack<Integer> a = g.copy();
        Stack<Integer> b = f.copy();
        Stack<Integer> c = new Stack<Integer>();
        while (!a.isEmpty() && !b.isEmpty()) {
            int anum = a.top();
            int bnum = b.top();
            if (anum >= bnum) {
                c.push(anum);
                a.pop();
            } else {
                c.push(bnum);
                b.pop();
            }
        }
        if (a.isEmpty()) {
            while (!b.isEmpty()) {
                c.push(b.pop());
            }

        }
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                c.push(a.pop());
            }

        }
        return c;
    }

    public boolean isIn(T x) {
        Stack<T> a = this.copy();
        while (!a.isEmpty()) {
            if (a.pop() == x) {
                return true;
            }
        }
        return false;
    }


    //
    // ---------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------
    public static void main(String[] args) {

    }
}
