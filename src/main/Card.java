package main;

public class Card {

    private final ValueOfTheCard value;
    private final Suit suit;


    public Card(ValueOfTheCard value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public ValueOfTheCard getValue() {
        return value;
    }


    @Override
    public String toString() {
        return  suit.getSuitKey() + value.getCharacterValue();
    }
}
