package hw4_18001163;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
	class Node {
		E element;
		Node next;

		public Node(E element) {
			this.element = element;
			this.next = next;
		}
	}

	private Node stack = null;
	private int n;

	@Override
	public void push(E element) {
		Node newNode = new Node(element);
		n++;
		if (stack == null)
			stack = newNode;
		else {
			newNode.next = stack;
			stack = newNode;
		}
	}

	@Override
	public E pop() {
		if (n == 0)
			return null;
		else {
			E temp = stack.element;
			stack.element = null;
			stack = stack.next;
			n--;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
// Kiểm tra stack rỗng
		return stack == null;
	}

	@Override
	public E top() {
// Lấy giá trị phần tử đầu tiên của stack
		if (n == 0)
			return null;
		return stack.element;
	}

	public void printLinkedList() {
		Iterator<E> ite = iterator();
		while (ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	class StackIterator implements Iterator<E> {
		private Node currentNode = stack;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public E next() {
			E data = currentNode.element;
			currentNode = currentNode.next;
			return data;

		}
	}
}