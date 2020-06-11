package hw4_18001163;

import java.util.Scanner;

public class PalindromeStack {
	public static String isPalidromeStack(String palidrome) {
		String reverse = "";
		ArrayStack<Character> buffer = new ArrayStack<>(palidrome.length());
		for (int i = 0; i < palidrome.length(); i++) {
			buffer.push(palidrome.charAt(i));
		}
		for (int i = 0; i < palidrome.length(); i++) {
			reverse = reverse.concat(Character.toString(buffer.pop()));
		}
		return reverse;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap chuoi can xet: ");
		String palidrome = input.nextLine();
		String reverse = isPalidromeStack(palidrome);
		for (int i = 0; i < reverse.length(); i++) {
			if (reverse.charAt(i) != palidrome.charAt(i)) {
				System.out.println("Khong");
				break;
			}
			if (i == reverse.length() - 1)
				System.out.println("Co");
		}
	}
}
