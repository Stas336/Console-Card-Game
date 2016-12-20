package cards;

import cards.types.impl.Unit;

public class Soldier extends Unit
{
    public Soldier()
    {
        setMana(1);
        setAttack(1);
        setDescription("Simple soldier");
        setHealth(1);
    }
    public int play()
    {
        onBoard();
        return 0;
    }
}
