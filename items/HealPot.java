package items;

import entities.Hero;

public class HealPot extends Item {
  public HealPot(int aValue) {
    value = aValue;
    name = "Heal potion(" + Integer.toString(aValue) + ")";
  }

  public void use(Hero user, int ix) {
    user.heal(value);
    user.getInventory()[ix] = new Empty(""); // Maybe there can be a problem with passing by reference, then it would have to be public
  }

  @Override public String getPrintableInfo() {
    return name;
  }
}
