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
  public Item weapon = new Empty("");

  public float calculateDmgReduction() {
    return 1 - ((def + armor.getValue())/100);
  }

  public int calculateDmg() {
    return atk + weapon.getValue();
  }

  public void reduceHp(int dmg) {
    hp -= dmg;
    if (hp < 0) {
      hp = 0;
    }
  }

  public void heal(int healValue) {
    hp += healValue;
    if (hp > maxhp) {
      hp = maxhp;
    }
  }

  public void printInfo() {
    System.out.println("INFO on " + getName() + "\n HP:  " + Integer.toString(hp) + "/" + Integer.toString(maxhp) + "\n ATK: " + Integer.toString(atk) + "\n DEF: " + Integer.toString(def) + "\n\n Armor: " + armor.getName() + "\n\n Weapon: " + weapon.getName());
  }

  public boolean isDead() {
    return hp <= 0;
  }

  public String getName() {
    return name;
  }

  public int getHp() {
    return hp;
  }

  public int getAtk() {
    return atk;
  }

  public int getDef() {
    return def;
  }
}
