package NPC;

import java.util.Random;

/**
 * IDE: IntelliJ IDEA
 * File Name: NPC
 * Created by: Chad Eckles.
 * Date: 9/22/2017
 * INFO:
 */
public interface iNPC {
    Random randomGenerator = new Random();

    String getName();
    double getHealth();
    long getExperience();
    int getAttackPower();
    void setAttackPower(int attackPower);
    int getLevel();
    void setLevel();

    void defend();
    void jump();
    int heal();
    void attack(Character opponent);
    double decreaseHealth(int opponentAttackPower);
    long gainExperience(long experience);
}
