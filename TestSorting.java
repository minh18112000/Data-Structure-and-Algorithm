package DSAA;

import java.util.Scanner;

public class TestSorting {
	// Lop test cua bai 1, 2, 3, 4

	public static void main(String[] args) {
		BubbleSort bullel = new BubbleSort();
		bullel.inputList();
//		bullel.inpuList1();      Viec goi den ham nay chi dung cho Bai 4
		System.out.println("============Bubbel Sort===========");
		double[] list = bullel.getList();
		long start = System.nanoTime();
		bullel.sortList();
		long end = System.nanoTime();
		System.out.println("Thoi gian sap xep: " + ((double) (end - start) / 100000));

		System.out.println("============Select Sort===========");
		SelectSort select = new SelectSort();
		select.setList(list);
		start = System.nanoTime();
		select.sortList();
		end = System.nanoTime();
		System.out.println("Thoi gian sap xep: " + ((double) (end - start) / 100000));

		System.out.println("============Insert Sort===========");
		InsertSort insert = new InsertSort();
		insert.setList(list);
		start = System.nanoTime();
		insert.sortList();
		end = System.nanoTime();
		System.out.println("Thoi gian sap xep: " + ((double) (end - start) / 100000));
	}
}
