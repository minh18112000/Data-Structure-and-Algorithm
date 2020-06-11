package hw7_18001163;

import hw7_18001163.UnSortedLinkedList.NodeEntry;;

public class UnSortedLinkedListTest {
    public static void main(String[] args) {
        UnSortedLinkedList<Integer, String> unSortLinkedList = new UnSortedLinkedList<>();
        NodeEntry<Integer, String> entry1 = new NodeEntry(70, "A");
        unSortLinkedList.insert(entry1);
        unSortLinkedList.insert(10, "K");
        unSortLinkedList.insert(50, "E");
        unSortLinkedList.insert(40, "H");
        unSortLinkedList.print();
        System.out.println("");
        System.out.println(unSortLinkedList.search(50));
    }
}