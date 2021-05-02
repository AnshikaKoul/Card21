package main;

import java.util.function.Predicate;

public class Player {

    private final String nameOfThePlayer;

    private final HandOfThePlayer handOfThePlayer;

    public Player(String nameOfThePlayer, HandOfThePlayer handOfThePlayer) {
        this.nameOfThePlayer = nameOfThePlayer;
        this.handOfThePlayer = handOfThePlayer;
    }

    public String getNameOfThePlayer() {
        return nameOfThePlayer;
    }

    public HandOfThePlayer getHandOfThePlayer() {
        return handOfThePlayer;
    }

    public boolean testRulesOfTheGame(Predicate<Player> rulesforPlayer) {
        return rulesforPlayer.test(this);
    }

    public String getHandAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameOfThePlayer).append(": ");
        for (Card card : handOfThePlayer.getHandOfThePlayer()) {
            sb.append(card).append(',');
        }
        return sb.toString();
    }
}
