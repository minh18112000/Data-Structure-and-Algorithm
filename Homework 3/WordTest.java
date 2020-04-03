package hw3_18001163;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordTest {
	private SimpleArrayList<WordCount> listWord;
	private Scanner reader;

	public void input(String fileName) {
		try {
			reader = new Scanner(new File(fileName));
			listWord = new SimpleArrayList<>();
			while (reader.hasNext()) {
				listWord.add(new WordCount(reader.next()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		reader.close();
	}

	public void output(String fileName) {
		try {
			reader = new Scanner(new File(fileName));
			while (reader.hasNext()) {
				System.out.println(reader.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		reader.close();
	}

	public ArrayList<Integer> count() {
		reader = new Scanner(System.in);
		int sizeList = listWord.size();
		ArrayList<Integer> indexWord = new ArrayList<>();
		String data = reader.next();
		int index = 0;
		while (index < sizeList) {
			int temp = listWord.indexOf(new WordCount(data), index);
			if (temp != -1) {
				indexWord.add(temp);
				index = temp + 1;
			} else
				break;
		}
		System.out.print("Cac vi tri: ");
		for (int i = 0; i < indexWord.size(); i++) {
			System.out.print(indexWord.get(i) + " ");
		}
		System.out.println("");
		reader.close();
		return indexWord;
	}

	public static void main(String[] args) {
		WordTest wordTest = new WordTest();
		wordTest.input("text.txt");
		wordTest.output("text.txt");
		System.out.println("Count = " + wordTest.count().size());
	}
}
