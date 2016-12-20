package hand;

import cards.Coin;
import cards.types.Card;
import net.nullschool.util.DigitalRandom;
import player.Player;

import java.util.ArrayList;

public class Hand
{
    private static final int HAND_LIMIT = 10;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private Player owner;

    public ArrayList<Card> getHand()
    {
        return this.hand;
    }
    public void initializeHand()
    {
        DigitalRandom random = new DigitalRandom();
        for (int i = 0;i < 3;i++)
        {
            int randomint = random.nextInt(1, getOwner().getCurrentDeck().size());
            hand.add(getOwner().getCurrentDeck().get(randomint));
            getOwner().getCurrentDeck().remove(randomint);
        }
        if (getOwner().isFirst())
        {
            hand.add(new Coin());
        }
    }
    public void getNewCard()
    {
        DigitalRandom random = new DigitalRandom();
        int randomint = random.nextInt(1, getOwner().getCurrentDeck().size());
        hand.add(getOwner().getCurrentDeck().get(randomint));
        getOwner().getCurrentDeck().remove(randomint);
    }
    public void setOwner(Player newPlayer) {
        this.owner = newPlayer;
    }

    public Player getOwner() {
        return this.owner;
    }
}
