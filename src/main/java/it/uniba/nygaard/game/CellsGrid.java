package it.uniba.nygaard.game;

public class CellsGrid extends Grid {

  Cell[][] grid;

  public CellsGrid(int dimension) {
    super(dimension);
    grid = new Cell[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        grid[i][j] = new Cell('~');
      }
    }
  }

}
