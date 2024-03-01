package biomes;

import entities.Hero;
import java.time.LocalTime;
import java.util.Random;

public abstract class Biome {
  private Random randomNumberGenerator = new Random();
  protected String[] enemyNames = new String[4];
  protected int lastMoveHere = -20;
  
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

  // All children WILL call this at the end of lookAround, no matter what
  protected void heroWasHere(Hero hero) {
    lastMoveHere = hero.getMovesDone();
    hero.incrementMovesDone();
  }
}
