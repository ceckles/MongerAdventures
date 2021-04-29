/**
 * IDE: IntelliJ IDEA
 * File Name: PlayerClass
 * Created by: Chad Eckles.
 * Date: 7/12/2017
 * INFO:
 */
package PlayerClasses;

import Item.Weapons.Weapon;

public class PlayerClass implements iPlayer{
    private String _name;
    private double _health;
    private long _experience;
    private int _attack;
    private int _defence;
    private int _jump;
    private int _heal;

    private String _playerClass;
    private String _role;
    private int _level;
    private Weapon _Weapon;

    public PlayerClass(String name,String playerClass, String role, int level){
        this._name = name;
        this._playerClass = playerClass;
        this._role = role;
        this._level = level;
        this._experience = 0;
        this._health = 100;
        this._attack = 10;
        this._defence = 2;
        this._jump = 4;
        this._heal = 5;
    }
    public String getInfo(){
        String x = _name +" "+_playerClass +" "+ _role +" "+String.valueOf(_level);
        return x;
    }

    public String getName(){
        return _name;
    }

    @Override
    public double getHealth() {
        return _health;
    }

    @Override
    public long getExperience() {
        return _experience;
    }

    @Override
    public int getAttackPower() {
        return _attack;
    }

    @Override
    public void setAttackPower(int attackPower) {
        _attack = attackPower;
    }

    @Override
    public void defend() {

    }

    @Override
    public void jump() {

    }

    @Override
    public int heal() {
        _health += _heal;
        return _heal;
    }
    public int heal(int healthGain) {
        _health = _heal + healthGain;
        return _heal + healthGain;
    }

    @Override
    public void attack(Character opponent) {
    }

    @Override
    public double decreaseHealth(int opponentAttackPower) {
        _health = _health - opponentAttackPower;
        return 0;
    }

    @Override
    public long gainExperience(long experience) {
        _experience +=experience;
        return 0;
    }






    public void setName(String x){this._name = x;}

    public String getPlayerClass(){return _playerClass;}
    public void setPlayerClass(String x){this._playerClass = x;}

    public String getRole(){return _role;}
    public void setRole(String x){this._role = x;}

    public int getLevel(){return _level;}
    public void setLevel(int x){this._level = x;}

    public Weapon getWeapon(){return _Weapon;}
    public void setWeapon(Weapon weapon){this._Weapon = weapon;}
}
