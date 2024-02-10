package items;

import entities.Hero;

public abstract class Item {
  protected int value;
  protected String name;

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  abstract public void use(Hero user);
}
