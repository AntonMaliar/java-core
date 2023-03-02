package dsa.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void createStack(){
        Stack<Integer> stack = new StackImp(10);

        assertNotNull(stack);
    }
    @Test
    public void AddElementToTheTopOfStack() throws Exception {
        Stack<Integer> stack = new StackImp<>(10);
        stack.push(1);
    }
    @Test
    public void removeAnElementFromTheTopOfAStack() throws Exception {
        Stack<Integer> stack = new StackImp<>(10);
        stack.push(5);
        stack.push(6);

        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());
    }
    @Test
    public void checkIfTheStackIsEmpty(){
        Stack<Integer> stack = new StackImp<>(10);

        assertTrue(stack.isEmpty());
    }
    @Test
    public void checkIfTheStackIsNotEmpty() throws Exception {
        Stack<Integer> stack = new StackImp<>(10);
        stack.push(5);

        assertFalse(stack.isEmpty());
    }
    @Test
    public void checkIfTheStackIsFull() throws Exception {
        Stack<Integer> stack = new StackImp<>(1);
        stack.push(5);

        assertTrue(stack.isFull());
    }
    @Test
    public void checkIfTheStackIsNotFull() throws Exception {
        Stack<Integer> stack = new StackImp<>(2);
        stack.push(5);

        assertFalse(stack.isFull());
    }
    @Test
    public void getTheValueOfTheTopElementWithoutRemovingIt() throws Exception {
        Stack<Integer> stack = new StackImp<>(2);
        stack.push(5);
        stack.push(6);

        assertEquals(6, stack.peek());
        assertEquals(6, stack.peek());
    }
    @Test
    public void pushIfStackFull() throws Exception {
        Stack<Integer> stack = new StackImp<>(1);
        stack.push(1);

        try {
            stack.push(2);
        }catch (Exception e){
            assertEquals("StackIsFull", e.getMessage());
        }
        assertEquals(1, stack.pop());
    }
    @Test
    public void beforePoppingWeCheckIfTheStackIsAlreadyEmpty(){
        Stack<Integer> stack = new StackImp<>(1);

        try {
            stack.pop();
        }catch (Exception e){
            assertEquals("StackIsEmpty", e.getMessage());
        }
    }
}


























