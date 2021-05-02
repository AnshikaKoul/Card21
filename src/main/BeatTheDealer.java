package main;

import java.io.IOException;

public class BeatTheDealer {

    public static void main(String[] args) {
        final DeckOfCards deckOfCards;
        final Player winner;

        final PlayGame playGame = new PlayGame();

        final Player sam = new Player("Sam", new HandOfThePlayer());
        final Player dealer = new Player("Dealer", new HandOfThePlayer());

        if (args.length == 1) {
            try {
                deckOfCards  = new DeckOfCards(args[0]);
            } catch (IOException e) {
                System.out.println("File not found, Please enter a.txt - valid filename ");
                return;
            }
            winner = playGame.beatTheDealerAt21(sam, dealer, deckOfCards, false);
        } else {
            deckOfCards = new DeckOfCards();
            winner = playGame.beatTheDealerAt21(sam, dealer, deckOfCards, true);
        }

        System.out.println(winner.getNameOfThePlayer());
        System.out.println(sam.getHandAsString());
        System.out.println(dealer.getHandAsString());

        System.out.println(sam.getNameOfThePlayer() + " - " + sam.getHandOfThePlayer().getScoreOfAHand());
        System.out.println(dealer.getNameOfThePlayer() + " - " + dealer.getHandOfThePlayer().getScoreOfAHand());
    }

}
