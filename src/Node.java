import java.util.Scanner;

public class Node<T> {
    private T value;
    private Node<T> next;


    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

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

    public static double sumList(Node<Double> p) {
        double sum = 0;
        while (p != null) {
            sum += p.getValue();
            p = p.getNext();
        }
        return sum;
    }

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter 7 numbers: ");
        Node<Double> first = null;
        first = new Node<Double>(reader.nextDouble());
        Node<Double> last = first;


    }

}
