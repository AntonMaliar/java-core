package dsa.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    public void createQueue(){
        Queue<Integer> queue = new QueueImp(5);

        assertNotNull(queue);
    }
    @Test
    public void addElementInQueue(){
        Queue<Integer> queue = new QueueImp(5);

        assertDoesNotThrow((() -> queue.enqueue(10)));

    }
    @Test
    public void addElementInQueueIfQueueIsFull() throws Exception {
        Queue<Integer> queue = new QueueImp(1);
        queue.enqueue(10);

        assertThrows(Exception.class, () -> queue.enqueue(20));
    }
    @Test
    public void removeElementFromQueue() throws Exception {
        Queue<Integer> queue = new QueueImp(2);
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
    }
    @Test
    public void removeElementFromQueueIfQueueIsEmpty(){
        Queue<Integer> queue = new QueueImp(2);

        assertThrows(Exception.class, () -> queue.dequeue());
    }
    @Test
    public void checkIfQueueIsEmpty(){
        Queue<Integer> queue = new QueueImp(2);

        assertTrue(queue.isEmpty());
    }
    @Test
    public void checkIfQueueIsNotEmpty() throws Exception {
        Queue<Integer> queue = new QueueImp(2);
        queue.enqueue(10);

        assertFalse(queue.isEmpty());
    }
    @Test
    public void checkIfQueueIsFull() throws Exception {
        Queue<Integer> queue = new QueueImp(1);
        queue.enqueue(10);

        assertTrue(queue.isFull());
    }
    @Test
    public void checkIfQueueIsNotFull(){
        Queue<Integer> queue = new QueueImp(1);

        assertFalse(queue.isFull());
    }
    @Test
    public void getValueFromFrontOfQueueWithoutRemovingElement() throws Exception {
        Queue<Integer> queue = new QueueImp(2);
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.peek());
        assertEquals(10, queue.peek());
    }
    @Test
    public void peekElementIfWeAlreadyRemoveElementFromQueue() throws Exception {
        Queue<Integer> queue = new QueueImp(2);
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.dequeue());

        assertEquals(20, queue.peek());
        assertEquals(20, queue.peek());
    }
    @Test
    public void peekElementIfQueueIfEmpty(){
        Queue<Integer> queue = new QueueImp(2);

        assertThrows(Exception.class, () -> queue.peek());
    }

}





















