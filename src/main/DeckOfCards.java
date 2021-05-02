package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {

    private final ArrayList<Card> cards;

    public DeckOfCards(String fileName) throws IOException {
        cards = new ArrayList<>();
        String card = new String(Files.readAllBytes(Paths.get(fileName)));

        for (String s : card.split(",")) {
            char[] charArray = s.toCharArray();
            cards.add(new Card(
                            ValueOfTheCard.fromCharacterValue(String.valueOf(charArray[1])),
                            Suit.fromSuitKey(String.valueOf(charArray[0]))
                    )
            );
        }

    }

    public DeckOfCards() {
        cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (ValueOfTheCard valueOfTheCard : ValueOfTheCard.values()) {
                cards.add(new Card(valueOfTheCard, suit));
            }
        }

    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(i + 1);
            sb.append('/');
            sb.append(cards.size());
            sb.append(' ');
            sb.append(cards.get(i));
            sb.append('\n');
        }
        return sb.toString();
    }
}
