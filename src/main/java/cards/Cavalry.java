package cards;

import cards.types.impl.Unit;

public class Cavalry extends Unit
{
    public Cavalry()
    {
        setMana(2);
        setAttack(2);
        setDescription("Simple cavalry");
        setHealth(2);
    }

    public int play()
    {
        onBoard();
        return 0;
    }
}
