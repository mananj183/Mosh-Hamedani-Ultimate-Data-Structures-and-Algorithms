public class HashTableLP {
    private class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] hashTable = new Entry[10];
    private int count = 0;

    public void put(int key, String value){
        if (count>= hashTable.length)
            throw new IllegalStateException();
        int index = hash(key);
        hashTable[index] = new Entry(key, value);
        count++;
    }

    public String get(int key){
        Entry e = hashTable[hash(key)];
        if (e!= null && e.key == key)
            return e.value;
        return null;
    }

    public void remove(int key){
        int index = hash(key);
        Entry e = hashTable[index];
        if (e!= null && e.key == key)
            hashTable[index] = null;
        else throw new IllegalStateException();
    }

    private int hash(int key){
        int table_size = hashTable.length;
        int hash1 = key % table_size;
        int index = hash1;
        if (hashTable[index] == null || hashTable[index].key == key){
            return index;
        }
        int prime = table_size-1;
        while (!isPrime(prime))
            prime--;
        int hash2 = prime - (key%prime);
        int i = 1;
        while (hashTable[index] != null && i<=table_size){
            index = (hash1 + i*hash2) %table_size;
            if (hashTable[index] != null && hashTable[index].key == key)
                return index;
            i++;
        }
        return index;
    }

    private boolean isPrime(int n){
        for (int i = 2; i<n/2; i++){
            if (n%i == 0)
                return false;
        }
        return true;
    }
}
