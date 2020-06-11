package hw5_18001163;

import java.util.ArrayList;
import java.util.List;

import hw5_18001163.LinkedBinaryTree.Node;

public class ExpressionTreeTest {
	public static void main(String[] args) {
		List<Node<String>> listNode = new ArrayList<>();
		ExpressionTree<String> tree = new ExpressionTree<>();
		Node<String> n0 = tree.addRoot("*");
		Node<String> n1 = tree.addLeft(n0, "+");
		Node<String> n2 = tree.addRight(n0, "-");
		Node<String> n3 = tree.addLeft(n1, "+");
		Node<String> n4 = tree.addRight(n1, "-");
		Node<String> n5 = tree.addLeft(n2, "*");
		Node<String> n6 = tree.addRight(n2, "+");
		tree.addLeft(n3, "1");
		tree.addRight(n3, "2");
		tree.addLeft(n4, "3");
		tree.addRight(n4, "4");
		tree.addLeft(n5, "5");
		tree.addRight(n5, "6");
		tree.addLeft(n6, "7");
		tree.addRight(n6, "8");
		tree.preorderPrint(n0);
		System.out.println("");
		tree.postorderPrint(n0);
		System.out.println("");
		tree.inorderPrint(n0);
		System.out.println("");
		tree.fullExpreesion(n0);
		System.out.println("");
		String s = tree.calBinaryTree(n0);
		System.out.println("");
		System.out.println(s);
	}

}
