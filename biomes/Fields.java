package biomes;

import entities.*;
import items.HealPot;

public class Fields extends Biome {
  public Fields() {
    enemyNames[0] = "Angry Mole";
    enemyNames[1] = "Moonflower";
    enemyNames[2] = "ROOTer";
    enemyNames[4] = "Big Weed";
  }

  public void lookAround(Hero hero) {
    if (hero.getMovesDone()-lastMoveHere > 6) {
      if (isDay()) {
        System.out.println("You stop on a peaceful field to pick some flowers");
        hero.giveIntoInventory(new HealPot(getRandInt(15, 40)));
      } else {
        Enemy e = new Enemy(getRandInt(25, 45), getRandInt(12, 20), getRandInt(8, 16), getEnemyName());
        e.setDrop(new HealPot(getRandInt(15, 40)));
        hero.fight(e);
      }
    } else {
      System.out.println("You have been here a moment ago");
    }
    lastMoveHere = hero.getMovesDone();
  }
}
