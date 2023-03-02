package dsa.stack;

public interface Stack<T> {
    void push(T element) throws Exception;
    T pop() throws Exception;
    boolean isEmpty();
    boolean isFull();
    T peek();
}
