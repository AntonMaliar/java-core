package dsa.stack;

public class StackImp<T> implements Stack<T> {
    private Object[] arr;
    private int top = -1;

    public StackImp(int size){
        arr = new Object[size];
    }

    @Override
    public void push(T element) throws Exception {
        if(isFull()) throw new Exception("StackIsFull");
        else arr[++top] = element;
    }

    @Override
    public T pop() throws Exception {
        if(top == -1) throw new Exception("StackIsEmpty");
        else return (T)arr[top--];
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) return true;
        else return false;
    }

    @Override
    public boolean isFull() {
        if(top == arr.length-1) return true;
        else return false;
    }

    @Override
    public T peek() {
        return (T)arr[top];
    }
}
