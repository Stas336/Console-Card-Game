package cards.types;

public interface WeaponCard extends Card
{
    int getDurability();
    void setDurability(int newDurability);
    int getAttack();
    void setAttack(int newAttack);
}
