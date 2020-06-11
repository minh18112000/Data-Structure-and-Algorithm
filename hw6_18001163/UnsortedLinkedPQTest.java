package hw6_18001163;

import java.util.Random;
import hw6_18001163.UnsortedLinkedPriorityQueue.NodeEntry;

public class UnsortedLinkedPQTest {
    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, String> usLinkedPQ = new UnsortedLinkedPriorityQueue<>();
        System.out.println(usLinkedPQ.isEmpty());
        NodeEntry<Integer, String> entry1 = new NodeEntry(7, "A");
        usLinkedPQ.insert(entry1);
        usLinkedPQ.insert(5, "E");
        usLinkedPQ.insert(4, "H");
        usLinkedPQ.insert(1, "K");
        usLinkedPQ.print();
        System.out.println(usLinkedPQ.isEmpty());
        System.out.println(usLinkedPQ.size());
        System.out.println(usLinkedPQ.removeMin().getKey());
        System.out.println(usLinkedPQ.size());
        usLinkedPQ.print();
        usLinkedPQ.insert(2, "C");
        usLinkedPQ.insert(10, "C");
        System.out.println("");
        System.out.println(usLinkedPQ.size());
        System.out.println(usLinkedPQ.min().getKey());
        usLinkedPQ.print();
        // Random rd = new Random();
        // int n = 100000000;
        // long start = System.nanoTime();
        // for (int i = 0; i < n; i++) {
        // usLinkedPQ.insert(rd.nextInt(n), String.valueOf(i));
        // }
        // // for (int i = 0; i < n; i++) {
        // // usLinkedPQ.removeMin();
        // // }
        // long end = System.nanoTime();
        // System.out.println("Thoi gian: " + ((double) (end - start) / 1000000) +
        // "ms");
    }
}