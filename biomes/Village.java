package biomes;

import entities.*;
import items.*;

public class Village extends Biome {
  public Village() {}

  public void lookAround(Hero hero) {
    if (isDay()) {
      System.out.println("You visit the local shop in hopes of finding something good");
      System.out.println("Your gold: " + Integer.toString(hero.getGold()) + "g");
      System.out.print("\nWelcome to Dorby's, what do you want to buy?\n [1] Healing potion (50) - 50g\n [2] Great sword (20 atk) - 75g\n [3] Iron chestplate (20 def) - 80g\n [0] Leave\n> ");
      int index = Item.userInput.nextInt();
      Item.userInput.nextLine(); // Clear the buffer
      switch (index) {
        case 1:
          if (hero.getGold() >= 50) {
            hero.giveIntoInventory(new HealPot(50));
          }
          break;
        case 2:
          if (hero.getGold() >= 75) {
            hero.giveIntoInventory(new Weapon("Great sword", 20));
          }
          break;
        case 3:
          if (hero.getGold() >= 80) {
            hero.giveIntoInventory(new Armor("Iron chestplate", 20));
          }
          break;
      }
      System.out.println("Thank you for visiting. Don't come here during night though.");
    } else {
      Enemy e = new Enemy(getRandInt(35, 55), getRandInt(22, 30), getRandInt(10, 18), "Unsightly creature");
      e.customGoldValue(getRandInt(1, 5));
      System.out.println("You shouldn't be here. You open the door to Dorby's, but there you find only an unsightly creature, crawling towards you.");
      hero.fight(e);
    }
    heroWasHere(hero);
  }
}
