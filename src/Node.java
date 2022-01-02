
public class Node<T>
{
    private T value;
    private Node<T> next;

    // CTOR
    public Node(T value)
    {
        this.value = value;
        this.next = null;
    }
    // Copy constructor
    public Node(T value, Node<T> next)
    {
        this.value = value;
        this.next = next;
    }

    // Getters
    public T getValue() {
        return value;
    }
    public Node<T> getNext() {
        return next;
    }

    // Setters
    public void setValue(T value) {
        this.value = value;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "Node[value=" + value + ", next=" + next + "]";
    }

}
