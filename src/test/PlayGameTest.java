package test;

import main.DeckOfCards;
import main.HandOfThePlayer;
import main.PlayGame;
import main.Player;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayGameTest {

    PlayGame playGame;
    DeckOfCards deckOfCards;
    Player sam;
    Player dealer;

    @Before
    public void setup() {
        sam = new Player("Sam", new HandOfThePlayer());
        dealer = new Player("Dealer", new HandOfThePlayer());

        playGame = new PlayGame();
    }

    @Test
    public void person_having_initial_score_of_21_wins() throws IOException {
        deckOfCards = new DeckOfCards("src/samWinsInFirstDrawWithBlackjack.txt");
        assertThat(playGame.beatTheDealerAt21(sam, dealer,deckOfCards, false).getNameOfThePlayer())
                .isEqualTo(sam.getNameOfThePlayer());
    }

    @Test
    public void sam_should_win_if_both_player_start_with_21() throws IOException {
        deckOfCards = new DeckOfCards("src/bothPlayerWithBlackJack.txt");
        assertThat(playGame.beatTheDealerAt21(sam, dealer,deckOfCards, false).getNameOfThePlayer())
                .isEqualTo(sam.getNameOfThePlayer());
    }

    @Test
    public void dealer_should_win_if_both_player_start_with_22() throws IOException {
        deckOfCards = new DeckOfCards("src/bothPlayerWith22.txt");
        assertThat(playGame.beatTheDealerAt21(sam, dealer,deckOfCards, false).getNameOfThePlayer())
                .isEqualTo(dealer.getNameOfThePlayer());
    }

    @Test
    public void sam_should_win_if_dealer_total_higher_than_21() throws IOException {
        deckOfCards = new DeckOfCards("src/dealerScoreHigherThan21.txt");
        assertThat(playGame.beatTheDealerAt21(sam, dealer,deckOfCards, false).getNameOfThePlayer())
                .isEqualTo(sam.getNameOfThePlayer());
    }

    @Test
    public void dealer_should_win_if_sam_total_higher_than_21() throws IOException {
        deckOfCards = new DeckOfCards("src/samScoreHigherThan21.txt");
        assertThat(playGame.beatTheDealerAt21(sam, dealer,deckOfCards, false).getNameOfThePlayer())
                .isEqualTo(dealer.getNameOfThePlayer());
    }

    @Test
    public void player_with_highest_score_should_win() throws IOException {
        deckOfCards = new DeckOfCards("src/playerWithHighestScore.txt");
        assertThat(playGame.beatTheDealerAt21(sam, dealer,deckOfCards, false).getNameOfThePlayer())
                .isEqualTo(dealer.getNameOfThePlayer());
    }

    @Test
    public void dealer_wins_if_score_are_tied() throws IOException {
        deckOfCards = new DeckOfCards("src/playerWithTiedScore.txt");
        assertThat(playGame.beatTheDealerAt21(sam, dealer,deckOfCards, false).getNameOfThePlayer())
                .isEqualTo(dealer.getNameOfThePlayer());
    }
}