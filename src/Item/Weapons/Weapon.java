package Item.Weapons;

import Item.iItem;

/**
 * IDE: IntelliJ IDEA
 * File Name: Weapon
 * Created by: Chad Eckles.
 * Date: 7/13/2017
 * INFO:
 */
public class Weapon implements iItem {
    private String _name;

    void setDamage(int damage) {}
    void setAttackSpeed(int attackSpeed){}
    void setCoolDown(int coolDown){}
    void setDurability(int durability){}

    @Override
    public void setName(String name) {
        _name = name;
    }
    public String getName(){ return _name; }
    @Override
    public void setDescription(String description) {}
    @Override
    public void setType(String type) {}
}
