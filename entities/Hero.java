package entities;

import items.*;
import java.util.Scanner;

public class Hero extends Entity {
  private Item[] inventory = {new Empty(""), new Empty(""), new Empty(""), new Empty(""), new Empty(""), new Empty(""), new Empty(""), new Empty("")};
  private int xp;
  private int level;
  private int movesDone; // Moves done to check for repeated actions on the map

  public Hero(int aHp, int aAtk, int aDef, String aName) { // Add gold functionality
    hp = aHp;
    maxhp = aHp;
    atk = aAtk;
    def = aDef;
    name = aName;
    xp = 0;
    level = 1;
  }

  public void fight(Enemy enemy) { // MAKE MORE INTERACTIVE (RUN, ITEM, FIGHT)
    int heroDmg = calculateDmg();
    float heroDmgRed = calculateDmgReduction();
    int enemyDmg = enemy.calculateDmg();
    float enemyDmgRed = enemy.calculateDmgReduction();
    while (!isDead() && !enemy.isDead()) {
      enemy.reduceHp(Math.round(heroDmg * enemyDmgRed));
      System.out.println("Enemy has " + Integer.toString(enemy.getHp()) + " hp!");
      if (!enemy.isDead()) {
        reduceHp(Math.round(enemyDmg * heroDmgRed));
        System.out.println("You have " + Integer.toString(getHp()) + " hp!");
      } else {
        System.out.println("Congratulations you beat " + enemy.getName());
        if (enemy.getXpValue() > 0) {
          increaseXp(enemy.getXpValue());
        } else {
          increaseXp();
        }
        if (!"".equals(enemy.getDrop().getName())) {
          giveIntoInventory(enemy.getDrop());
        }
        changeGold(enemy.getGold());
      }
    }
  }

  public void changeGold(int posOrNegChange) {
    gold += posOrNegChange;
  }

  public int getMovesDone() {
    return movesDone;
  }

  public void incrementMovesDone() {
    movesDone++;
  }

  public int getXp() {
    return xp;
  }

  public void checkLevelBoundary() {
    if (xp > (level * 50)) {
      xp -= (level * 50);
      level += 1;
      checkLevelBoundary();
    }
  }

  public void increaseXp() {
    xp += (10+level*2);
    checkLevelBoundary();
  }

  public void increaseXp(int amount) {
    xp += amount;
    checkLevelBoundary();
  }

  public void printInventory() {
    System.out.println("INVENTORY\n" + "--------------------------");
    for (int i=0; i<inventory.length; i++) {
      System.out.println("|                        |");
      System.out.println("| " + Integer.toString(i+1) + " " + inventory[i].getName() + " ".repeat(21 - inventory[i].getName().length()) + "|");
      System.out.println("|                        |");
      System.out.println("--------------------------");
    }
  }

  public void giveIntoInventory(Item drop) {
    int ix = findIndexOf("");
    if (ix == -1) {
      System.out.println("You can pick up " + drop.getName() + ", but your inventory is full");
      printInventory();
      System.out.print("Enter the number to swap to or '0' to throw the item away: ");
      Scanner uin = new Scanner(System.in);
      int index = uin.nextInt();
      uin.nextLine(); // Clear the buffer
      uin.close();
      index--;
      if (index >= 0 && index < inventory.length) {
        inventory[index] = drop;
      } else {
        System.out.println("Item was thrown away"); // Maybe eventually make more user friendly to misinputs :)
      }
    } else {
      inventory[ix] = drop;
    }
  }

  public int findIndexOf(String name) {
    for (int i=0; i<inventory.length; i++) {
      if (name.equals(inventory[i].getName())) {
        return i;
      }
    }
    return -1;
  }

  public Item[] getInventory() {
    return inventory;
  }
}
