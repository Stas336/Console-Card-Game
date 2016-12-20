package factory;

import cards.types.Card;

public interface Factory<T extends Card>
{
    T newCard();
}
