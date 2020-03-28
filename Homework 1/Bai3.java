package DSAA;

import java.util.Scanner;

public class Bai3 {
	public static void print(float a1, float b1, float a2, float b2) {
		System.out.println("So phuc thu 1: " + a1 + " + " + b1 + "i");
		System.out.println("So phuc thu 2: " + a2 + " + " + b2 + "i");
	}

	public static void add(float a1, float b1, float a2, float b2) {
		System.out.println("Tong cua 2 so phuc la: " + (a1 + a2) + " + " + (b1 + b2) + "i");
	}

	public static void mul(float a1, float b1, float a2, float b2) {
		System.out.println("Tich cua 2 so phuc la: " + (a1 * a2 - b1 * b2) + " + " + (a1 * b2 + a2 * b1) + "i");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap phan thuc, ao cua so thu 1");
		float a1 = sc.nextFloat();
		float b1 = sc.nextFloat();
		System.out.println("Nhap phan thuc, ao cua so thu 2");
		float a2 = sc.nextFloat();
		float b2 = sc.nextFloat();
		print(a1, b1, a2, b2);
		add(a1, b1, a2, b2);
		mul(a1, b1, a2, b2);
	}
}
