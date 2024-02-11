package items;

import entities.Hero;

public class Empty extends Item {
  public Empty(String aName) {
    name = aName;
    value = 0;
  }

  public void use(Hero user, int ix) {}
}
