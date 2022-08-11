import java.util.LinkedList;

public class HashTable {
    private class Entry{
        int key;
        String value;
        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] hashTable = new LinkedList[10];

    public void put(int key, String value){
        int index = hash(key);
        if (hashTable[index] == null)
            hashTable[index] = new LinkedList<>();

        for (Entry entry: hashTable[index]){
            if (entry.key==key){
                entry.value = value;
                return;
            }
        }
        hashTable[index].addLast(new Entry(key, value));
    }

    public String get(int key){
//        Entry entry = getEntry(key);

        int index = hash(key);
        if (hashTable[index] == null)
            throw new IllegalStateException();
        for (Entry entry : hashTable[index])
            if (entry.key == key)
                return entry.value;
        return null;
    }

    public void remove(int key){
        Entry entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(int key){
        return hashTable[hash(key)];
    }
    private Entry getEntry(int key){
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket == null)
            throw new IllegalStateException();
        for (Entry entry: bucket)
            if (entry.key == key) {
                return entry;
            }
        return null;
    }
    private int hash(int key){
        return Math.abs(key) % hashTable.length;
    }
}
