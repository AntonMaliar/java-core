package dsa.linked.list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void createLinkedList(){
        LinkedList<Integer> linkedList = new LinkedListImp<>();

        assertNotNull(linkedList);
    }
    @Test
    public void insertElementToListIfListIsEmpty(){
        LinkedList<Integer> linkedList = new LinkedListImp<>();
        int indexInsertedElement = linkedList.insertion(1);

        assertEquals(0, indexInsertedElement);
    }
    @Test
    public void insertElementToListIfListNotEmpty(){
        LinkedList<Integer> linkedList = new LinkedListImp<>();
        linkedList.insertion(1);
        int indexInsertedElement = linkedList.insertion(2);

        assertEquals(1, indexInsertedElement);
    }
    @Test
    public void getElementFromListIfListIsEmpty(){
        LinkedList<Integer> linkedList = new LinkedListImp<>();

        Exception exception = assertThrows(Exception.class, () -> linkedList.get(0));
        assertEquals("ListIsEmpty", exception.getMessage());
    }
    @Test
    public void getElementFromList() throws Exception {
        LinkedList<Integer> linkedList = new LinkedListImp<>();
        linkedList.insertion(10);
        linkedList.insertion(20);

        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
    }
    @Test
    public void getElementFromListTest2() throws Exception {
        LinkedList<String> linkedList = new LinkedListImp<>();
        linkedList.insertion("Hello");
        linkedList.insertion("World");

        assertEquals("Hello", linkedList.get(0));
        assertEquals("World", linkedList.get(1));
    }
    @Test
    public void deleteElementFromListIfListIsEmpty(){
        LinkedList<String> linkedList = new LinkedListImp<>();

        Exception exception = assertThrows(Exception.class, () -> linkedList.delete(0));
        assertEquals("ListIsEmpty", exception.getMessage());
    }
    @Test
    public void deleteElementFromList() throws Exception {
        LinkedList<Integer> linkedList = new LinkedListImp<>();
        linkedList.insertion(10);
        linkedList.insertion(20);
        linkedList.insertion(30);

        int indexDeletedElement = linkedList.delete(0);
        assertEquals(0, indexDeletedElement);

        assertEquals(20, linkedList.get(0));
        assertEquals(30, linkedList.get(1));
    }
    @Test
    public void searchElementIfListIsEmpty(){
        LinkedList<Integer> linkedList = new LinkedListImp<>();

        Exception exception = assertThrows(Exception.class, () -> linkedList.search(0));
        assertEquals("ListIsEmpty", exception.getMessage());
    }
    @Test
    public void searchElementTest() throws Exception {
        LinkedList<Integer> linkedList = new LinkedListImp<>();
        linkedList.insertion(10);
        linkedList.insertion(20);

        assertEquals(0, linkedList.search(10));
        assertEquals(1, linkedList.search(20));
    }
    @Test
    public void traversalIfListIsEmpty(){
        LinkedList<Integer> linkedList = new LinkedListImp<>();

        Exception exception = assertThrows(Exception.class, () -> linkedList.traversal());
        assertEquals("ListIsEmpty", exception.getMessage());
    }
    @Test
    public void traversalTest() throws Exception {
        LinkedList<Integer> linkedList = new LinkedListImp<>();
        linkedList.insertion(1);
        linkedList.insertion(2);
        linkedList.insertion(3);

        assertEquals("[1, 2, 3]", linkedList.traversal());
    }
}


































