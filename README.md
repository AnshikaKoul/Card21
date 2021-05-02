# Card21

This Java program simulates a card game of BlackJack, between sam and dealer.

Rules to implement

- determine score of a hand[1]
- heck if either player has Blackjack with their initial hand and wins the game.
Blackjack is an initial score of 21 with two cards: A + [10, J, Q, K] 
- sam wins when both players starts with Blackjack 
- dealer wins when both players starts with 22 (A + A) 
- if neither player has Blackjack then sam can start drawing cards from the top
of the deck
- sam must stop drawing cards from the deck if their total reaches 17 or higher
- sam has lost the game if their total is higher than 21 
- when sam has stopped drawing cards the dealer can start drawing cards from
the top of the deck
- the dealer must stop drawing cards when their total is higher than sam.
- the dealer has lost the game if their total is higher than 21 
- determine which player wins the game (highest score wins)


[1] Numbered cards are their point value. Jack, Queen and King count as 10 and Ace
counts as 11.

# Steps on running code :

- To compile from command line :

```
javac -d out/production/Card21/ src/main/*.java
```
- To run from command line :

To read a file containing a deck of cards, taking the reference to the file as a command line argument, as a starting point.

```
java main.BeatTheDealer a.txt
```

If no file is provided, a new shuffled deck of 52 unique cards will be initialized.

```
java main.BeatTheDealer
```
