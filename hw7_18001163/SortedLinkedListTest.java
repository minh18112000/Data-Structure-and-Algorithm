package hw7_18001163;

import hw7_18001163.SortedLinkedList.NodeEntry;;

public class SortedLinkedListTest {
    public static void main(String[] args) {
        SortedLinkedList<Integer, String> sortedLinkedList = new SortedLinkedList<>();
        NodeEntry<Integer, String> entry1 = new NodeEntry(10, "A");
        sortedLinkedList.insert(entry1);
        sortedLinkedList.insert(50, "E");
        sortedLinkedList.insert(30, "C");
        sortedLinkedList.insert(40, "H");
        sortedLinkedList.insert(90, "K");
        sortedLinkedList.print();
        System.out.println("");
        System.out.println(sortedLinkedList.search(50));
    }
}