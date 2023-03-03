package dsa.queue;

public interface Queue<T> {
    void enqueue(T element) throws Exception;
    T dequeue() throws Exception;
    boolean isEmpty();
    boolean isFull();
    T peek() throws Exception;
}
