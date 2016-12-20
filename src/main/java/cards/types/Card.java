package cards.types;

import player.Player;

public interface Card
{
    int getMana();
    String getDescription();
    void setMana(int newMana);
    void setDescription(String newDescription);
    int destroy();
    Player getOwner();
    void setOwner(Player newPlayer);
}
