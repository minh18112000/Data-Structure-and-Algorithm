package hw5_18001163;

import java.io.FileWriter;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
	private E[] array;
	private int n = 0;
	private static int defaultsize = 100;

	public ArrayBinaryTree() {
		this(defaultsize);
	}

	public ArrayBinaryTree(int capacity) {
		array = (E[]) new Object[capacity];
	}

	// update methods
	public void setRoot(E element) {
		array[0] = element;
		if (n == 0)
			n++;
	}

	public void setLeft(int p, E element) {
		if (p < 0 || 2 * p + 1 >= array.length || array[p] == null)
			return;
		if (array[2 * p + 1] == null)
			n++;
		array[2 * p + 1] = element;

	}

	public void setRight(int p, E element) {
		if (p < 0 || 2 * p + 2 >= array.length || array[p] == null)
			return;
		if (array[2 * p + 2] == null)
			n++;
		array[2 * p + 2] = element;
	}

	@Override
	public T root() {
		return (T) Integer.valueOf(0);
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public int numChildren(T p) {
		if (!(p instanceof Integer))
			return -1;
		if (isEmpty()) {
			return -1;
		}
		int count = 0;
		int pos = (int) p;
		if (pos < 0 || pos >= array.length || array[pos] == null)
			return -1;
		if (left(p) != null)
			count++;
		if (right(p) != null)
			count++;
		return count;

	}

	@Override
	public T parent(T p) {
		if (!(p instanceof Integer))
			return null;
		if (n == 0)
			return null;
		int pos = (int) p;
		int posParent;
		if (pos <= 0 || pos >= array.length || array[pos] == null)
			return null;
		if (pos % 2 != 0) {
			posParent = (pos - 1) / 2;
			if (array[posParent] == null)
				return null;
		} else {
			posParent = (pos - 2) / 2;
			if (array[posParent] == null)
				return null;
		}
		return (T) Integer.valueOf(posParent);

	}

	@Override
	public T left(T p) {
		if (!(p instanceof Integer))
			return null;
		if (n == 0)
			return null;
		int indexP = (int) p;
		if (indexP < 0 || indexP >= array.length || array[indexP] == null)
			return null;
		if (array[2 * indexP + 1] == null)
			return null;
		else
			return (T) Integer.valueOf(2 * indexP + 1);
	}

	@Override
	public T right(T p) {
		if (!(p instanceof Integer))
			return null;
		if (n == 0)
			return null;
		int indexP = (int) p;
		if (indexP < 0 || indexP >= array.length || array[indexP] == null)
			return null;
		if (array[2 * indexP + 2] == null)
			return null;
		else
			return (T) Integer.valueOf(2 * indexP + 2);
	}

	@Override
	public T sibling(T p) {
		if (!(p instanceof Integer))
			return null;
		if (n == 0)
			return null;
		int indexP = (int) p;
		if (indexP <= 0 || indexP >= array.length || array[indexP] == null)
			return null;
		else {
			if (indexP % 2 != 0 && array[indexP + 1] != null) {
				return (T) Integer.valueOf(indexP + 1);
			}
			if (indexP % 2 == 0 && array[indexP - 1] != null) {
			}
			return (T) Integer.valueOf(indexP - 1);
		}
	}

	public E getValue(T p) {
		if (!(p instanceof Integer))
			return null;
		int pos = (int) p;
		if (pos < 0 || pos >= array.length || array[pos] == null)
			return null;
		return array[pos];
	}

	// print binary tree to console and file output.txt
	public void print(int root, int level, FileWriter writeFile) {
		try {
			if (root < 0 || root > n || array[root] == null)
				return;
			print(root * 2 + 2, level + 1, writeFile);
			for (int i = 1; i < level; i++) {
				System.out.print("\t");
				writeFile.write("\t");
			}
			System.out.println(array[root]);
			writeFile.write(String.valueOf(array[root]) + "\n");
			print(root * 2 + 1, level + 1, writeFile);
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
