package dsa.linked.list;

import java.util.List;

public interface LinkedList<T> {
    int insertion(T element);
    T get(int index) throws Exception;
    int delete(int index) throws Exception;
    int search(T element) throws Exception;
    String traversal() throws Exception;
}
