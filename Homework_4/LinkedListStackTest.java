package hw4_18001163;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class LinkedListStackTest {
	public static void main(String[] args) {
		LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
		Scanner input = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("Nhap so phan tu cua day: ");
		int size = input.nextInt();
		for (int i = 0; i < size; i++) {
			linkedListStack.push(rd.nextInt(50));
		}
		linkedListStack.printLinkedList();
		System.out.println("");
		System.out.println(linkedListStack.isEmpty());
		System.out.println(linkedListStack.top());
		linkedListStack.pop();
		linkedListStack.printLinkedList();
	}
}
