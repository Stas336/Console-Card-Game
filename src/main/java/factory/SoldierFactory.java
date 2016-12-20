package factory;

import cards.Soldier;

public class SoldierFactory implements Factory<Soldier>
{
    public Soldier newCard()
    {
        return new Soldier();
    }
}
