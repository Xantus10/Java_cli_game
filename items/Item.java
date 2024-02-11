package items;

import entities.Hero;

public abstract class Item {
  protected int value;
  // Ideally not longer than 20 chars
  protected String name;

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public String getPrintableInfo() {
    return name + ": " + Integer.toString(value);
  }

  abstract public void use(Hero user, int ix);
}
