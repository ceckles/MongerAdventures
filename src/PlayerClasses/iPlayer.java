package PlayerClasses;

import java.util.Random;

/**
 * IDE: IntelliJ IDEA
 * File Name: PlayerSpec
 * Created by: Chad Eckles.
 * Date: 8/3/2017
 * INFO:
 */
public interface iPlayer {
    Random randomGenerator = new Random();

    String getName();
    double getHealth();
    long getExperience();
    int getAttackPower();
    void setAttackPower(int attackPower);

    void defend();
    void jump();
    int heal();
    void attack(Character opponent);
    double decreaseHealth(int opponentAttackPower);
    long gainExperience(long experience);
}
