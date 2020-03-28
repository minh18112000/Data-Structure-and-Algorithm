package DSAA;

public class Card implements Comparable<Card> {
	// Bai 6

	private int rank;
	private String suit;

	public Card() {
	}

	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + "]";
	}

	public Card[] creatCard() {
		Card[] cards = new Card[52];
		int index = 0;
		String[] suits = { "1diamond", "3club", "2heart", "4spade" };
		for (int i = 1; i <= 13; i++) {
			for (String suit : suits) {
				cards[index] = new Card(i, suit);
				index++;			}
		}
		return cards;
	}

	@Override
	public int compareTo(Card o) {
		if(this.rank > o.rank) return 1;
		if(this.rank < o.rank) return -1;
		else {
			if(this.suit.compareTo(o.suit) > 0) return 1;
			else if(this.suit.compareTo(o.suit)< 0) return -1;
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
