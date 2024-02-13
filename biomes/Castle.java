package biomes;

import entities.*;
import items.Armor;
import items.Weapon;

public class Castle extends Biome {
  public Castle() {
    enemyNames[0] = "Regular knight";
    enemyNames[1] = "Painting in shining armor";
    enemyNames[2] = "Corpse in shackles";
    enemyNames[4] = "Angsty bath robe";
  }

  public void lookAround(Hero hero) {
    if (hero.getMovesDone()-lastMoveHere > 6) {
      if (isDay()) {
        Enemy e = new Enemy(getRandInt(25, 45), getRandInt(12, 20), getRandInt(8, 16), getEnemyName());
        e.customGoldValue(getRandInt(12, 24));
        System.out.println("You are goind around the castle at daytime and " + e.getName() + " catches you!");
      } else {
        Enemy e = new Enemy(getRandInt(45, 75), getRandInt(16, 28), getRandInt(16, 22), getEnemyName());
        if (getRandInt(1, 2) == 1) {
          e.setDrop(new Weapon(getRandInt(7, 16)));
        } else {
          e.setDrop(new Armor(getRandInt(9, 18)));
        }
        System.out.println("You are sneaking around the castle at nighttime and " + e.getName() + " catches you!");
        hero.fight(e);
      }
    } else {
      System.out.println("You have been here a moment ago");
    }
    heroWasHere(hero);
  }
}
