package items;

import entities.Hero;

public class Weapon extends Item {
  public Weapon(int aAtk) {
    names[0] = "Good sword";
    names[1] = "Bow&Arrows";
    names[2] = "LightSpear";
    names[3] = "Magic Tome";
    createName();
    value = aAtk;
  }

  public Weapon(String aName, int aAtk) {
    name = aName;
    value = aAtk;
  }

  public void use(Hero user, int ix) {
    Item temp = user.weapon;
    user.weapon = user.getInventory()[ix];
    user.getInventory()[ix] = temp;
  }
}
