package hw4_18001163;

import java.util.Scanner;

public class PalindromeQueue {
	public static String isPalidromeQueue(String palidrome) {
		String reverse = "";
		ArrayQueue<Character> buffer = new ArrayQueue<>(palidrome.length());
		for (int i = palidrome.length() - 1; i >= 0; i--) {
			buffer.enqueue(palidrome.charAt(i));
		}
		for (int i = 0; i < palidrome.length(); i++) {
			reverse = reverse.concat(Character.toString(buffer.dequeue()));
		}
		return reverse;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap chuoi can xet: ");
		String palidrome = input.nextLine();
		String reverse = isPalidromeQueue(palidrome);
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
