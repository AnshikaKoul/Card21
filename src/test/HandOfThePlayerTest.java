package test;

import main.Card;
import main.HandOfThePlayer;
import main.Suit;
import main.ValueOfTheCard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HandOfThePlayerTest {

    private HandOfThePlayer handOfThePlayer;

    @Before
    public void setup() {
        handOfThePlayer = new HandOfThePlayer();
    }

    @After
    public void teardown() {
        handOfThePlayer.getHandOfThePlayer().clear();
    }

    @Test
    public void test_individual_card_score() {
        handOfThePlayer.addCard(new Card(ValueOfTheCard.TWO, Suit.Clubs));
        assertThat(handOfThePlayer.getScoreOfAHand()).isEqualTo(2);
    }

    @Test
    public void test_individual_card_score_with_face() {
        handOfThePlayer.addCard(new Card(ValueOfTheCard.KING, Suit.Clubs));
        assertThat(handOfThePlayer.getScoreOfAHand()).isEqualTo(10);
    }

    @Test
    public void test_score_with_multiple_cards() {
        handOfThePlayer.addCard(new Card(ValueOfTheCard.ACE, Suit.Clubs));
        handOfThePlayer.addCard(new Card(ValueOfTheCard.JACK, Suit.Clubs));
        handOfThePlayer.addCard(new Card(ValueOfTheCard.QUEEN, Suit.Clubs));
        assertThat(handOfThePlayer.getScoreOfAHand()).isEqualTo(31);
    }
}