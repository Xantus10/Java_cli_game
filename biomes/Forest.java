package biomes;

import entities.*;

public class Forest extends Biome {
  public Forest() {
    enemyNames[0] = "Highwayman";
    enemyNames[1] = "Angry stump";
    enemyNames[2] = "Giant mushroom";
    enemyNames[4] = "Stump remover XL";
  }

  public void lookAround(Hero hero) {
    if (hero.getMovesDone()-lastMoveHere > 6) {
      Enemy e = new Enemy(getRandInt(25, 45), getRandInt(12, 20), getRandInt(8, 16), getEnemyName());
      e.customGoldValue(getRandInt(10, 20));
      System.out.println("You find yourself in the middle of a forest and see a silhouette of " + e.getName() + " in the shadows");
      hero.fight(e);
    } else {
      System.out.println("You have been here a moment ago");
    }
    heroWasHere(hero);
  }
}
