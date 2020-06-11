package hw7_18001163;

public class SortedArrayList<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    static protected class ArrEntry<K, E> implements Entry<K, E> {
        private K key;
        private E value;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.value = e;
        }

        @Override
        public K getKey() {
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

    public SortedArrayList(int capacity) {
        array = new ArrEntry[capacity];
        this.defaultsize = capacity;
    }

    public SortedArrayList() {
        this(defaultsize);
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
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i].getKey() + " ");
        }
    }

    public K search(K key) {
        for (int i = 0; i < n; i++) {
            if (array[i].getKey().compareTo(key) == 0) {
                return array[i].getKey();
            }
        }
        return null;
    }

    public K binarySearch(int first, int last, K key) {
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if (array[mid].getKey().compareTo(key) == 0) {
                return array[mid].getKey();
            }
            if (array[mid].getKey().compareTo(key) > 0) {
                return binarySearch(first, mid - 1, key);
            } else {
                return binarySearch(mid + 1, last, key);
            }
        }
        return null;
    }

    @Override
    public void insert(Entry<K, E> entry) {
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
        ArrEntry<K, E> newEntry = new ArrEntry(k, e);
        insert(newEntry);
    }

}
