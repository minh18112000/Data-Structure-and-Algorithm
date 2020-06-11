package hw7_18001163;

import hw7_18001163.SortedArrayList.ArrEntry;

public class SortedArrayListTest {
    public static void main(String[] args) {
        SortedArrayList<Integer, String> sortedArrayList = new SortedArrayList<>();
        ArrEntry<Integer, String> entry1 = new ArrEntry(10, "A");
        sortedArrayList.insert(entry1);
        sortedArrayList.insert(30, "C");
        sortedArrayList.insert(50, "E");
        sortedArrayList.insert(20, "B");
        sortedArrayList.print();
        System.out.println("");
        System.out.println(sortedArrayList.search(30));
        sortedArrayList.print();
        System.out.println("");
        System.out.println(sortedArrayList.binarySearch(0, 3, 20));
    }
}