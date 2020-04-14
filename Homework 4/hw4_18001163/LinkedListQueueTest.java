package hw4_18001163;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class LinkedListQueueTest {
	public static void main(String[] args) {
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		Scanner input = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("Nhap so phan tu cua day");
		int size = input.nextInt();
		for (int i = 0; i < size; i++) {
			linkedListQueue.enqueue(rd.nextInt(50));
		}
		linkedListQueue.printLinkedList();
		System.out.println("");
		linkedListQueue.dequeue();
		linkedListQueue.dequeue();
		System.out.println(linkedListQueue.first());
		System.out.println(linkedListQueue.isEmpty());
		linkedListQueue.printLinkedList();
	}
}
