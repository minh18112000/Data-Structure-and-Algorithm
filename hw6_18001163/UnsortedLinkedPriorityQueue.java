package hw6_18001163;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    static protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E value;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
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

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void insert(Entry entry) {
        NodeEntry<K, E> newEntry = (NodeEntry) entry;
        if (head == null && tail == null) {
            head = tail = newEntry;
        } else {
            tail.next = newEntry;
            newEntry.next = null;
            tail = newEntry;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newEntry = new NodeEntry<K, E>(k, e);
        if (head == null && tail == null) {
            head = tail = newEntry;
        } else {
            tail.next = newEntry;
            tail = newEntry;
        }
        n++;
    }

    @Override
    public Entry removeMin() {
        int min = findMin();
        if (min == -1) {
            return null;
        }
        if (min == (int) head.getKey()) {
            NodeEntry<K, E> entryRemoved = new NodeEntry(head.getKey(), head.getValue());
            head = null;
            head = head.next;
            n--;
            return entryRemoved;
        }
        NodeEntry<K, E> currentEntry = head;
        if (currentEntry != null) {
            while (currentEntry.next != null) {
                if ((int) currentEntry.next.getKey().compareTo(min) == 0) {
                    NodeEntry<K, E> entryRemoved = new NodeEntry(currentEntry.next.getKey(), currentEntry.next.getValue());
                    if (currentEntry.next == tail) {
                        currentEntry.next = null;
                        tail = currentEntry;
                        n--;
                        return entryRemoved;
                    } else {
                        currentEntry.next = currentEntry.next.next;
                        n--;
                        return entryRemoved;
                    }
                } else {
                    currentEntry = currentEntry.next;
                }
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
        if (min == (int) head.getKey()) {
            return head;
        }
        if (min == (int) tail.getKey()) {
            return tail;
        }
        NodeEntry<K, E> currentEntry = head;
        while (currentEntry.next != null) {
            if ((int) currentEntry.next.getKey() == min) {
                return currentEntry.next;
            }
            currentEntry = currentEntry.next;
        }
        return null;
    }

    public int findMin() {
        if (head == null && tail == null)
            return -1;
        NodeEntry<K, E> currentEntry = head;
        K min = currentEntry.getKey();
        while (currentEntry != null) {
            K keyEntry = currentEntry.getKey();
            if (keyEntry.compareTo(min) < 0) {
                min = keyEntry;
            }
            currentEntry = currentEntry.next;
        }
        return (int) min;
    }

    public void print() {
        NodeEntry<K, E> nodeEntry = head;
        while (nodeEntry != null) {
            System.out.print(nodeEntry.getKey() + " ");
            nodeEntry = nodeEntry.next;
        }
    }
}