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

  public void printNineTiles() {}

  public void move(char dir) {}

  public Biome getCurrentBiome() {
    return objMap[x][y];
  }
}
