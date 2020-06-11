package hw4_18001163;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ArrayQueueTest {
	public static void main(String[] args) {
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		Scanner input = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("Nhap so phan tu cua day");
		int size = input.nextInt();
		for (int i = 0; i < size; i++) {
			arrayQueue.enqueue(rd.nextInt(50));
		}
		arrayQueue.printArray();
		System.out.println("");
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		System.out.println(arrayQueue.first());
		System.out.println(arrayQueue.isEmpty());
		arrayQueue.printArray();
	}

}
