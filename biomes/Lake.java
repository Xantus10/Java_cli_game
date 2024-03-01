package biomes;

import entities.*;
import items.*;

public class Lake extends Biome {
  public Lake() {
    enemyNames[0] = "Mist fairy";
    enemyNames[1] = "Steam illusion";
    enemyNames[2] = "Huuuuuuge carp (At least 2m)";
    enemyNames[3] = "Angry and wet boot";
  }

  public void lookAround(Hero hero) {
    if (hero.getMovesDone()-lastMoveHere > 6) {
      System.out.println("You decide to try some fishing");
      for (int i=0; i<3; i++) {
        int randValue = getRandInt(1, 30);
        if (randValue < 8) {
          System.out.println("You got some gold!");
          hero.changeGold(getRandInt(8, 16));
        } else if (randValue < 16) {
          System.out.println("You got some healing potion!");
          hero.giveIntoInventory(new HealPot(getRandInt(20, 70)));
        } else if (randValue < 24) {
          Enemy e = new Enemy(getRandInt(30, 50), getRandInt(12, 24), getRandInt(9, 14), getEnemyName(), 15);
          System.out.println("Uh oh, you seem to have angered the " + e.getName() + ". Now you have to fight!");
          e.customGoldValue(14);
          hero.fight(e);
        } else if (randValue < 26) {
          System.out.println("Wow you reeled in a new weapon!");
          hero.giveIntoInventory(new Weapon(getRandInt(9, 17)));
        } else if (randValue < 29) {
          System.out.println("Wow you reeled in a new armor!");
          hero.giveIntoInventory(new Armor(getRandInt(7, 17)));
        } else if (!isDay()) {
          Enemy e;
          if (randValue == 29) {
            e = new Enemy(100, 24, 50, "Lord of depths Trogir", 40);
            e.setDrop(new Armor("Veil of darkness", 50));
          } else {
            e = new Enemy(100, 50, 24, "Queen of silent waters Xespa", 40);
            e.setDrop(new Weapon("EiHaSwDiSiDiGeMa", 50));
          }
          e.customGoldValue(30);
          System.out.println("Uh oh, you have angered something. " + e.getName() + " is coming. R U N");
        } else {
          System.out.println("Unfortounately nothing happend");
        }
      }
    } else {
      System.out.println("You have been here a moment ago");
    }
    heroWasHere(hero);
  }
}
