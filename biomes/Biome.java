package biomes;

import entities.Hero;
import java.time.LocalTime;
import java.util.Random;

public abstract class Biome {
  private Random randomNumberGenerator = new Random();
  protected String[] enemyNames = new String[4];
  protected int lastMoveHere = 0;
  
  public abstract void lookAround(Hero hero);

  protected boolean isDay() {
    return LocalTime.now().getHour() % 2 == 0;
  }

  protected String getEnemyName() {
    return enemyNames[getRandInt(0, enemyNames.length-1)];
  }

  protected int getRandInt(int lower, int upper) {
    return randomNumberGenerator.nextInt(upper - lower + 1) + lower;
  }
}
