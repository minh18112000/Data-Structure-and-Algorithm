package hw4_18001163;

import java.util.ArrayList;
import java.util.List;

public class BracketMatching {
	public static boolean isMatched(String expression) {
		final String opening = "({[";
		final String closing = ")}]";
		ArrayStack<Character> buffer = new ArrayStack<>();
		for (char c : expression.toCharArray()) {
			if (opening.indexOf(c) != -1) {
				buffer.push(c);
			} else if (closing.indexOf(c) != -1) {
				if (buffer.isEmpty())
					return false;
				if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
					return false;
			}
		}
		return buffer.isEmpty();
	}

	public static double eval(String str) {
		List<Character> listChar = new ArrayList<>();
		for (char c : str.toCharArray()) {
			listChar.add(c);
		}
		ArrayStack<Double> numberStack = new ArrayStack<>();
		ArrayStack<String> operatorStack = new ArrayStack<>();
		for (int i = 0; i < listChar.size(); i++) {
			if (!listChar.get(i).equals('(') && !listChar.get(i).equals(' ')) {
				if (listChar.get(i).equals('+') || listChar.get(i).equals('-') || listChar.get(i).equals('*')
						|| listChar.get(i).equals('/')) {
					operatorStack.push(String.valueOf(listChar.get(i)));
				}
				if (listChar.get(i).equals(')')) {
					double n1 = numberStack.pop();
					double n2 = numberStack.pop();
					String operator = operatorStack.pop();
					double result = cal(operator, n2, n1);
					numberStack.push(result);
				}
				if (Character.isDigit(listChar.get(i))) {
					double num = 0;
					while (Character.isDigit(listChar.get(i))) {
						double current = Double.parseDouble(String.valueOf(listChar.get(i)));
						num = num * 10 + current;
						i++;
					}
					numberStack.push(num);
					i--;
				}

			}
		}
		return numberStack.pop();
	}

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

	public static String transfer(String expression) {
		final String opening = "{[";
		final String closing = "}]";
		String list = "";
		for (char c : expression.toCharArray()) {
			if (c == '}' || c == ']') {
				list = list.concat(")");
			} else if (c == '{' || c == '[') {
				list = list.concat("(");
			} else
				list = list.concat(Character.toString(c));
		}
		return list;
	}

	public static void main(String[] args) {
		String a = "((40+50) / (1 + 2))";
		String f = "(10 + 20)";
		String e = "((50+((80-4)*(2+30)))*(300*4))";
		String b = "))({[]})";
		if (isMatched(a)) {
			System.out.println("Bieu thuc hop le");
			double c = eval(transfer(a));
			System.out.println(c);
		} else
			System.out.println("Bieu thuc khong hop le");
	}
}
