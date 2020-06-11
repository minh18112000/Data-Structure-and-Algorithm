package hw5_18001163;

import java.io.FileWriter;

public class ArrayBinaryTreeTest {
	public static void main(String[] args) {
		ArrayBinaryTree<Integer, Integer> array = new ArrayBinaryTree<Integer, Integer>();
		array.setRoot(10);
		array.setLeft(0, 5);
		array.setRight(0, 6);
		System.out.println(array.getValue(array.parent(1)));
		System.out.println(array.getValue(array.sibling(2)));
		System.out.println(array.getValue(array.left(0)));
		System.out.println(array.size());
		System.out.println(array.getValue(array.root()));
		System.out.println(array.isEmpty());
		try {
			// create a file: "output.txt" to print tree
			FileWriter writeFile = new FileWriter("output.txt");
			// call method print() in class ArrayBinaryTree to print binary tree with default pos root = 0, level = 1
			array.print(0, 1, writeFile);
			writeFile.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}
