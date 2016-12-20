package factory;

import cards.Captain;

public class CaptainFactory implements Factory<Captain>
{
    public Captain newCard()
    {
        return new Captain();
    }
}
