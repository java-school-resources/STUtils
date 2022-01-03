public class Main
{
    public static void main(String[] args)
    {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        // stack 1
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        // stack 2
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        /* stack2.push(-1);
        stack2.push(2);
        stack2.push(4);
        stack2.push(5);*/


        System.out.println(Stack.mergeStacks(stack1, stack2).toString());
        System.out.println(stack1.toString());
        System.out.println(stack2.toString());
        System.out.println(Stack.valueExists(stack2, 0));
        System.out.println(Stack.shiftStack(stack2));
        System.out.println(Stack.areEqual(stack1, stack2));

    }
}
