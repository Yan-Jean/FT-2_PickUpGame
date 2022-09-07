package mypackage;

import java.util.Arrays;
import java.util.Collections;

public class Deck {

    private Card deck[];

    private int currentCardIndex;

    public Deck() {
        deck = new Card[52];
        String[] allValues = {"2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K", "A"};
        String[] allColors = {"♥", "♦", "♣", "♠"};
        int counter = 0;
        for (String v : allValues) {
            for (String c : allColors) {
                deck[counter] = new Card(v, c);
                counter++;
            }
        }
        shuffleDeck();
    }
    public Card getRandomCard() {
        int i = (int) (Math.random() * 52);
        return deck[i];
    }



    private void shuffleDeck() {
        Collections.shuffle(Arrays.asList(deck));
    }

    public Card drawCard () {
        if (currentCardIndex == 51) {
            Card lastCard = deck[currentCardIndex];
            shuffleDeck();
            currentCardIndex = 0;
            return lastCard;
        }
        else {
            return deck[currentCardIndex++];
        }
    }

    @Override
    public String toString() {
        return "Deck: " + Arrays.toString(deck);
    }

}
