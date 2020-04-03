package hw3_18001163;

import java.util.Scanner;

public class TestComplex {
	public static void main(String[] args) {
		TestComplex textComplex = new TestComplex();
		Complex complex;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n: ");
		int n = sc.nextInt();
		Complex[] complexs = new Complex[n];
		System.out.println("Nhap day n so phuc: ");
		for (int i = 0; i < n; i++) {
			float real = sc.nextFloat();
			float image = sc.nextFloat();
			complexs[i] = new Complex(real, image);
		}
		System.out.println("Nhap vi tri can tim so phuc: ");
		int v = sc.nextInt();
		textComplex.printComplex(complexs, v);
		complex = textComplex.sumComplex(complexs);
		System.out.println("Tong cua n so phuc: " + complex.toString());
	}

	public void printComplex(Complex[] complexs, int v) {
		for (int i = 0; i < complexs.length; i++) {
			if (i == v)
				System.out.println(complexs[v].toString());
		}
	}

	public Complex sumComplex(Complex[] complexs) {
		int sumReal = 0, sumImage = 0;
		for (int i = 0; i < complexs.length; i++) {
			sumImage += complexs[i].getImage();
			sumReal += complexs[i].getReal();
		}
		return new Complex(sumReal, sumImage);
	}
}
