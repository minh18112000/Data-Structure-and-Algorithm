package DSAA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai2 {
	public static void print(int[] a) {
		System.out.println("Mang da nhap la: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void search(int m, int[] a) {
		int count = 0;
		List<Integer> index = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == m) {
				count++;
				index.add(i);
			}
		}
		if (count == 0) {
			System.out.println("Khong tim thay phan tu nay trong mang");
		} else {
			System.out.println("Phan tu xuat hien " + count + " lan trong mang");
			System.out.print("Vi tri cua phan tu: ");
			for (int i = 0; i < index.size(); i++) {
				System.out.print(index.get(i) + " ");
			}
		}
	}

	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		System.out.println("Mang sau khi da sap xep: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		print(a);
		System.out.println("");
		System.out.println("Tim kiem phan tu ");
		int m = sc.nextInt();
		search(m, a);
		System.out.println("");
		sort(a);
	}
}
