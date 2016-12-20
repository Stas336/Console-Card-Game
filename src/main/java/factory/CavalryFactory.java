package factory;

import cards.Cavalry;

public class CavalryFactory implements Factory<Cavalry>
{
    public Cavalry newCard()
    {
        return new Cavalry();
    }
}
