package hw5_18001163;

import java.util.Stack;
import hw5_18001163.LinkedBinaryTree.Node;

public class PrintTreeFromExpression {
    // compare level of operator
    public static int operator(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // transfer a Infix expression to a Postfix expression
    public static String transferToPostFix(String expression) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // check if char is operator
            if (operator(c) > 0) {
                // check level of operator and if stack is not empty
                while (stack.isEmpty() == false && operator(stack.peek()) >= operator(c)) {
                    result += stack.pop();
                }
                stack.push(c);
            } else if (c == ')') {
                char x = stack.pop();
                while (x != '(') {
                    result += x;
                    x = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {
                result += c;
            }
        }
        for (int i = 0; i <= stack.size(); i++) {
            result += stack.pop();
        }
        return result;
    }

    // return root of binary tree represent a expression
    public static Node<String> getRootTree(String expression) {
        Stack<Node<String>> stack = new Stack<>();
        String[] tokens = new String[expression.length()];
        for (int i = 0; i < expression.length(); i++) {
            tokens[i] = String.valueOf(expression.charAt(i));
        }
        for (String s : tokens) {
            Node<String> root = new Node<String>(s, null, null, null);
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Node<String> rightChild = stack.pop();
                Node<String> leftChild = stack.pop();
                root.setRight(rightChild);
                root.setLeft(leftChild);
                stack.push(root);
            } else {
                stack.push(root);
            }
        }
        return stack.pop();
    }

    // print binary tree with parameters are root of tree and level = 1.
    public static void print(Node p, int level) {
        if (p == null)
            return;
        print(p.getRight(), level + 1);
        for (int i = 1; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(p.getElement());
        print(p.getLeft(), level + 1);
    }

    public static void main(String[] args) {
        String[] tokens = { "(", "6", "/", "2", "+", "3", ")", "*", "(", "7", "-", "4", ")" };
        String expression = "";
        for (String s : tokens) {
            expression = expression.concat(s);
        }
        System.out.println(expression);
        System.out.println("Infix Expression: " + expression);
        System.out.println("Postfix Expression: " + transferToPostFix(expression));
        print(getRootTree(transferToPostFix(expression)), 1);
    }
}