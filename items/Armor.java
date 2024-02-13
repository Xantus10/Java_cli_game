package items;

import entities.Hero;

public class Armor extends Item {
  public Armor(int aDef) {
    names[0] = "Chain vest";
    names[1] = "Wooden shield";
    names[2] = "Part of a chestplate";
    names[3] = "Nightcap";
    createName();
    value = aDef;
  }

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
