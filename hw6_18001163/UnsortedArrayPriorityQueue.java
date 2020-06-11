package hw6_18001163;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

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
    int n = 0;
    static int defaultsize = 1000;

    public UnsortedArrayPriorityQueue(int capacity) {
        array = new ArrEntry[capacity];
        this.defaultsize = capacity;
    }

    public UnsortedArrayPriorityQueue() {
        this(defaultsize);
    }

    @Override
    public int size() {
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
        array[n++] = newEntry;
    }

    @Override
    public Entry removeMin() {
        int min = findMin();
        if (min == -1) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            int key = (int) array[i].getKey();
            if (key == min) {
                ArrEntry<K, E> entryRemoved = array[i];
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                n--;
                return entryRemoved;
            }
        }
        return null;
    }

    @Override
    public Entry min() {
        int min = findMin();
        if (min == -1) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            int key = (int) array[i].getKey();
            if (key == min) {
                return array[i];
            }
        }
        return null;
    }

    @Override
    public void insert(K k, E e) {
        // TODO Auto-generated method stub
        if (n >= defaultsize) {
            return;
        }
        ArrEntry<K, E> newEntry = new ArrEntry<K, E>(k, e);
        array[n++] = newEntry;
    }

    public int findMin() {
        if (n == 0)
            return -1;
        K min = array[0].getKey();
        for (int i = 1; i < n; i++) {
            K key = array[i].getKey();
            if (key.compareTo(min) < 0) {
                min = key;
            }
        }
        return (int) min;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i].getKey() + " ");
        }
    }

}