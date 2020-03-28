package DSAA;

import java.util.Random;

public class ShuffleCard {
	// Bai 7
	public void shuffle(Card[] cards) {
		Random random = new Random();
		for (int i = 0; i < cards.length; i++) {
			int j = i;
			while (i == j) {
				j = random.nextInt(cards.length - 1);
			}
			Card temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		}

	}

	public static void output(Card[] cards) {
		for (Card card : cards) {
			System.out.println(card.toString());
		}
	}

	public static void main(String[] args) {
		Card[] cards = new Card[52];
		ShuffleCard shuffleCard = new ShuffleCard();
		Card card = new Card();
		cards = card.creatCard();
		shuffleCard.shuffle(cards);
		output(cards);
	}

}
