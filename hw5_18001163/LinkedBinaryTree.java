package hw5_18001163;

import java.io.FileWriter;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
	protected static class Node<E> {
		private E element; // an element stored at this node
		private Node<E> parent; // a reference to the parent node (if any)
		private Node<E> left; // a reference to the left child
		private Node<E> right; // a reference to the right child
		// Constructs a node with the given element and neighbors. ∗/

		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

	}

	private Node<E> root = null;
	private int size = 0;

	public Node<E> addRoot(E element) {
		// Add element to root of an empty tree
		if (root == null) {
			Node<E> newNode = new Node<E>(element, null, null, null);
			root = newNode;
			size++;
		} else {
			set(root, element);
		}
		return root;
	}

	public Node<E> addLeft(Node<E> p, E element) {
		// Add element to left child node of p if empty
		if (size == 0 || p == null)
			return null;
		if (p.getLeft() == null) {
			Node<E> child = new Node<E>(element, p, null, null);
			p.setLeft(child);
			size++;
		} else {
			set(p.getLeft(), element);
		}
		return p.getLeft();
	}

	public Node<E> addRight(Node<E> p, E element) {
		if (size == 0 || p == null)
			return null;
		if (p.getRight() == null) {
			Node<E> child = new Node<E>(element, p, null, null);
			p.setRight(child);
			size++;
		} else {
			set(p.getRight(), element);
		}
		return p.getRight();
	}

	public void set(Node<E> p, E element) {
		p.setElement(element);
	}

	@Override
	public T root() {
		return (T) root;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int numChildren(T p) {
		if (!(p instanceof Node))
			return -1;
		if (isEmpty() || p == null)
			return -1;
		int count = 0;
		if (left(p) != null)
			count++;
		if (right(p) != null)
			count++;
		return count;
	}

	@Override
	public T parent(T p) {
		if (!(p instanceof Node))
			return null;
		if (isEmpty())
			return null;
		Node<E> newNode = (Node<E>) p;
		if (newNode != null && newNode.getParent() != null) {
			return (T) newNode.getParent();
		}
		return null;
	}

	@Override
	public T left(T p) {
		if (!(p instanceof Node))
			return null;
		if (isEmpty())
			return null;
		Node<E> newNode = (Node<E>) p;
		if (newNode != null && newNode.getLeft() != null) {
			return (T) newNode.getLeft();
		}
		return null;
	}

	@Override
	public T right(T p) {
		if (!(p instanceof Node))
			return null;
		if (isEmpty())
			return null;
		Node<E> newNode = (Node<E>) p;
		if (newNode != null && newNode.getRight() != null) {
			return (T) newNode.getRight();
		}
		return null;
	}

	@Override
	public T sibling(T p) {
		if (!(p instanceof Node))
			return null;
		if (isEmpty() || p == null)
			return null;
		Node<E> node = (Node<E>) p;
		if (node.getParent() != null) {
			T nodeParent = (T) node.getParent();
			if (numChildren(nodeParent) != 2) {
				return null;
			} else {
				Node<E> left = node.parent.getLeft();
				if (left.getElement() == node.getElement())
					return (T) node.parent.getRight();
				Node<E> right = node.parent.getRight();
				if (right.getElement() == node.getElement())
					return (T) node.parent.getLeft();
			}
		}
		return null;
	}

	// print binary tree to console and file output.txt
	public void print(Node p, int level, FileWriter writeFile) {
		try {
			if (p == null)
				return;
			print(p.getRight(), level + 1, writeFile);
			for (int i = 1; i < level; i++) {
				System.out.print("\t");
				// write to file
				writeFile.write("\t");
			}
			System.out.println(p.getElement());
			// write to file
			writeFile.write(String.valueOf(p.getElement()) + "\n");
			print(p.getLeft(), level + 1, writeFile);

		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}