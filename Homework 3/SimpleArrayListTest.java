package hw3_18001163;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class SimpleArrayListTest {
	public static void main(String[] args) {
		SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList<>(10);
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("Nhap so phan tu cua day: ");
		int size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			simpleArrayList.add(rd.nextInt(50));
		}
		simpleArrayList.print();
		System.out.println("");
		System.out.println(simpleArrayList.get(2));
		simpleArrayList.set(0, 7);
		simpleArrayList.print();
		System.out.println("");
		simpleArrayList.remove(3);
		simpleArrayList.print();
		System.out.println("");
		System.out.println(simpleArrayList.isContain(10));
		System.out.println(simpleArrayList.isEmpty());
		System.out.println(simpleArrayList.size());
		Iterator<Integer> a = simpleArrayList.iterator();
		while (a.hasNext()) {
			System.out.print(a.next() + " ");
		}
	}
}
