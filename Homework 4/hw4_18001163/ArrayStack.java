package hw4_18001163;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
	private static int defaultSize = 1000;
	private E[] array;
	private int n = 0;

	public ArrayStack(int capacity) {
		array = (E[]) new Object[capacity];
		this.defaultSize = capacity;
	}

	public ArrayStack() {
		this(defaultSize);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int currentIndex = n - 1;

			@Override
			public boolean hasNext() {
				return currentIndex >= 0;
			}

			@Override
			public E next() {
				return array[currentIndex--];
			}
		};
	}

	@Override
	public void push(E element) {
		if (n >= defaultSize)
			return;
		array[n++] = element;
	}

	@Override
	public E pop() {
		if (n == 0)
			return null;
		E temp = array[n - 1];
		array[n - 1] = null;
		n--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public E top() {
		if (n == 0)
			return null;
		return array[n - 1];
	}

	public void printArray() {
		Iterator<E> ite = iterator();
		while (ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}

	}

}
