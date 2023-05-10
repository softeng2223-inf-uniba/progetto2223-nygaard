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

  void setCell(int row, int column, Cell cell) {
    grid[row][column] = cell;
  }

  public void setCellCharacter(int row, int column, char character) {
    grid[row][column].setCharacter(character);
  }

  public void setCellShipIndex(int row, int column, int shipIndex) {
    grid[row][column].setShipIndex(shipIndex);
  }

}
