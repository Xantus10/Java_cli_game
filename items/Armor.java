package items;

import entities.Hero;

public class Armor extends Item {
  public Armor(String aName, int aDef) {
    name = aName;
    value = aDef;
  }

  public void use(Hero user, int ix) {
    Item temp = user.armor;
    user.armor = user.getInventory()[ix];
    user.getInventory()[ix] = temp;
  }
}
