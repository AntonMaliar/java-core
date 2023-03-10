package dsa.hash.table;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    @Test
    public void createHashTable(){
        HashTable<Integer, String> hashTable = new HashTableImp<>();

        assertNotNull(hashTable);
    }
    @Test
    public void putElementIfTableIsEmpty() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>();
        hashTable.put(1, "Hello");

        assertEquals(1, hashTable.getNumberOfEntries());
    }
    @Test
    public void putElementToTableIfKeyRepeated() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>();
        hashTable.put(1, "Hello");

        assertThrows(Exception.class, () -> hashTable.put(1, "World"));
    }
    @Test
    public void putFewElementToTableWithDifferentKeys() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>();
        hashTable.put(1, "Hello");
        hashTable.put(2, "World");

        assertEquals(2, hashTable.getNumberOfEntries());
    }
    @Test
    public void putEntryToTableIfLoadFactorIsMoreThanNeed() throws Exception {
        HashTable<String, String> hashTable = new HashTableImp<>(4);
        hashTable.put("1", "Hello1");
        hashTable.put("2", "Hello2");
        hashTable.put("3", "Hello3");
        assertEquals(4, hashTable.getLengthTable());

        hashTable.put("4", "Hello4");
        assertEquals(9, hashTable.getLengthTable());
        assertEquals(4, hashTable.getNumberOfEntries());
    }
    @Test
    public void createCollision() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>(10);
        hashTable.put(1, "Hello");
        hashTable.put(11, "World");

        assertEquals(2, hashTable.getNumberOfEntries());
    }
    @Test
    public void getElementFromTableIfTableIsEmpty() {
        HashTable<Integer, String> hashTable = new HashTableImp<>();

        assertThrows(Exception.class, () -> hashTable.get(1));
    }
    @Test
    public void getElementFromTableIfKeyNotFound(){
        HashTable<Integer, String> hashTable = new HashTableImp<>();

        Exception exception = assertThrows(Exception.class, () -> hashTable.get(1));
    }
    @Test
    public void getElementFromTableIfKeyNotFoundButExistCollision() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>(10);
        hashTable.put(1, "Hello");

        assertThrows(Exception.class, () -> hashTable.get(11));
    }
    @Test
    public void getElementFromTable() throws Exception {
        HashTable<String, String> hashTable = new HashTableImp<>();
        hashTable.put("a", "A");
        hashTable.put("b", "B");

        assertEquals("A", hashTable.get("a"));
        assertEquals("B", hashTable.get("b"));
    }
    @Test
    public void getElementFromTableIfWasCollision() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>(10);
        hashTable.put(1, "Hello");
        hashTable.put(11, "World");
        hashTable.put(111, "SomeValue");

        assertEquals("Hello", hashTable.get(1));
        assertEquals("World", hashTable.get(11));
        assertEquals("SomeValue", hashTable.get(111));
    }
    @Test
    public void removeElementIfTableIsEmpty() {
        HashTable<Integer, String> hashTable = new HashTableImp<>();

        assertThrows(Exception.class, () -> hashTable.remove(1));
    }
    @Test
    public void removeElementFromTableIfKeyNotFoundBecauseEntryNotExist() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>();
        hashTable.put(1, "Hello");

        Exception exception = assertThrows(Exception.class, () -> hashTable.remove(2));
        assertEquals("KeyNotFound", exception.getMessage());
    }
    @Test
    public void removeElementFromTableIfKeyNotFoundButEntryExist_Collision() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>(10);
        hashTable.put(1, "Hello_1");

        Exception exception = assertThrows(Exception.class, () -> hashTable.remove(11));
        assertEquals("KeyNotFound", exception.getMessage());
    }
    @Test
    public void removeElementFromTableIfKeyNotFoundButEntryExist_Collision_Test2() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>(10);
        hashTable.put(1, "Hello_1");
        hashTable.put(11, "Hello_2");

        Exception exception = assertThrows(Exception.class, () -> hashTable.remove(111));
        assertEquals("KeyNotFound", exception.getMessage());
    }
    @Test
    public void removeElementIfNoCollision() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>();
        hashTable.put(1, "World");
        hashTable.remove(1);

        assertEquals(0, hashTable.getNumberOfEntries());
        assertThrows(Exception.class, () -> hashTable.get(1));
    }
    @Test
    public void removeElementIfCollisionExistRemoveParentEntry() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>(10);
        hashTable.put(1, "Hello");
        hashTable.put(11, "World");
        hashTable.put(111, "!");

        hashTable.remove(1);

        assertEquals(2, hashTable.getNumberOfEntries());
        assertEquals("World", hashTable.get(11));
        assertEquals("!", hashTable.get(111));
    }
    @Test
    public void removeElementIfCollisionExistRemoveChildEntryOfParentEntry() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>(10);
        hashTable.put(1, "Hello");
        hashTable.put(11, "World");

        hashTable.remove(11);

        assertEquals("Hello", hashTable.get(1));
        assertThrows(Exception.class, () -> hashTable.get(11));
        assertEquals(1, hashTable.getNumberOfEntries());
    }
    @Test
    public void removeElementSecondSubElement() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>(10);
        hashTable.put(1, "Hello");
        hashTable.put(11, "World");
        hashTable.put(111, "!");

        hashTable.remove(111);

        assertEquals("Hello", hashTable.get(1));
        assertEquals("World", hashTable.get(11));
        assertThrows(Exception.class, () -> hashTable.get(111));
        assertEquals(2, hashTable.getNumberOfEntries());
    }
    @Test
    public void removeElementBetweenTwoEntry() throws Exception {
        HashTable<Integer, String> hashTable = new HashTableImp<>(10);
        hashTable.put(1, "Hello");
        hashTable.put(11, "World");
        hashTable.put(111, "!");

        hashTable.remove(11);

        assertEquals("Hello", hashTable.get(1));
        assertEquals("!", hashTable.get(111));
        assertThrows(Exception.class, () -> hashTable.get(11));
        assertEquals(2, hashTable.getNumberOfEntries());
    }
}






























