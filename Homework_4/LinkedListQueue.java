package hw4_18001163;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
	class Node {
		E element;
		Node next;

		public Node(E element) {
			this.element = element;
		}
	}

	private Node head = null;
	private Node tail = null;

	@Override
	public void enqueue(E element) {
		Node newNode = new Node(element);
		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}

	}

	@Override
	public E dequeue() {
		if (head == null && tail == null)
			return null;
		E elemeny = head.element;
		head.element = null;
		head = head.next;
		return null;
	}

	@Override
	public boolean isEmpty() {
		return head == null && tail == null;
	}

	@Override
	public E first() {
		if (head == null && tail == null)
			return null;
		return head.element;
	}

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	class QueueIterator implements Iterator<E> {
		Node currentNode = head;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public E next() {
			E element = currentNode.element;
			currentNode = currentNode.next;
			return element;
		}

	}

	public void printLinkedList() {
		Iterator<E> ite = iterator();
		while (ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}

	}
}
