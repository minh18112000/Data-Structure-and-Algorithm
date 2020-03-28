package DSAA;

public class Bai5BubbleSort<T> {
	// Bai 5 voi kieu sap xep noi bot
	private long nchange;
	private long ncompare;

	public <T extends Comparable<T>> T[] bubbleSort(T[] a) {
		ncompare = 0;
		nchange = 0;
		System.out.println("Thu tu cua mang sau moi vong lap: ");
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 1; j < a.length - i; j++) {
				ncompare++;
				if (a[j - 1].compareTo(a[j]) > 0) {
					nchange++;
					T temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}

			for (int n = 0; n < a.length; n++) {
				System.out.print(a[n] + " ");
			}
			System.out.println("");
		}
		System.out.println("So lan so sanh: " + ncompare);
		System.out.println("So lan doi cho: " + nchange);
		return a;
	}

	public static void main(String[] args) {
		Bai5BubbleSort<Integer> list = new Bai5BubbleSort<Integer>();
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
