package test;

import main.ValueOfTheCard;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueOfTheCardTest {

    @Test
    public void should_return_from_key() {
        assertThat(ValueOfTheCard.fromCharacterValue("A")).isEqualTo(ValueOfTheCard.ACE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_unknown_key() {
        ValueOfTheCard.fromCharacterValue("UNKNOWN_PRODUCT");
    }
}