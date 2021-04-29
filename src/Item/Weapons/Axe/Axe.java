package Item.Weapons.Axe;

import Item.Weapons.Weapon;

/**
 * IDE: IntelliJ IDEA
 * File Name: Axe
 * Created by: Chad Eckles.
 * Date: 7/13/2017
 * INFO:
 */
public class Axe extends Weapon {
    private String  _name = "";
    private String _type = "";
    private String _description = "";
    private int _damage = 0;
    private int _attackPerTurn = 0;
    private int _coolDown = 0;
    private int _durability;

    public Axe(String name, String type, String description, int damage, int attackPerTurn, int coolDown, int durability){
        this._name = name;
        this._type = type;
        this._description = description;
        this._damage = damage;
        this._attackPerTurn = attackPerTurn;
        this._coolDown = coolDown;
        this._durability = durability;
    }

    public String toString(){
        return new StringBuilder()
                .append("Name: ")
                .append(this._name)
                .append(", Type: ")
                .append(this._type)
                .append(", Description : ")
                .append(this._description)
                .append(", Damage : ")
                .append(this._damage)
                .append(", Attacks Per Turn : ")
                .append(this._attackPerTurn)
                .append(", Cool Down : ")
                .append(this._coolDown)
                .append(", Durability : ")
                .append(this._durability)
                .append(".\n\r").toString();
    }

    @Override
    public void setName(String name) {
        _name = name;
    }
    public String getName(){ return _name;}

    @Override
    public void setDescription(String description) {
        _description = description;
    }
    public String getDescription(){return _description;}

    @Override
    public void setType(String type) {
        _type = "Axe";
    }
    public String getType(){return _type;}

    public void setDamage(int damage) {
        _damage = damage;
    }
    public int getDamage(){return _damage;}

    public void setAttackPerTurn(int attackPerTurn) {
        _attackPerTurn = attackPerTurn;
    }
    public int getAttackPerTurn(){return _attackPerTurn;}

    public void setCoolDown(int coolDown) {
        _coolDown = coolDown;
    }
    public int getCoolDown(){return _coolDown;}

    public void setDurability(int durability) {
        _durability = durability;
    }
    public int getDurability(){return _durability;}
}
