package hw4_18001163;

import java.util.*;

public class TowerOfHanoi {

	public static int N;
	public static Stack<Integer>[] stacks = new Stack[4];

	public static void done(int n) {
		for (int d = n; d > 0; d--)
			stacks[1].push(d);
		display();
		move(n, 1, 2, 3);
	}

	public static void move(int n, int a, int b, int c) {
		if (n > 0) {
			move(n - 1, a, c, b);
			int m = stacks[a].pop();
			stacks[c].push(m);
			display();
			move(n - 1, b, a, c);
		}
	}

	public static void display() {
		System.out.println("  A  |  B  |  C  ");
		System.out.println("-----------------");
		for (int i = N - 1; i >= 0; i--) {
			String d1 = " ", d2 = " ", d3 = " ";
			try {
				d1 = String.valueOf(stacks[1].get(i));
			} catch (Exception e) {
			}
			try {
				d2 = String.valueOf(stacks[2].get(i));
			} catch (Exception e) {
			}
			try {
				d3 = String.valueOf(stacks[3].get(i));
			} catch (Exception e) {
			}
			System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		stacks[1] = new Stack<>();
		stacks[2] = new Stack<>();
		stacks[3] = new Stack<>();
		System.out.println("Enter number of disks");
		int num = input.nextInt();
		N = num;
		done(num);
	}
}
