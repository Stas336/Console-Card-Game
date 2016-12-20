package game;

import cards.types.Card;
import cards.types.impl.Unit;
import input.ValueReader;
import map.CardMap;
import player.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game
{
    private static int userInputInt = 0;
    private static String userInputStr;
    private static Player player1 = new Player();
    private static Player player2 = new Player();
    private static CardMap cardMap = CardMap.newInstance();
    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("1. Play");
            System.out.println("2. Make a deck");
            System.out.println("3. Show decks");
            System.out.println("4. Exit");
            userInputStr = ValueReader.readValue();
            if (userInputStr == null)
            {
                throw new NullPointerException();
            }
            userInputInt = Integer.parseInt(userInputStr);
            switch (userInputInt)
            {
                case 1:
                    player1.initialize();
                    player2.initialize();
                    break;
                case 2:
                    player1.addDeck();
                    while (player1.getDeck(player1.getDecksCount() - 1).getCardCount() != 5)
                    {
                        player1.getDeck(player1.getDecksCount() - 1).setOwner(player1);
                        System.out.println("Currently you have " + player1.getDeck(player1.getDecksCount() - 1).getCardCount() + " cards in your deck");
                        System.out.println("You can add");
                        System.out.println(cardMap.getAllCardTypes());
                        userInputStr = ValueReader.readValue();
                        if (userInputStr == null)
                        {
                            throw new NullPointerException();
                        }
                        userInputInt = Integer.parseInt(userInputStr);
                        player1.getDeck(player1.getDecksCount() - 1).addCard(cardMap.getCard(String.valueOf(userInputInt)));
                    }
                    break;
                case 3:
                    if (player1.getDecksCount() > 0)
                    {
                        for (int i = 0;i < player1.getDecksCount();i++)
                        {
                            System.out.printf("Deck %d\n", i + 1);
                            for (Card card:player1.getDeck(i).getCards())
                            {
                                System.out.printf("%s (%d mana)", card.getDescription(), card.getMana());
                                if (card instanceof Unit)
                                {
                                    System.out.printf("(%d attack)(%d health)\n", ((Unit) card).getAttack(), ((Unit) card).getHealth());
                                }
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Your dont have any decks created");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
