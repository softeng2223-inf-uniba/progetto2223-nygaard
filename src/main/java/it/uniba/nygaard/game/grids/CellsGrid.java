package it.uniba.nygaard.game.grids;

import it.uniba.nygaard.game.Util;

public class CellsGrid extends Grid {

  private Cell[][] grid;

  public CellsGrid(final int dimension) {
    super(dimension);
    grid = new Cell[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        grid[i][j] = new Cell('~');
      }
    }
  }

  public void setCell(final int row, final int column, final Cell cell) {
    grid[row][column] = cell;
  }

  public void setCellCharacter(final int row, final int column, final char character) {
    grid[row][column].setCharacter(character);
  }

  public void setCellShipIndex(final int row, final int column, final int shipIndex) {
    grid[row][column].setShipIndex(shipIndex);
  }

  public Cell getCell(final int row, final int column) {
    return grid[row][column];
  }

  public char getCellCharacter(final int row, final int column) {
    return grid[row][column].getCharacter();
  }

  public int getCellShipIndex(final int row, final int column) {
    return grid[row][column].getShipIndex();
  }

  public String toString() {
    String str = "";
    String tmp;
    char c;
    str += "-".repeat(Util.HEADING_EDGE_WIDTH);
    str += "Difesa";
    str += "-".repeat(Util.HEADING_EDGE_WIDTH);
    str += "\n\n";
    str += " ".repeat(Util.COLUMNS_EDGE_WIDTH);
    for (char y = Util.MIN_COLUMN; y <= Util.MAX_COLUMN; y++) {
      str += y + " ";
    }
    str += "\n\n";
    for (int x = Util.MIN_ROWS; x <= Util.MAX_ROWS; x++) {
      str += " ".repeat(Util.ROWS_EDGE_WIDTH);
      if (x < 10) {
        str += " ";
      }
      str += x + "   ";
      for (char y = Util.MIN_COLUMN; y <= Util.MAX_COLUMN; y++) {
        c = this.getCellCharacter(x - 1, y - Util.MIN_COLUMN);
        str += c + " ";
      }
      str += "  " + x + "\n";
    }
    str += "\n";
    str += " ".repeat(Util.COLUMNS_EDGE_WIDTH);
    for (char y = Util.MIN_COLUMN; y <= Util.MAX_COLUMN; y++) {
      str += y + " ";
    }
    str += " ".repeat(Util.COLUMNS_EDGE_WIDTH - 1);
    str += "\n\n";
    str += "-".repeat(Util.HEADING_EDGE_WIDTH);
    str += "Difesa";
    str += "-".repeat(Util.HEADING_EDGE_WIDTH);
    str += "\n";
    return str;
  }

}
