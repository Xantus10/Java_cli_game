package biomes;

import entities.*;
import items.Armor;
import items.Weapon;

public class DarkForest extends Biome {
  public DarkForest() {
    enemyNames[0] = "average looking witch";
    enemyNames[1] = "Shadow illusion";
    enemyNames[2] = "Mini Kerberos";
    enemyNames[3] = "Shy killer";
  }

  public void lookAround(Hero hero) {
    if (hero.getMovesDone()-lastMoveHere > 6) {
      Enemy e = new Enemy(getRandInt(45, 75), getRandInt(20, 28), getRandInt(12, 20), getEnemyName());
      if (getRandInt(1, 2) == 1) {
        e.setDrop(new Weapon(getRandInt(8, 16)));
      } else {
        e.setDrop(new Armor(getRandInt(6, 16)));
      }
      System.out.println("You have wandered into the dark forest and see " + e.getName() + " peeking from behind the trees");
      hero.fight(e);
    } else {
      System.out.println("You have been here a moment ago");
    }
    heroWasHere(hero);
  }
}
