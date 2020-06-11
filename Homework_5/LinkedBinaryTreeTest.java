package hw5_18001163;

import hw5_18001163.LinkedBinaryTree.Node;
import java.io.FileWriter;

public class LinkedBinaryTreeTest {
	public static void main(String[] args) {
		LinkedBinaryTree<Integer, Node> linked = new LinkedBinaryTree<>();
			Node<Integer> root = linked.addRoot(1);
			Node<Integer> left = linked.addLeft(root, 2);
			Node<Integer> right = linked.addRight(root, 3);
			System.out.println(linked.isEmpty());
			System.out.println(linked.size());
			System.out.println(linked.parent(right).getElement());
			System.out.println(linked.right(root).getElement());
			System.out.println(linked.numChildren(root));
			System.out.println(linked.sibling(left).getElement());
		try {
			// create a file: "output.txt" to print tree
			FileWriter writeFile = new FileWriter("output.txt");	
			// call method print() in class LinkedBinaryTree to print binary tree with default Node root = root, level = 1		
			linked.print(root, 1, writeFile);
			writeFile.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}
