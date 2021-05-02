package test;

import main.*;
import org.junit.Before;
import org.junit.Test;

import static main.Rules.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RulesTest {

    Player player1;
    Player player2;

    @Before
    public void setup() {
        player1 = new Player("Sam", new HandOfThePlayer());
        player2 = new Player("Anshika", new HandOfThePlayer());
    }

    @Test
    public void check_if_player_has_blackjack() {
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.JACK, Suit.Clubs)));
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));

        assertThat(Rules.blackJackRule.test(player1)).isTrue();
    }

    @Test
    public void check_if_player_has_higher_than_blackjack() {
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));

        assertThat(higherThanBlackJackRule.test(player1)).isTrue();
    }

    @Test
    public void check_if_both_player_has_blackjack() {
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.KING, Suit.Clubs)));

        player2.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));
        player2.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.QUEEN, Suit.Clubs)));

        assertThat(bothPlayersHaveBlackJackRule.test(player1, player2)).isTrue();
    }

    @Test
    public void check_if_both_player_has_score_22() {
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));

        player2.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));
        player2.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));

        assertThat(Score22Rule.test(player1, player2)).isTrue();
    }

    @Test
    public void check_the_rule_for_dealer_to_draw_cards() {
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.ACE, Suit.Clubs)));
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.JACK, Suit.Clubs)));

        player2.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.FIVE, Suit.Clubs)));
        player2.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.EIGHT, Suit.Clubs)));

        assertThat(limitUptoWhichDealerCanDrawCards.test(player1, player2)).isTrue();
    }

    @Test
    public void check_the_rule_for_sam_to_draw_cards() {
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.KING, Suit.Clubs)));
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.JACK, Suit.Clubs)));

        assertThat(limitUptoWhichSamCanDrawCards.test(player1)).isTrue();
    }

    @Test
    public void check_the_rule_for_which_player_has_highest_score() {
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.KING, Suit.Clubs)));
        player1.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.JACK, Suit.Clubs)));

        player2.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.FIVE, Suit.Clubs)));
        player2.getHandOfThePlayer().addCard((new Card(ValueOfTheCard.EIGHT, Suit.Clubs)));

        assertThat(doesSamHaveHighScore.test(player1, player2)).isTrue();
    }
}