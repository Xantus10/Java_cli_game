package entities;

import items.Item;

public class Enemy extends Entity {
  private Item drop;

  public Enemy(int aHp, int aAtk, int aDef, String aName) {
    hp = aHp;
    maxhp = aHp;
    atk = aAtk;
    def = aDef;
    name = aName;
  }

  public void setDrop(Item aDrop) {
    drop = aDrop;
  }

  public Item getDrop() {
    return drop;
  }
}
