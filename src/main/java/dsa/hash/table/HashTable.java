package dsa.hash.table;

public interface HashTable<K, V> {
    void put(K key, V value) throws Exception;
    V get(K key) throws Exception;
    void remove(K key) throws Exception;
    int getNumberOfEntries();
    int getLengthTable();
}
