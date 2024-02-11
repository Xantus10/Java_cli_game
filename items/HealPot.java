package items;

import entities.Hero;

public class HealPot extends Item {
  public HealPot(int aValue) {
    value = aValue;
    name = "Heal potion(" + Integer.toString(aValue) + ")";
  }

  public void use(Hero user, int ix) {
    user.heal(value);
    user.getInventory()[ix] = new Empty("");
  }

  @Override public String getPrintableInfo() {
    return name;
  }
}
