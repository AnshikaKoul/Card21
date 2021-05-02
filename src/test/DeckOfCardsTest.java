package test;

import main.DeckOfCards;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeckOfCardsTest {

    DeckOfCards deckOfCards;

    @Before
    public void setup() {
        deckOfCards = new DeckOfCards();
    }

    @Test
    public void should_create_deck() {
        assertThat(deckOfCards.getCards().size()).isEqualTo(52);
    }

    @Test
    public void should_create_deck_from_a_file() throws IOException {
        deckOfCards = new DeckOfCards("src/a.txt");
        assertThat(deckOfCards.getCards().size()).isEqualTo(5);
    }

    @Test(expected = IOException.class)
    public void should_throw_exception_if_file_not_found() throws IOException {
        deckOfCards = new DeckOfCards("src/aa.txt");
    }
}