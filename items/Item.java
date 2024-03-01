package items;

import java.util.Random;
import java.util.Scanner;

import entities.Hero;

public abstract class Item {
  private Random randomNumberGenerator = new Random();
  protected int value;
  // Ideally not longer than 20 chars
  protected String name;
  protected String[] names = {"", "", "", ""};

  public static Scanner userInput = new Scanner(System.in);

  public static boolean isInteger(String str) {
    if (str == null) {
        return false;
    }
    int length = str.length();
    if (length == 0) {
        return false;
    }
    for (int i=0; i<length; i++) {
        char c = str.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }
    }
    return true;
  }

  protected int getRandInt(int lower, int upper) {
    return randomNumberGenerator.nextInt(upper - lower + 1) + lower;
  }

  protected void createName() {
    name = names[getRandInt(0, names.length-1)];
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public String getPrintableInfo() {
    return this.getClass().getSimpleName() + " " + name + ": " + Integer.toString(value);
  }

  abstract public void use(Hero user, int ix);
}
