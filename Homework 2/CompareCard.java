package DSAA;

import java.util.Arrays;
import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
	// Bai 6
	@Override
	public int compare(Card card1, Card card2) {
		if (card1.getRank() > card2.getRank())
			return 1;
		if (card1.getRank() < card2.getRank())
			return -1;
		else {
			if (card1.getSuit().compareTo(card2.getSuit()) > 0)
				return 1;
			else if (card1.getSuit().compareTo(card2.getSuit()) < 0)
				return -1;
		}
		return 0;
	}

	public void output(Card[] cards) {
		for (Card card : cards) {
			System.out.println(card.toString());
		}
	}

	public static void main(String[] args) {
		Card[] cards = new Card[52];
		Card card = new Card();
		CompareCard compareCard = new CompareCard();
		cards = card.creatCard();
		Arrays.sort(cards, compareCard);
		compareCard.output(cards);
	}

}
