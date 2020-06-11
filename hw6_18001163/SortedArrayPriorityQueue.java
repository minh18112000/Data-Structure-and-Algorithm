package hw6_18001163;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    static protected class ArrEntry<K, E> implements Entry<K, E> {
        private K key;
        private E value;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.value = e;
        }

        @Override
        public K getKey() {
            // TODO Auto-generated method stub
            return this.key;
        }

        @Override
        public E getValue() {
            return this.value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

    ArrEntry<K, E>[] array;
    static int n = 0;
    static int defaultsize = 1000;

    public SortedArrayPriorityQueue(int capacity) {
        array = new ArrEntry[capacity];
        this.defaultsize = capacity;
    }

    public SortedArrayPriorityQueue() {
        this(defaultsize);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size() == 0;
    }

    @Override
    public void insert(Entry entry) {
        if (n >= defaultsize) {
            return;
        }
        ArrEntry<K, E> newEntry = (ArrEntry) entry;
        if (n == 0) {
            array[n++] = newEntry;
        } else {
            ++n;
            for (int i = 0; i < n - 1; i++) {
                if (array[i].getKey().compareTo(newEntry.getKey()) > 0) {
                    for (int j = n - 1; j > i; j--) {
                        array[j] = array[j - 1];
                    }
                    array[i] = newEntry;
                } else {
                    array[n - 1] = newEntry;
                }
            }
        }
    }

    @Override
    public void insert(K k, E e) {
        if (n >= defaultsize) {
            return;
        }
        ArrEntry<K, E> newEntry = new ArrEntry(k, e);
        if (n == 0) {
            array[n++] = newEntry;
        } else {
            ++n;
            for (int i = 0; i < n - 1; i++) {
                if (array[i].getKey().compareTo(newEntry.getKey()) > 0) {
                    for (int j = n - 1; j > i; j--) {
                        array[j] = array[j - 1];
                    }
                    array[i] = newEntry;
                    return;
                } else {
                    array[n - 1] = newEntry;
                }
            }
        }
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            return null;
        }
        ArrEntry<K, E> entryRemoved = array[0];
        for (int i = 0; i < n - 1; i++) {
            array[i] = array[i + 1];
        }
        n--;
        return entryRemoved;
    }

    @Override
    public Entry min() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i].getKey() + " ");
        }
    }

}