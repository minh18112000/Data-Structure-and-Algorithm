package hw3_18001163;

import java.util.Random;
import java.util.Scanner;

public class SimpleLinkedListTest<T> {
	public static void main(String[] args) {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("Nhap so phan tu cua day: ");
		int size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			list.add(rd.nextInt(50));
		}
		list.printList();
		System.out.println("");
		System.out.println(list.get(2));
		list.set(0, 2);
		System.out.println(list.isContain(0));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.printList();
		list.removeTop();
		list.removeBot();
		System.out.println("");
		list.printList();
		System.out.println("");
		list.remove(30);
		list.printList();
	}

}
