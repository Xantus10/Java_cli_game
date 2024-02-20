package biomes;

public class Map {
  private int[][] intMap;
  private Biome[][] objMap;
  private int x = 5;
  private int y = 5;

  public Map() {
    intMap = new int[][]{{0, 0, 0, 2, 1, 1, 0, 0, 0, 0},
                         {0, 0, 2, 1, 1, 1, 4, 4, 1, 0},
                         {0, 2, 2, 1, 1, 1, 2, 2, 2, 0},
                         {2, 3, 2, 2, 2, 1, 2, 0, 0, 0},
                         {2, 3, 2, 2, 2, 1, 2, 2, 0, 0},
                         {2, 3, 2, 2, 1, 1, 1, 1, 2, 0},
                         {0, 2, 2, 2, 2, 1, 1, 2, 2, 0},
                         {0, 0, 2, 0, 0, 0, 1, 6, 1, 0},
                         {0, 0, 1, 5, 2, 1, 1, 1, 0, 0},
                         {0, 0, 2, 2, 2, 0, 0, 0, 0, 0}}; ////// For now use staticly generated map
    
    objMap = new Biome[][]{{new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()},
                          {new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()},
                          {new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()},
                          {new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()},
                          {new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()},
                          {new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()},
                          {new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()},
                          {new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()},
                          {new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()},
                          {new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void(), new Void()}}; /////// For now we jsut have to initialize it
     
    for (int i=0; i<intMap.length; i++) {
      for (int j=0; j<intMap[0].length; j++) {
        switch (intMap[i][j]) {
          case 1:
            objMap[i][j] = new Fields();
            break;
          case 2:
            objMap[i][j] = new Forest();
            break;
          case 3:
            objMap[i][j] = new DarkForest();
            break;
          case 4:
            objMap[i][j] = new Castle();
            break;
          case 5:
            objMap[i][j] = new Lake();
            break;
          case 6:
            objMap[i][j] = new Village();
            break;
        
          default:
            break;
        }
      }
    }
  }

  public void printNineTiles() {
    System.out.println("----------------------------------\n|          |          |          |");
    for (int i=x-1; i<x+2; i++) {
      System.out.print("|");
      for (int j=y-1; j<y+2; j++) {
        System.out.print(getBiomeString(intMap[i][j]) + "|");
      }
      System.out.println("\n|          |          |          |\n----------------------------------");
    }
  }

  public void move(char dir) {
    switch (dir) {
      case 'w':
        x--;
        if (getCurrentBiomeId() == 0) {
          x++;
          System.out.println("You cannot go there!");
        } else if (x < 0) {
          x = 0;
          System.out.println("You cannot go there!");
        }
        break;
      case 's':
        x++;
        if (getCurrentBiomeId() == 0) {
          x--;
          System.out.println("You cannot go there!");
        } else if (x >= objMap.length) {
          x = objMap.length-1;
          System.out.println("You cannot go there!");
        }
        break;
      case 'a':
        y--;
        if (getCurrentBiomeId() == 0) {
          y++;
          System.out.println("You cannot go there!");
        } else if (x < 0) {
          y = 0;
          System.out.println("You cannot go there!");
        }
        break;
      case 'd':
        y++;
        if (getCurrentBiomeId() == 0) {
          y--;
          System.out.println("You cannot go there!");
        } else if (y >= objMap.length) {
          y = objMap[0].length-1;
          System.out.println("You cannot go there!");
        }
        break;
    }
  }

  public Biome getCurrentBiome() {
    return objMap[x][y];
  }

  private int getCurrentBiomeId() {
    return intMap[x][y];
  }

  // Return 10 chars
  private String getBiomeString(int id) {
    switch (id) {
      case 0:
        return "          ";
      case 1:
        return "  Fields  ";
      case 2:
        return "  Forest  ";
      case 3:
        return "DarkForest";
      case 4:
        return "  Castle  ";
      case 5:
        return "   Lake   ";
      case 6:
        return "  Village ";
    }
    return "          ";
  }
}
