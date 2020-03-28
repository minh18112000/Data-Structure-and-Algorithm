package DSAA;

import java.util.Random;
import java.util.Scanner;

public class InsertSort {
	// Bai 3

	private double[] list;
	private long nchange;
	private long ncompare;

	public InsertSort() {

	}

	public InsertSort(double[] list) {
		this.list = list;
	}

	public long getNchange() {
		return nchange;
	}

	public long getNcompare() {
		return ncompare;
	}

	public double[] getList() {
		return list;
	}

	public void setList(double[] list) {
		this.list = list;
	}

	public void inputList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap kich thuoc mang: ");
		int size = sc.nextInt();
		Random rd = new Random();
		list = new double[size];
		for (int i = 0; i < list.length; i++) {
			list[i] = Math.round(rd.nextDouble() * 100);
		}
	}

	// Ham nay dung cho bai 4
	
//	public void inpuList1() {
//		double[] a = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
//		for (int i = 0; i < a.length; i++) {
//			list[i] = a[i];
//		}
//	}

	public double[] sortList() {
		ncompare = 0;
		nchange = 0;
		double[] a = new double[list.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = list[i];
		}
		System.out.println("Thu tu cua mang sau moi vong lap: ");
		for (int i = 1; i < a.length; i++) {
			double next = a[i];
			int j;
			for (j = i - 1; j >= 0 && a[j] > next; j--) {
				a[j + 1] = a[j];
				ncompare++;
			}
			a[j + 1] = next;
			nchange++;
			for (int m = 0; m < a.length; m++) {
				System.out.print(a[m] + " ");
			}
			System.out.println("");
		}
		System.out.println("So lan so sanh: " + ncompare);
		System.out.println("So lan doi cho: " + nchange);
		return a;
	}
}
