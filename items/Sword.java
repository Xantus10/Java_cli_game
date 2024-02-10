package items;

import entities.Hero;

public class Sword extends Item {
  public Sword(String aName, int aAtk) {
    name = aName;
    value = aAtk;
  }

  public void use(Hero user) {
    int ix = user.findIndexOf(name);
    Item temp = user.sword;
    user.sword = user.getInventory()[ix];
    user.getInventory()[ix] = temp;
  }
}
