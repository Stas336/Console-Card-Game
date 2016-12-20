package map;

import cards.types.Card;
import factory.CaptainFactory;
import factory.CavalryFactory;
import factory.Factory;
import factory.SoldierFactory;

import java.util.*;

public final class CardMap
{
    private Map<String, Factory<? extends Card>> map = new HashMap<String, Factory<? extends Card>>();
    private CardMap()
    {
        map.put("Soldier", new SoldierFactory());
        map.put("DeathrattleSoldier", new CavalryFactory());
        map.put("BattlecrySoldier", new CaptainFactory());
    }
    public static CardMap newInstance()
    {
        return new CardMap();
    }
    public Card getCard(String cardType)
    {
        Factory<? extends Card> factory = map.get(cardType);
        if (factory == null)
        {
            return null;
        }
        else
        {
            return factory.newCard();
        }
    }
    public Card getCard(int position)
    {
        for(Map.Entry<String, Factory<? extends Card>> entry : map.entrySet())
        {
            if (position-- == 0)
            {
                Factory factory=entry.getValue();
                if (factory == null)
                {
                    return null;
                }
                else
                {
                    return factory.newCard();
                }
            }
        }
        return null;
    }
    public Set<String> getAllCardTypes()
    {
        return map.keySet();
    }
}