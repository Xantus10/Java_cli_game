package biomes;

import entities.*;
import items.*;

public class Lake extends Biome {
  public Lake() {
    enemyNames[0] = "Mist fairy";
    enemyNames[1] = "Steam illusion";
    enemyNames[2] = "Huuuuuuge carp";
    enemyNames[4] = "Angry and wet boot";
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
          System.out.println("Uh oh, you seem to have angered the " + e.getName() + " now they are coming for you!");
          e.customGoldValue(14);
          hero.fight(e);
        } else if (randValue < 26) {
          System.out.println("Wow you reeled in a new weapon!");
          hero.giveIntoInventory(new Weapon(getRandInt(9, 17)));
        } else if (randValue < 29) {
          System.out.println("Wow you reeled in a new armor!");
          hero.giveIntoInventory(new Armor(getRandInt(7, 17)));
        } else if (!isDay()) {
          if (randValue == 29) {

          } else { ////////////////////////////////////////////////////// Make two special enemies with custom everything and then fight them (One will drop TheBestBestBest Shield - armor, the other will drop EiHaSwDiSiDiGeMa - weapon)

          }
          System.out.println("You decided to fish at night, thats why " + e.getName() + " appeared!");
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
