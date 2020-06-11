package hw7_18001163;

public class UnSortedArrayList<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

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
    int n = 0;
    static int defaultsize = 1000;

    public UnSortedArrayList(int capacity) {
        array = new ArrEntry[capacity];
        this.defaultsize = capacity;
    }

    public UnSortedArrayList() {
        this(defaultsize);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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

    @Override
    public void insert(Entry<K, E> entry) {
        if (n >= defaultsize) {
            return;
        }
        ArrEntry<K, E> newEntry = (ArrEntry) entry;
        array[n++] = newEntry;
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K, E> newEntry = new ArrEntry<K, E>(k, e);
        insert(newEntry);
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

    public void bubbleSort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i].getKey().compareTo(array[j].getKey()) > 0) {
                    ArrEntry temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
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

}
