package game.field;

import cards.types.impl.Unit;
import player.Player;

import java.util.ArrayList;

public class Field
{
    private static final int FIELD_LIMIT = 8;
    private ArrayList<Unit> playerField = new ArrayList<Unit>();
    private Player owner;

    public int summonUnit(Unit unit)
    {
        if (playerField.size() < FIELD_LIMIT)
        {
            playerField.add(unit);
            unit.play();
            return 0;
        }
        return 1;
    }
    public ArrayList<Unit> getPlayerField()
    {
        return this.playerField;
    }

    public void setOwner(Player newPlayer) {
        this.owner = newPlayer;
    }

    public Player getOwner() {
        return this.owner;
    }
}
