package main;

import java.util.ArrayList;

public class HandOfThePlayer {

    private final ArrayList<Card> handOfThePlayer;

    public HandOfThePlayer() {
        this.handOfThePlayer = new ArrayList<>();
    }

    public int getScoreOfAHand() {
        return this.getHandOfThePlayer().stream()
                .mapToInt(card -> card.getValue().getValue())
                .sum();
    }

    public void addCard(Card card) {
        this.getHandOfThePlayer().add(card);
    }

    public ArrayList<Card> getHandOfThePlayer() {
        return handOfThePlayer;
    }
}
