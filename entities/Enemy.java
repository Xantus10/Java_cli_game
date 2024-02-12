package entities;

import items.Empty;
import items.Item;

public class Enemy extends Entity {
  private Item drop;
  private int xpValue;

  public Enemy(int aHp, int aAtk, int aDef, String aName) {
    hp = aHp;
    maxhp = aHp;
    atk = aAtk;
    def = aDef;
    name = aName;
    drop = new Empty("");
    xpValue = 0;
    gold = 0;
  }

  public Enemy(int aHp, int aAtk, int aDef, String aName, int aXpval) {
    this(aHp, aAtk, aDef, aName);
    xpValue = aXpval;
  }

  public void customGoldValue(int aGold) {
    gold = aGold;
  }

  public int getXpValue() {
    return xpValue;
  }

  public void setDrop(Item aDrop) {
    drop = aDrop;
  }

  public Item getDrop() {
    return drop;
  }
}
