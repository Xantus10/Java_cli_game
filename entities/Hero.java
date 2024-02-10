package entities;

import items.*;

public class Hero extends Entity {
  private Item[] inventory = {new Empty(""), new Empty(""), new Empty(""), new Empty(""), new Empty(""), new Empty(""), new Empty(""), new Empty("")};
  public int xp;
  public int level;

  public Hero(int aHp, int aAtk, int aDef, String aName) {
    hp = aHp;
    maxhp = aHp;
    atk = aAtk;
    def = aDef;
    name = aName;
  }

  public void fight(Enemy enemy) {
    
  }

  public void giveIntoInventory(Item drop) {

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
