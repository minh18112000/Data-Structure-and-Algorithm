package hw4_18001163;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
	private E[] queue;
	private int n = 0;
	private int top = 0;
	private int count = 0;
	private int default_size = 100;

	public ArrayQueue(int capacity) {
		n = capacity;
		queue = (E[]) new Object[capacity];
	}

	public ArrayQueue() {
		n = default_size;
		queue = (E[]) new Object[default_size];
	}

	@Override
	public void enqueue(E element) {
// TODO Auto-generated method stub
		if (count == n)
			return;
		int avail = (top + count) % n;
		queue[avail] = element;
		count++;
	}

	@Override
	public E dequeue() {
// TODO Auto-generated method stub
		if (count == 0)
			return null;
		E element = queue[top];
		queue[top] = null;
		top = (top + 1) % n;
		count--;
		return element;
	}

	@Override
	public E first() {
		if (count == 0)
			return null;
		return queue[top];
	}

	@Override
	public boolean isEmpty() {
// TODO Auto-generated method stub

		return queue[top] == null;
	}

	@Override
	public Iterator<E> iterator() {
// TODO Auto-generated method stub
		return new ArrayQueueIterator();

	}

	class ArrayQueueIterator implements Iterator<E> {
		private int current = top;

		private int num = 0;

		@Override
		public boolean hasNext() {

// TODO Auto-generated method stub
			return num < count;

		}
		
		@Override
		public E next() {

// TODO Auto-generated method stub
			E data = queue[(current + num) % n];
			num++;
			return data;
		}
	}
	
	public void printArray() {
		Iterator<E> ite = iterator();
		while (ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}

	}


}