package hw3_18001163;

public class WordCount {
	private String word;
	private int sizeWord;

	public WordCount(String word) {
		this.word = word;
		this.sizeWord = word.length();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
		this.sizeWord = word.length();
	}

	public int getN() {
		return sizeWord;
	}

	@Override
	public boolean equals(Object data) {
		if (data instanceof WordCount) {
			String temp = ((WordCount) data).getWord();
			if (temp.length() == sizeWord) {
				temp = temp.toUpperCase();
				word = word.toUpperCase();
				for (int i = 0; i < sizeWord; i++) {
					if (temp.charAt(i) != word.charAt(i)) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
