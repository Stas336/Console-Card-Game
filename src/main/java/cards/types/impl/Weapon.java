package cards.types.impl;

import cards.types.WeaponCard;
import player.Player;

public class Weapon implements WeaponCard
{
    private int mana = 0;
    private int attack = 0;
    private int durability = 0;
    private String description = "";
    private Player owner;

    public int getMana()
    {
        return this.mana;
    }
    public int getAttack()
    {
        return this.attack;
    }
    public int getDurability()
    {
        return this.durability;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setMana(int newMana)
    {
        this.mana = newMana;
    }
    public void setAttack(int newAttack)
    {
        this.attack = newAttack;
    }
    public void setDurability(int newDurability)
    {
        this.durability = newDurability;
    }
    public void setDescription(String newDescription)
    {
        this.description = newDescription;
    }
    public void setOwner(Player newPlayer)
    {
        this.owner = newPlayer;
    }
    public Player getOwner()
    {
        return this.owner;
    }
    public int destroy() //TODO
    {
        //offBoard();
        setDurability(0);
        setAttack(0);
        setMana(0);
        return 0;
    }
}
