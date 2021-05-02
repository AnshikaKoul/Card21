package main;

import java.util.Optional;

import static main.Rules.*;

public class PlayGame {

    public Player beatTheDealerAt21(Player sam, Player dealer, DeckOfCards deckOfCards, boolean shouldShuffle) {

        shuffleAndInitialDraw(sam, dealer, deckOfCards, shouldShuffle);

        Optional<Player> winner = findWinnerInFirstDraw(sam, dealer);

        while (winner.isEmpty()) {

            while (limitUptoWhichSamCanDrawCards.test(sam)) {
                sam.getHandOfThePlayer().addCard(deckOfCards.draw());
                winner = findWinnerInSubsequentDraw(sam, dealer);
            }
            if (winner.isPresent()) return winner.get();

            while (limitUptoWhichDealerCanDrawCards.test(sam, dealer)) {
                dealer.getHandOfThePlayer().addCard(deckOfCards.draw());
                winner = findWinnerInSubsequentDraw(sam, dealer);
            }

            return winner.orElseGet(() -> doesSamHaveHighScore.test(sam, dealer) ? sam : dealer);

        }
        return winner.get();
    }

    private void shuffleAndInitialDraw(Player player, Player dealer, DeckOfCards deckOfCards, boolean shouldShuffle) {

        if(shouldShuffle) {
            deckOfCards.shuffle();
        }

        player.getHandOfThePlayer().addCard(deckOfCards.draw());
        dealer.getHandOfThePlayer().addCard(deckOfCards.draw());

        player.getHandOfThePlayer().addCard(deckOfCards.draw());
        dealer.getHandOfThePlayer().addCard(deckOfCards.draw());
    }

    private Optional<Player> findWinnerInFirstDraw(Player sam, Player dealer) {
        if (bothPlayersHaveBlackJackRule.test(sam, dealer)) {
            return Optional.ofNullable(sam);
        }

        if (blackJackRule.test(sam)) {
            return Optional.ofNullable(sam);
        }

        if (blackJackRule.test(dealer)) {
            return Optional.ofNullable(dealer);
        }

        if (Score22Rule.test(sam, dealer)) {
            return Optional.ofNullable(dealer);
        }
        return Optional.empty();
    }


    private Optional<Player> findWinnerInSubsequentDraw(Player sam, Player dealer) {

        if (blackJackRule.test(sam)) {
            return Optional.ofNullable(sam);
        }

        if (blackJackRule.test(dealer)) {
            return Optional.ofNullable(dealer);
        }

        if (higherThanBlackJackRule.test(sam)) {
            return Optional.ofNullable(dealer);
        }

        if (higherThanBlackJackRule.test(dealer)) {
            return Optional.ofNullable(sam);
        }

        return Optional.empty();
    }
}