package dsa.queue;

public class QueueImp<T> implements Queue<T>{
    private Object[] arr;
    private int front;
    private int end;

    public QueueImp(int size){
        arr = new Object[size];
        front = -1;
        end = -1;
    }

    @Override
    public void enqueue(T element) throws Exception {
        if(isFull()){
            throw new Exception("QueueIsFull");
        }
        arr[++end] = element;
    }

    @Override
    public T dequeue() throws Exception {
        if(isEmpty()) throw new Exception("QueueIsEmpty");
        return (T)arr[++front];
    }

    @Override
    public boolean isEmpty() {
        if(end == -1) return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if(end == arr.length-1) return true;
        return false;
    }

    @Override
    public T peek() throws Exception{
        if(isEmpty()) throw new Exception("QueueIsEmpty");
        else if (front == -1) return (T)arr[0];
        return (T)arr[front+1];
    }
}
