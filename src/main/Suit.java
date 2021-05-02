package main;

public enum  Suit {

    Clubs ("C"),
    Diamonds ("D"),
    Hearts ("H"),
    Spades ("S");

    private final String suitKey;

    Suit(String suitKey) {
        this.suitKey = suitKey;
    }

    public String getSuitKey() {
        return suitKey;
    }

    public static Suit fromSuitKey(String characterFromFile) {
        for (Suit suit : Suit.values()) {
            if (suit.suitKey.equalsIgnoreCase(characterFromFile)) {
                return suit;
            }
        }

        throw new IllegalArgumentException("Unknown suit from key: " + characterFromFile);
    }

}
