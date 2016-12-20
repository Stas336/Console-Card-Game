package player;

import cards.types.Card;
import deck.Deck;
import game.field.Field;
import hand.Hand;

import java.util.ArrayList;

public class Player
{
    private int health;
    private int mana;
    private Hand hand = new Hand();
    private Deck currentDeck = new Deck();
    private ArrayList<Deck> decks = new ArrayList<Deck>();
    private Field field = new Field();
    private boolean isFirst = false;

    public int initialize()
    {
        setHealth(30);
        setMana(0);
        hand.setOwner(this);
        hand.initializeHand();
        return 0;
    }
    public int playCard(Card card)
    {
        if (card.getMana() > mana)
        {
            System.out.println("Not enough mana to play this card");
            return 1;
        }
        else
        {
            this.setMana(this.getMana() - card.getMana());
            this.hand.getHand().remove(card);
            return 0;
        }
    }
    public int getHealth()
    {
        return this.health;
    }
    public int setHealth(int newHealth)
    {
        this.health = newHealth;
        return 0;
    }
    public int getMana()
    {
        return this.mana;
    }
    public int setMana(int newMana)
    {
        this.mana = newMana;
        return 0;
    }
    public Deck getDeck(int index)
    {
        return this.decks.get(index);
    }
    public int getDecksCount()
    {
        return this.decks.size();
    }
    public void addDeck()
    {
        this.decks.add(new Deck());
    }
    public Field getField()
    {
        return this.field;
    }

    public Deck getCurrentDeck()
    {
        return this.currentDeck;
    }

    public void setCurrentDeck(int index)
    {
        this.currentDeck = decks.get(index - 1);
    }

    public boolean isFirst()
    {
        return isFirst;
    }

    public void setFirst(boolean value)
    {
        isFirst = value;
    }
}
