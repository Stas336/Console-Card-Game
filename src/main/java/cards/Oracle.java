package cards;

import cards.types.impl.Unit;

public class Oracle extends Unit
{
    public Oracle()
    {
        setMana(4);
        setAttack(3);
        setDescription("Oracle. Buff selected unit +2/+1");
        setHealth(2);
    }

    public int play()
    {
        onBoard();
        buffUnit(0,2,1);
        return 0;
    }
}
