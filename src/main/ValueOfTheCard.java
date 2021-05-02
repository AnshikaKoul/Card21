package main;

public enum ValueOfTheCard {
    ACE(11, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K") ;

    private final int value;
    private final String characterValue;

    ValueOfTheCard(int value, String characterValue) {
        this.value = value;
        this.characterValue = characterValue;
    }

    public int getValue() {
        return value;
    }

    public String getCharacterValue() {
        return characterValue;
    }

    public static ValueOfTheCard fromCharacterValue(String characterFromFile) {
        for (ValueOfTheCard valueOfTheCard : ValueOfTheCard.values()) {
            if (valueOfTheCard.characterValue.equalsIgnoreCase(characterFromFile)) {
                return valueOfTheCard;
            }
        }

        throw new IllegalArgumentException("Unknown value from  key: " + characterFromFile);
    }

}
