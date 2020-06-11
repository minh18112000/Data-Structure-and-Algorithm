package hw5_18001163;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionTree<E> extends LinkedBinaryTree {
	List<Node<E>> listNode = new ArrayList<>();
	
	// print tree with preorder.
	public void preorderPrint(Node<E> p) {
// Using recursive

		// if (p == null) {
		// return;
		// }
		// System.out.printf("%s ", p.getElement());
		// preorderPrint(p.getLeft());
		// preorderPrint(p.getRight());

// Without using recursive

		Stack<Node<E>> nodes = new Stack<>();
		nodes.push(p);

		while (!nodes.isEmpty()) {
			Node<E> current = nodes.pop();
			System.out.printf("%s ", current.getElement());

			if (current.getRight() != null) {
				nodes.push(current.getRight());
			}
			if (current.getLeft() != null) {
				nodes.push(current.getLeft());
			}
		}

	}

	// print tree with postorder.
	public List<Node<E>> postorderPrint(Node<E> p) {
// Using recursive
		if (p == null) {
			return null;
		}
		postorderPrint(p.getLeft());
		postorderPrint(p.getRight());
		listNode.add(p);
		System.out.printf("%s ", p.getElement());

// Without using recursive

		// Stack<Node<E>> nodes = new Stack<>();
		// nodes.push(p);
		//
		// while (!nodes.isEmpty()) {
		// Node<E> current = nodes.peek();
		//
		// if (left(current) == null || right(current) == null) {
		// Node<E> node = nodes.pop();
		// listNode.add(node);
		//// System.out.printf("%s ", node.getElement());
		// } else {
		//
		// if (current.getRight() != null) {
		// nodes.push(current.getRight());
		// current.setRight(null);
		// }
		//
		// if (current.getLeft() != null) {
		// nodes.push(current.getLeft());
		// current.setLeft(null);
		// }
		// }

		// }
		return listNode;
	}

	// print tree with inorder.
	public void inorderPrint(Node<E> p) {
// Using recursive

		if (p == null) {
			return;
		}
		if (p.getLeft() != null) {
			inorderPrint(p.getLeft());
		}
		System.out.printf("%s ", p.getElement());
		if (p.getRight() != null) {
			inorderPrint(p.getRight());
		}
// Without using recursive

		// Stack<Node<E>> nodes = new Stack<>();
		// Node<E> current = p;
		//
		// while (!nodes.isEmpty() || current != null) {
		//
		// if (current != null) {
		// nodes.push(current);
		// current = current.getLeft();
		// } else {
		// Node<E> node = nodes.pop();
		// System.out.printf("%s ", node.getElement());
		// current = node.getRight();
		// }
		//
		// }
	}

	// calculate a math expression from binary tree 
	public E calBinaryTree(Node<E> p) {
		List<Node<E>> listNode = postorderPrint(p);
		for (Node<E> node : listNode) {
			if (node.getElement() == "+" || node.getElement() == "-" || node.getElement() == "*"
					|| node.getElement() == "/") {
				Node<E> left = node.getLeft();
				Node<E> right = node.getRight();
				String operator = String.valueOf(node.getElement());
				double nLeft = Double.parseDouble((String) left.getElement());
				double nRight = Double.parseDouble((String) right.getElement());
				double result = cal(operator, nLeft, nRight);
				node.setElement((E) String.valueOf(result));
			}
		}
		return p.getElement();
	}

	// compare operator to calculate
	public static double cal(String str, double a, double b) {
		switch (str) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				return a / b;
			default:
				return 0;
		}
	}


	// print binary tree with full braces
	public void fullExpreesion(Node<E> p) {
		if (p.getLeft() != null) {
			System.out.print("(");
			fullExpreesion(p.getLeft());
		}
		System.out.print(p.getElement());
		if (p.getRight() != null) {
			fullExpreesion(p.getRight());
			System.out.print(")");
		}
	}
}
