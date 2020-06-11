package hw7_18001163;

public class SortedLinkedList<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

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
    public Entry<K, E> removeMin() {
        if (head == null && tail == null) {
            return null;
        }
        NodeEntry<K, E> nodeEntry = new NodeEntry<K, E>(head.getKey(), head.getValue());
        head.setKey(null);
        head.setValue(null);
        head = head.next;
        n--;
        return nodeEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (head == null && tail == null) {
            return null;
        }
        return head;
    }

    public void print() {
        NodeEntry<K, E> nodeEntry = head;
        while (nodeEntry != null) {
            System.out.print(nodeEntry.getKey() + " ");
            nodeEntry = nodeEntry.next;
        }
    }

    public K search(K key) {
        if (n == 0)
            return null;
        NodeEntry<K, E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getKey().compareTo(key) == 0) {
                return key;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> newEntry = (NodeEntry) entry;
        NodeEntry<K, E> nodeEntry = head;
        if (head == null && tail == null) {
            head = newEntry;
            tail = newEntry;
        } else if (nodeEntry.getKey().compareTo(newEntry.getKey()) > 0) {
            newEntry.next = head;
            head = newEntry;
        } else {
            while (nodeEntry != null) {
                if (nodeEntry.next != null) {
                    if (nodeEntry.next.getKey().compareTo(newEntry.getKey()) > 0) {
                        NodeEntry<K, E> nextNode = nodeEntry.next;
                        nodeEntry.next = newEntry;
                        newEntry.next = nextNode;
                        break;
                    }
                    nodeEntry = nodeEntry.next;
                } else {
                    tail.next = newEntry;
                    tail = newEntry;
                    break;
                }
            }
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newEntry = new NodeEntry<K, E>(k, e);
        insert(newEntry);
    }

}
