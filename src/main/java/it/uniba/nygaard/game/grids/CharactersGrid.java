package it.uniba.nygaard.game.grids;

import it.uniba.nygaard.game.Util;

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

  void setCharacter(int row, int column, char character) {
    grid[row][column] = character;
  }

  char getCharacter(int row, int column) {
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
      if (x < 10) {
        str += " ";
      }
      str += x + "   ";
      for (char y = Util.MIN_COLUMN; y <= Util.MAX_COLUMN; y++) {
        c = ((CharactersGrid) grid).getCharacter(x - 1, y - 'A');
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
