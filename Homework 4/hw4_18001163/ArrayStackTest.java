package hw4_18001163;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ArrayStackTest {
	public static void main(String[] args) {
		ArrayStack<Integer> arrayStack = new ArrayStack<>();
		Scanner input = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("Nhap so phan tu cua day: ");
		int size = input.nextInt();
		for (int i = 0; i < size; i++) {
			arrayStack.push(rd.nextInt(50));
		}
		arrayStack.printArray();
		System.out.println("");
		System.out.println(arrayStack.isEmpty());
		System.out.println(arrayStack.top());
		arrayStack.pop();
		arrayStack.printArray();
		System.out.println("");
	}
}
