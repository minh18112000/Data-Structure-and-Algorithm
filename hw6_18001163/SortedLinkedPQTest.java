package hw6_18001163;

import hw6_18001163.SortedLinkedPriorityQueue.NodeEntry;

public class SortedLinkedPQTest {
    public static void main(String[] args) {
        SortedLinkedPriorityQueue<Integer, String> sortedLinkedPQ = new SortedLinkedPriorityQueue<>();
        System.out.println(sortedLinkedPQ.isEmpty());
        NodeEntry<Integer,String> entry1 = new NodeEntry(1, "A");      
        sortedLinkedPQ.insert(entry1);
        sortedLinkedPQ.insert(5, "E");
        sortedLinkedPQ.insert(3, "C");
        sortedLinkedPQ.insert(4, "H");
        sortedLinkedPQ.insert(10, "K");
        System.err.println();
        sortedLinkedPQ.print();
        System.out.println(sortedLinkedPQ.isEmpty());
        System.out.println(sortedLinkedPQ.size());
        System.out.println(sortedLinkedPQ.removeMin().getKey());
        System.out.println(sortedLinkedPQ.size());
        System.out.println(sortedLinkedPQ.min().getKey());
        sortedLinkedPQ.print();
        // Random rd = new Random();
        // int n = 1000;
        // long start = System.nanoTime();
        // for (int i = 0; i < n; i++) {
        // usLinkedPQ.insert(rd.nextInt(n), String.valueOf(i));
        // }
        // for (int i = 0; i < n; i++) {
        // usLinkedPQ.removeMin();
        // }
        // long end = System.nanoTime();
        // System.out.println("Thoi gian: " + ((double) (end - start) / 1000000) + "ms");
    }
}