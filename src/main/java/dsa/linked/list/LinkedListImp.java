package dsa.linked.list;

public class LinkedListImp<T> implements LinkedList<T>{
    private int currentNodeIndex;
    private Node<T> head;

    public LinkedListImp(){
        currentNodeIndex = -1;
        head = new Node<>();
    }

    @Override
    public int insertion(T value) {
        if(head.getNext() == null){
            head.setNext(new Node<>(value));
        }else {
            getLastNode().setNext(new Node<>(value));
        }
        return ++currentNodeIndex;
    }

    @Override
    public T get(int index) throws Exception {
        if(head.getNext() == null){
            throw new Exception("ListIsEmpty");
        }
        return getNodeByIndex(index).getValue();
    }

    @Override
    public int delete(int index) throws Exception {
        if(head.getNext() == null){
            throw new Exception("ListIsEmpty");
        }
        return deleteNode(index);
    }

    @Override
    public int search(T value) throws Exception {
        if(head.getNext() == null){
            throw new Exception("ListIsEmpty");
        }
        return getIndexNodeByValue(value);
    }

    @Override
    public String traversal() throws Exception {
        if(head.getNext() == null) {
            throw new Exception("ListIsEmpty");
        }

        var currentNode = head.getNext();
        StringBuilder stringBuilder = new StringBuilder("["+currentNode.getValue());

        while (currentNode.getNext() != null){
            currentNode = currentNode.getNext();
            stringBuilder.append(", ").append(currentNode.getValue());
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private Node<T> getLastNode() {
        var currentNode = head.getNext();

        while (currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    private Node<T> getNodeByIndex(int index){
        var currentNode = head.getNext();
        int currentIndex = 0;

        while (currentIndex != index){
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode;
    }

    private int deleteNode(int index){
        var parentNode = head;
        var currentNode = head.getNext();
        int currentIndex = 0;

        while (currentIndex != index){
            parentNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        var childNode = currentNode.getNext();
        parentNode.setNext(childNode);

        return currentIndex;
    }

    private int getIndexNodeByValue(T value){
        var currentNode = head.getNext();
        int currentIndex = 0;

        if(currentNode.getValue() != value){
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentIndex;
    }
}