package dsa.hash.table;

import java.util.Arrays;

public class HashTableImp<K, V> implements HashTable<K, V>{
    private Entry<K, V>[] table;
    private int numberOfEntries = 0;
    public final float LOAD_FACTOR = 0.7f;

    public HashTableImp(){
        table = new Entry[11];
    }
    public HashTableImp(int size){
        table = new Entry[size];
    }

    @Override
    public void put(K key, V value) throws Exception {
        if(numberOfEntries == 0) {
            addEntryToTable(key, value);
            return;
        }
        if(isKeyRepeated(key)) throw new Exception("KeyMustBeUnique");
        if(1f * numberOfEntries / table.length > LOAD_FACTOR) increaseTable();

        addEntryToTable(key, value);
    }

    private boolean isKeyRepeated(K key) {
        int index = getIndex(key);
        var entry = table[index];
        if(entry != null){
            if(entry.getKey().equals(key)) return true;
            while (entry.getNext() != null) {
                entry = entry.getNext();
                if(entry.getKey().equals(key)) return true;
            }
        }
        return false;
    }
    private void addEntryToTable(K key, V value) {
        int index = getIndex(key);
        var entry = table[index];

        if(entry == null){
            table[index] = new Entry<>(key, value);
            numberOfEntries++;
            return;
        }else {
            while (entry.getNext() != null){
                entry = entry.getNext();
            }
        }

        entry.setNext(new Entry<>(key, value));
        numberOfEntries++;
    }
    private void increaseTable() {
        var newSize = table.length * 2 + 1;
        var newTable = Arrays.copyOf(table, newSize);
        table = newTable;
    }
    private int getIndex(K key) {
        int index = key.hashCode() > 0
                ? (key.hashCode() % table.length)
                : ((key.hashCode() * -1) % table.length);
        return index;
    }

    @Override
    public V get(K key) throws Exception {
        if(numberOfEntries == 0) throw new Exception("HashTableIsEmpty");
        if(keyNotFound(key)) throw new Exception("KeyNotFound");

        int index = getIndex(key);
        var entry = table[index];
        if(entry.getKey().equals(key)) return entry.getValue();

        while (entry.getNext() != null){
            entry = entry.getNext();
            if(entry.getKey().equals(key)) break;
        }

        return entry.getValue();
    }

    private boolean keyNotFound(K key) {
        int index = getIndex(key);
        var entry = table[index];
        if(entry == null){
            return true;
        }else {
            while (entry != null) {
                if(entry.getKey().equals(key)) return false;
                entry = entry.getNext();
            }
        }
        return true;
    }

    @Override
    public void remove(K key) throws Exception {
        if(numberOfEntries == 0) throw new Exception("HashTableIsEmpty");
        if(keyNotFound(key)) throw new Exception("KeyNotFound");

        int index = getIndex(key);
        var entry = table[index];

        if(entry.getKey().equals(key)) {
            if(entry.getNext() == null){
                table[index] = null;
            }else {
                table[index] = entry.getNext();
            }
            numberOfEntries--;
            return;
        }
        var subEntry = entry.getNext();
        while (subEntry != null){
            if (subEntry.getKey().equals(key)){
                if(subEntry.getNext() == null){
                    entry.setNext(null);
                }else {
                    entry.setNext(subEntry.getNext());
                }
                numberOfEntries--;
                return;
            }
            entry = subEntry;
            subEntry = subEntry.getNext();
        }
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public int getLengthTable() {
        return table.length;
    }
}
