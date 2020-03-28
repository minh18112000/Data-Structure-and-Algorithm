package DSAA;

public class Bai5InsertSorting<T> {
//	Bai 5 voi kieu sap xep chen
	private long nchange;
	private long ncompare;

	public <T extends Comparable<T>> T[] bubbleSort(T[] a) {
		ncompare = 0;
		nchange = 0;
		System.out.println("Thu tu cua mang sau moi vong lap: ");
		for (int i = 1; i < a.length; i++) {
			T next = a[i];
			int j;
			for (j = i - 1; j >= 0 && a[j].compareTo(next) > 0; j--) {
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

	public static void main(String[] args) {
		Bai5InsertSorting<Integer> list = new Bai5InsertSorting<Integer>();
		Integer[] a = { 25, 21, 36, 64, 44, 76 };
		Double[] array = { 25.0, 21.0, 36.0, 64.0, 44.0, 76.0 };
		String[] array1 = { "a", "h", "j", "m", "b", "z", "y" };
		System.out.println("Array after sorting: ");
		long start = System.nanoTime();
		list.bubbleSort(a);
		long end = System.nanoTime();
		System.out.println("Thoi gian sap xep: " + ((double) (end - start) / 100000));
	}
}
