package hw7_18001163;

import hw7_18001163.UnSortedArrayList.ArrEntry;

public class UnSortedArrayListTest {
    public static void main(String[] args) {
        UnSortedArrayList<Integer, String> unSortedArrayList = new UnSortedArrayList<>();
        ArrEntry<Integer, String> entry1 = new ArrEntry(10, "A");
        unSortedArrayList.insert(entry1);
        unSortedArrayList.insert(30, "C");
        unSortedArrayList.insert(50, "E");
        unSortedArrayList.insert(20, "B");
        unSortedArrayList.print();
        System.out.println("");
        System.out.println(unSortedArrayList.search(50));
        unSortedArrayList.bubbleSort();
        unSortedArrayList.print();
        System.out.println("");
        System.out.println(unSortedArrayList.binarySearch(0, 3, 20));
    }
}