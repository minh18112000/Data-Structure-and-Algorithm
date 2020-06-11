package hw6_18001163;

import java.util.Random;
import java.util.Scanner;

import hw6_18001163.UnsortedArrayPriorityQueue.ArrEntry;

public class UnsortedArrayPQTest {
    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, String> usArrayPQ = new UnsortedArrayPriorityQueue<>(100000);
        ArrEntry<Integer, String> entry1 = new ArrEntry(1, "A");
        usArrayPQ.insert(entry1);
        usArrayPQ.insert(3, "C");
        usArrayPQ.insert(5, "E");
        usArrayPQ.insert(2, "B");
        usArrayPQ.print();
        System.out.println();
        System.out.println(usArrayPQ.isEmpty());
        System.out.println(usArrayPQ.size());
        System.out.println(usArrayPQ.removeMin().getKey());
        System.out.println(usArrayPQ.min().getKey());
        System.out.println(usArrayPQ.size());
        usArrayPQ.print();
        Scanner sc = new Scanner(System.in);
        // Random rd = new Random();
        // int n = 1000;
        // for (int i = 0; i < n; i++) {
        // usArrayPQ.insert(rd.nextInt(n), String.valueOf(i));
        // }
        // long start = System.nanoTime();
        // for (int i = 0; i < n; i++) {
        // usArrayPQ.removeMin();
        // }
        // long end = System.nanoTime();
        // System.out.println("Thoi gian: " + ((double) (end - start) / 1000000) + "ms");
    }
}