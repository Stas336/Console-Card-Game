package cards.types.impl;

import cards.types.UnitCard;
import game.Game;
import game.field.Field;
import input.ValueReader;
import player.Player;

public abstract class Unit implements UnitCard {
    private int mana = 0;
    private int attack = 0;
    private int health = 0;
    private String description = "";
    private boolean deathrattle = false;
    private boolean battlecry = false;
    private boolean OnBoard = false;
    private Player owner;

    public int getMana() {
        return this.mana;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getHealth() {
        return this.health;
    }

    public String getDescription() {
        return this.description;
    }

    public void setMana(int newMana) {
        this.mana = newMana;
    }

    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public boolean isOnBoard() {
        return OnBoard;
    }

    public int onBoard() {
        this.OnBoard = true;
        return 0;
    }

    public int offBoard() {
        this.OnBoard = false;
        return 0;
    }

    public boolean isDeathrattle() {
        return deathrattle;
    }

    public int includeDeathrattle() {
        this.deathrattle = true;
        return 0;
    }

    public boolean isBattlecry() {
        return battlecry;
    }

    public int includeBattlecry() {
        this.battlecry = true;
        return 0;
    }

    public int attackUnit(Unit target) {
        if (isOnBoard()) {
            target.setHealth(target.getHealth() - getAttack());
            setHealth(getHealth() - target.getAttack());
            return 0;
        } else {
            return 1;
        }
    }

    public int attackPlayer(Player target) {
        if (isOnBoard()) {
            target.setHealth(target.getHealth() - getAttack());
            return 0;
        } else {
            return 1;
        }
    }

    public abstract int play();

    public int destroy() //TODO
    {
        offBoard();
        setHealth(0);
        setAttack(0);
        setMana(0);
        return 0;
    }

    public void setOwner(Player newPlayer) {
        this.owner = newPlayer;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void summonUnit(Unit unit)
    {
        getOwner().getField().summonUnit(unit);
    }
    public void buffUnit(int mana, int attack, int health)
    {
        System.out.println("Which unit you want to buff (index)");
        String indexstr = ValueReader.readValue();
        if (indexstr == null)
        {
            throw new NullPointerException();
        }
        int index = Integer.parseInt(indexstr);
        Unit unit = getOwner().getField().getPlayerField().get(index - 1);
        unit.setMana(unit.getMana() + mana);
        unit.setAttack(unit.getAttack() + attack);
        unit.setHealth(unit.getHealth() + health);
    }
}
