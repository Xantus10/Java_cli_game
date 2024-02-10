package entities;

import items.Empty;
import items.Item;

public class Entity {
  protected int hp;
  protected int maxhp;
  protected int atk;
  protected int def;
  protected String name;
  public Item armor = new Empty("");
  public Item sword = new Empty("");

  public float calculateDmgReduction() {
    return 1 - ((def + armor.getValue())/100);
  }

  public int calculateDmg() {
    return atk + sword.getValue();
  }

  public int getAtk() {
    return atk;
  }

  public int getDef() {
    return def;
  }
}
