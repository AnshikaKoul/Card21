package test;

import main.Suit;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuitTest {

    @Test
    public void should_return_from_key_for_club() {
        assertThat(Suit.fromSuitKey("C")).isEqualTo(Suit.Clubs);
    }

    @Test
    public void should_return_from_key_for_diamond() {
        assertThat(Suit.fromSuitKey("D")).isEqualTo(Suit.Diamonds);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_unknown_key() {
        Suit.fromSuitKey("UNKNOWN_PRODUCT");
    }
}