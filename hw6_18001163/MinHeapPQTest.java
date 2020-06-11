package hw6_18001163;

import hw6_18001163.SortedArrayPriorityQueue.ArrEntry;

public class MinHeapPQTest {
    public static void main(String[] args) {
        MinHeapPriorityQueue minHeapPQ = new MinHeapPriorityQueue<>();
        System.out.println(minHeapPQ.isEmpty());
        ArrEntry<Integer,String> entry1 = new ArrEntry(1, "A");      
        minHeapPQ.insert(entry1);
        minHeapPQ.insert(6, "E");
        minHeapPQ.insert(3, "C");
        minHeapPQ.insert(5, "H");
        minHeapPQ.insert(15, "K");
        minHeapPQ.insert(7, "K");
        minHeapPQ.insert(4, "K");   
        minHeapPQ.insert(11, "K");   
        minHeapPQ.insert(16, "K");   
        minHeapPQ.print();
        System.out.println(minHeapPQ.isEmpty());
        System.out.println(minHeapPQ.size());
        System.out.println(minHeapPQ.removeMin().getKey());
        System.out.println(minHeapPQ.size());
        System.out.println(minHeapPQ.min().getKey());
        minHeapPQ.print();
    }
}