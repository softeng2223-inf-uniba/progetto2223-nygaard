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

  Cell getCell(int row, int column) {
    return grid[row][column];
  }

  public char getCellCharacter(int row, int column) {
    return grid[row][column].getCharacter();
  }

  public int getCellShipIndex(int row, int column) {
    return grid[row][column].getShipIndex();
  }

  String toString(Grid grid) {
    String str = "";
    char c;
    str += Util.concatCharacters('-', Util.HEADING_EDGE_WIDTH);
    str += "Difesa";
    str += Util.concatCharacters('-', Util.HEADING_EDGE_WIDTH);
    str += "\n\n";
    str += Util.concatCharacters(' ', Util.COLUMNS_EDGE_WIDTH);
    for (char y = Util.MIN_COLUMN; y <= Util.MAX_COLUMN; y++) {
      str += y + " ";
    }
    str += "\n\n";
    for (int x = Util.MIN_ROWS; x <= Util.MAX_ROWS; x++) {
      str += Util.concatCharacters(' ', Util.ROWS_EDGE_WIDTH);
      if (x < 10) {
        str += " ";
      }
      str += x + "   ";
      for (char y = Util.MIN_COLUMN; y <= Util.MAX_COLUMN; y++) {
        c = ((CellsGrid) grid).getCellCharacter(x - 1, y - 'A');
        str += c + " ";
      }
      str += "  " + x + "\n";
    }
    str += "\n";
    str += Util.concatCharacters(' ', Util.COLUMNS_EDGE_WIDTH);
    for (char y = Util.MIN_COLUMN; y <= Util.MAX_COLUMN; y++) {
      str += y + " ";
    }
    str += Util.concatCharacters(' ', Util.COLUMNS_EDGE_WIDTH - 1);
    str += "\n\n";
    str += Util.concatCharacters('-', Util.HEADING_EDGE_WIDTH);
    str += "Difesa";
    str += Util.concatCharacters('-', Util.HEADING_EDGE_WIDTH);
    str += "\n";
    return str;
  }

}
