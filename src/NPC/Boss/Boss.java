package NPC.Boss;

import NPC.iNPC;

/**
 * IDE: IntelliJ IDEA
 * File Name: Boss
 * Created by: Chad Eckles.
 * Date: 9/22/2017
 * INFO:
 */
public class Boss implements iNPC {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public long getExperience() {
        return 0;
    }

    @Override
    public int getAttackPower() {
        return 0;
    }

    @Override
    public void setAttackPower(int attackPower) {

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void setLevel() {

    }

    @Override
    public void defend() {

    }

    @Override
    public void jump() {

    }

    @Override
    public int heal() {
        return 0;
    }

    @Override
    public void attack(Character opponent) {

    }

    @Override
    public double decreaseHealth(int opponentAttackPower) {
        return 0;
    }

    @Override
    public long gainExperience(long experience) {
        return 0;
    }
}
