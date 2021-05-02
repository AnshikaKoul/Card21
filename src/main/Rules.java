package main;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Rules {

    public static final int BlackJackScore = 21;
    public static final int HighestHandScoreForSam = 17;
    public static final int Score22 = 22;
    public static final Predicate<Player> blackJackRule = p -> p.testRulesOfTheGame(player -> player.getHandOfThePlayer().getScoreOfAHand() == BlackJackScore);
    public static final Predicate<Player> higherThanBlackJackRule = p -> p.testRulesOfTheGame(player -> player.getHandOfThePlayer().getScoreOfAHand() > BlackJackScore);
    public static final BiPredicate<Player, Player> bothPlayersHaveBlackJackRule = ((player, dealer) -> blackJackRule.test(player) && blackJackRule.test(dealer));
    public static final BiPredicate<Player, Player> Score22Rule = ((player, dealer) -> player.getHandOfThePlayer().getScoreOfAHand() == Score22 && dealer.getHandOfThePlayer().getScoreOfAHand() == Score22);
    public static final BiPredicate<Player, Player> doesSamHaveHighScore = ((player, dealer) -> player.getHandOfThePlayer().getScoreOfAHand() > dealer.getHandOfThePlayer().getScoreOfAHand());
    public static final BiPredicate<Player, Player> limitUptoWhichDealerCanDrawCards = ((player, dealer) -> dealer.getHandOfThePlayer().getScoreOfAHand() < player.getHandOfThePlayer().getScoreOfAHand());
    public static final Predicate<Player> limitUptoWhichSamCanDrawCards = p -> p.testRulesOfTheGame(sam -> sam.getHandOfThePlayer().getScoreOfAHand() <= HighestHandScoreForSam);
}
