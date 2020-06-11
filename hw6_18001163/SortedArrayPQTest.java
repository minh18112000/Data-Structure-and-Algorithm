package hw6_18001163;

import java.util.Random;

import hw6_18001163.SortedArrayPriorityQueue.ArrEntry;

public class SortedArrayPQTest {
    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> sortArrayPQ = new SortedArrayPriorityQueue<>(1000000);
        System.out.println(sortArrayPQ.isEmpty());
        ArrEntry<Integer, String> entry1 = new ArrEntry(1, "A");
        ArrEntry<Integer, String> entry2 = new ArrEntry(5, "A");
        sortArrayPQ.insert(entry1);
        sortArrayPQ.insert(entry2);
        sortArrayPQ.insert(3, "A");
        sortArrayPQ.insert(4, "A");
        sortArrayPQ.insert(10, "A");
        sortArrayPQ.print();
        System.out.println();
        System.out.println(sortArrayPQ.size());
        System.out.println(sortArrayPQ.isEmpty());
        System.out.println(sortArrayPQ.min().getKey());
        System.out.println(sortArrayPQ.removeMin().getKey());
        sortArrayPQ.insert(5, "A");
        System.out.println(sortArrayPQ.size());
        System.out.println(sortArrayPQ.min().getKey());
        sortArrayPQ.print();
        // Random rd = new Random();
        // int n = 1000;
        // for (int i = 0; i < n; i++) {
        // sortArrayPQ.insert(0, "a");
        // }
        // long start = System.nanoTime();
        // for (int i = 0; i < n; i++) {
        // sortArrayPQ.min();
        // }
        // long end = System.nanoTime();
        // System.out.println("Thoi gian: " + ((double) (end - start) / 1000000) + "ms");
    }
}