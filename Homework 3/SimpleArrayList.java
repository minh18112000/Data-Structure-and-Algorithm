package hw3_18001163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleArrayList<T> implements ListInterface<T> {
	private T[] array;
	private int n = 0;
	private int defaultSize = 100000;

	public SimpleArrayList() {
		array = (T[]) new Object[defaultSize];
	}

	public SimpleArrayList(int capacity) {
		array = (T[]) new Object[capacity];
		this.defaultSize = capacity;
	}

	public void add(T data) {
		if (n >= defaultSize) {
			return;
		} else {
			array[n++] = data;
		}

	}

	public T get(int i) {
		if (i > n - 1 || i < 0) {
			return null;
		} else
			return array[i];
	}

	public void set(int i, T data) {
		if (i > n - 1 || i < 0) {
			return;
		} else
			array[i] = data;
	}

	public void remove(T data) {
		if (n == 0)
			return;
		for (int i = 0; i < n; i++) {
			if (array[i] == data) {
				for (int j = i + 1; j < n; j++) {
					array[j - 1] = array[j];
				}
				n--;
				i--;
			}
		}
	}

	public boolean isContain(T data) {
		if (n == 0)
			return false;
		for (int i = 0; i < n; i++) {
			if (array[i].equals(data)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		if (n == 0)
			return true;
		return false;

	}

	public Iterator<T> iterator() {

		return new Iterator<T>() {
			int curentIndex = 0;

			@Override
			public boolean hasNext() {
				return curentIndex < n;
			}

			@Override
			public T next() {
				return array[curentIndex++];
			}
		};
	}

	public int indexOf(T data, int index) {
		if (isEmpty() || index >= n || index < 0) {
			return -1;
		} else {
			for (int i = index; i < n; i++) {
				if (array[i].equals(data)) {
					return i;
				}
			}
			return -1;
		}

	}

	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
