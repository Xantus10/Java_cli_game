package main;

import java.util.Scanner;
import java.util.Random;
import biomes.Map;
import entities.Hero;

public class Main {
  private static Random randomNumberGenerator = new Random();
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Hello and welcome to my RPG game");
    Hero hero = new Hero(120, getRandInt(8, 18), getRandInt(8, 16), userInput.nextLine());
    Map map = new Map();
    hero.printInfo();
    hero.printInventory();
    map.printNineTiles();
    while (hero.getHp() > 0) {
      System.out.println("[1] Go somewhere\n[2] Look around here\n[3] Print info\n[4] Use an item\n[0] Exit");
      /////////////////////////////// COMPLETE MAIN
    }
  }

  private static int getRandInt(int lower, int upper) {
    return randomNumberGenerator.nextInt(upper - lower + 1) + lower;
  }
}
