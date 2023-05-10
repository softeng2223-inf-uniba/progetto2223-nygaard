package it.uniba.nygaard.game;

public class CharactersGrid extends Grid {

  char[][] grid;

  public CharactersGrid(int dimension) {
    super(dimension);
    grid = new char[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        grid[i][j] = '~';
      }
    }
  }

}
