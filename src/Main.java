public class Main
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(101);
        System.out.println(stack.toString());
        System.out.println(Stack.isSorted(stack));
        System.out.println(stack.length());

    }
}
