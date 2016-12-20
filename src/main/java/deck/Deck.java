package deck;

import cards.types.Card;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Deck extends ArrayList<Card>
{
    private static final int DECK_LIMIT = 30;
    private ArrayList<Card> deck = new ArrayList<Card>();
    private Player owner;

    public boolean addCard(Card card)
    {
        if (getCardCount() < DECK_LIMIT)
        {
            card.setOwner(owner);
            deck.add(card);
            return true;
        }
        else
        {
            System.out.println("deck is full");
            return false;
        }
    }
    public boolean removeCard(Card card)
    {
        if (getCardCount() > 0)
        {
            deck.remove(card);
            return true;
        }
        else
        {
            System.out.println("deck is empty");
            return false;
        }
    }
    public int getCardCount()
    {
        return this.deck.size();
    }
    public List<Card> getCards()
    {
        return this.deck;
    }
    public void setOwner(Player newPlayer) {
        this.owner = newPlayer;
    }

    public Player getOwner() {
        return this.owner;
    }
}