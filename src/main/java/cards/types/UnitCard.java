package cards.types;

public interface UnitCard extends Card
{
    int getHealth();
    int getAttack();
    void setHealth(int newHealth);
    void setAttack(int newAttack);
}
