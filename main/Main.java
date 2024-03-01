package main;

import java.util.Random;
import biomes.Map;
import items.Item;
import entities.Hero;

public class Main {
  private static Random randomNumberGenerator = new Random();
  public static void main(String[] args) {
    System.out.println("Hello and welcome to my RPG game\nEnter your name: ");
    Hero hero = new Hero(120, getRandInt(8, 18), getRandInt(8, 16), Item.userInput.nextLine());
    Map map = new Map();
    hero.printInfo();
    hero.printInventory();
    String inp;
    int inpInt = 0;
    while (hero.getHp() > 0) {
      boolean tmp = true;
      while (tmp) {
        map.printNineTiles();
        System.out.println("[1] Go somewhere\n[2] Look around here\n[3] Print info\n[4] Use an item\n[0] Exit");
        inp = Item.userInput.nextLine();
        if (items.Item.isInteger(inp)) {
          inpInt = Integer.parseInt(inp);
          tmp = !(inpInt >= 0 && inpInt <= 4);
        }
      }
      switch (inpInt) {
        case 1:
          System.out.println("Type w/s/a/d for movement: ");
          inp = Item.userInput.nextLine();
          map.move(inp.charAt(0));
          break;
        case 2:
          map.getCurrentBiome().lookAround(hero);
          break;
        case 3:
          hero.printInfo();
          hero.printInventory();
          break;
        case 4:
          hero.printInventory();
          int ix = -1;
          while (!(ix > 0 && ix <= hero.getInventory().length)) {
            System.out.print("Number of item you want to use: ");
            ix = Item.userInput.nextInt();
            Item.userInput.nextLine();
          }
          ix--;
          hero.getInventory()[ix].use(hero, ix); 
          break;
        case 0:
          hero.reduceHp(hero.getHp()+1);
          break;
      }
    }
    Item.userInput.close();
  }

  private static int getRandInt(int lower, int upper) {
    return randomNumberGenerator.nextInt(upper - lower + 1) + lower;
  }
}
