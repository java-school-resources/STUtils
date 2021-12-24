import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @org.junit.jupiter.api.Test
    void push() {
        Stack<String> s = new Stack<>();
        s.push("Hello Test");
        assertEquals(s.top(), "Hello Test");
    }

    @org.junit.jupiter.api.Test
    void pop() {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        assertEquals(s.pop(), 5);
    }

    @org.junit.jupiter.api.Test
    void popEmptyStackShouldNotThrow() {
        try {
            Stack<String> s = new Stack<>();
            s.pop();
        } catch (Exception e) {
            fail("Popping empty stack should not throw exception", e);
        }
    }

    @org.junit.jupiter.api.Test
    void top() {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        assertEquals(5, s.top());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(new Stack<Integer>().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Stack<String> s = new Stack<>();
        s.push("Hello\n");
        s.push("\bBruv");
        s.push("123");
        assertEquals(s.toString(), "[Hello\n,\bBruv,123]");
    }

    @org.junit.jupiter.api.Test
    void isSorted() {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(7);
        s.push(9);
        assertTrue(Stack.isSorted(s));
    }
}