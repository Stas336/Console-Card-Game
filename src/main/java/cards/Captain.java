package cards;

import cards.types.impl.Unit;

public class Captain extends Unit
{
    public Captain()
    {
        setMana(3);
        setAttack(1);
        setDescription("Captain with 2 soldiers");
        setHealth(1);
    }

    public int play()
    {
        onBoard();
        summonUnit(new Soldier());
        summonUnit(new Soldier());
        return 0;
    }
}
