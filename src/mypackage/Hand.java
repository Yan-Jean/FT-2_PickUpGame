package mypackage;

import java.util.Arrays;

public class Hand {
    private String playerName;
    private Card[] hand;

    private static int cardCounter;

    public Hand(String playerName, int n) {
        this.playerName = playerName;
        this.hand = new Card[n];

    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Card[] getHand() {
        return hand;
    }

    public void addCard(Card card) {
        this.hand[cardCounter] = card;
        cardCounter++;
        if (cardCounter == 52)
            cardCounter = 0;
    }

    public String showCardValue(Card card) {
        return card.getValue();
    }

    public String showCardColor(Card card) {
        return card.getColor();
    }

}

