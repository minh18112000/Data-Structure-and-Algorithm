package hw6_18001163;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {

    public MinHeapPriorityQueue(int capacity) {
        super(capacity);
    }

    public MinHeapPriorityQueue() {
        super();
    }

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int left(int i) {
        return 2 * i + 1;
    }

    protected int right(int i) {
        return i * 2 + 2;
    }

    protected boolean hasLeft(int i) {
        return left(i) < n;
    }

    protected boolean hasRight(int i) {
        return right(i) < n;
    }

    protected void upHeap(int i) {
        while (i > 0) {
            int parent = parent(i);
            if (array[i].getKey().compareTo(array[parent].getKey()) > 0) {
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    protected void downHeap(int i) {
        while (hasLeft(i)) {
            int leftIndex = left(i);
            int smallChildIndex = leftIndex;
            if (hasRight(i)) {
                int rightIndex = right(i);
                if (array[leftIndex].getKey().compareTo(array[rightIndex].getKey()) > 0) {
                    smallChildIndex = rightIndex;
                }
            }
            if (array[smallChildIndex].getKey().compareTo(array[i].getKey()) >= 0) {
                break;
            }
            swap(i, smallChildIndex);
            i = smallChildIndex;
        }
    }

    protected void swap(int i, int j) {
        ArrEntry<K, E> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void insert(Entry entry) {
        if (n >= defaultsize) {
            return;
        }
        ArrEntry<K, E> newEntry = (ArrEntry) entry;
        array[n++] = newEntry;
        if (n != 1) {
            upHeap(n - 1);
        }
    }

    @Override
    public void insert(K k, E e) {
        if (n >= defaultsize) {
            return;
        }
        ArrEntry<K, E> newEntry = new ArrEntry<>(k, e);
        array[n++] = newEntry;
        if (n != 1) {
            upHeap(n - 1);
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Entry min() {
        if (isEmpty())
            return null;
        return array[0];
    }

    @Override
    public Entry removeMin() {
        if (isEmpty())
            return null;
        ArrEntry<K, E> newEntry = array[0];
        swap(0, n - 1);
        array[n - 1] = null;
        --n;
        downHeap(0);
        return newEntry;
    }

    @Override
    public int size() {
        return n;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i].getKey() + " ");
        }
    }
}
