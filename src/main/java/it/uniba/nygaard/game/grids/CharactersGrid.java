package it.uniba.nygaard.game.grids;

import it.uniba.nygaard.game.Util;

public final class CharactersGrid extends Grid {

  private char[][] grid;

  public CharactersGrid(final int dimension) {
    super(dimension);
    grid = new char[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        grid[i][j] = '~';
      }
    }
  }

  public void setCharacter(final int row, final int column, final char character) {
    grid[row][column] = character;
  }

  char getCharacter(final int row, final int column) {
    return grid[row][column];
  }

  public String toString() {
    String str = "";
    char c;
    str += "-".repeat(Util.HEADING_EDGE_WIDTH);
    str += "Attacco";
    str += "-".repeat(Util.HEADING_EDGE_WIDTH);
    str += "\n\n";
    str += " ".repeat(Util.COLUMNS_EDGE_WIDTH);
    for (char y = Util.MIN_COLUMN; y <= Util.MAX_COLUMN; y++) {
      str += y + " ";
    }
    str += "\n\n";
    for (int x = Util.MIN_ROWS; x <= Util.MAX_ROWS; x++) {
      str += " ".repeat(Util.ROWS_EDGE_WIDTH);
      if (x < Util.FIRST_TWO_DIGITS) {
        str += " ";
      }
      str += x + "   ";
      for (char y = Util.MIN_COLUMN; y <= Util.MAX_COLUMN; y++) {
        c = this.getCharacter(x - 1, y - Util.MIN_COLUMN);
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
    str += "Attacco";
    str += "-".repeat(Util.HEADING_EDGE_WIDTH);
    str += "\n";
    return str;
  }

}
