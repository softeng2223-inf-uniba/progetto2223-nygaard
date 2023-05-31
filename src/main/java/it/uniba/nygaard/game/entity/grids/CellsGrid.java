package it.uniba.nygaard.game.entity.grids;

import it.uniba.nygaard.game.Util;

/**
 * <h2> CellsGrid </h2>
 * <p>
 * La classe CellsGrid rappresenta la griglia di difesa (griglia di celle carattere-intero).
 * </p>
 *
 * @see Grid
 */
public final class CellsGrid extends Grid {

    /**
     * <h3> grid </h3>
     * <p>
     * Griglia di celle carattere-intero.
     * </p>
     */
  private final Cell[][] grid;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe CellsGrid.
   * </p>
   *
   * @param dimension Dimensione della griglia.
   */
  public CellsGrid(final int dimension) {
    super(dimension);
    grid = new Cell[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        grid[i][j] = new Cell('~');
      }
    }
  }

  /**
   * <h3> setCell </h3>
   * <p>
   * Imposta una cella della griglia.
   * </p>
   *
   * @param row    Riga della cella.
   * @param column Colonna della cella.
   * @param cell   Cella da impostare.
   * @see Cell
   */
  public void setCell(final int row, final int column, final Cell cell) {
    grid[row][column] = cell;
  }

  /**
   * <h3> setCellCharacter </h3>
   * <p>
   * Imposta il carattere di una cella della griglia.
   * </p>
   *
   * @param row       Riga della cella.
   * @param column    Colonna della cella.
   * @param character Carattere da impostare.
   */
  public void setCellCharacter(final int row, final int column, final char character) {
    grid[row][column].setCharacter(character);
  }

  /**
   * <h3> setCellShipIndex </h3>
   * <p>
   * Imposta l'indice della nave di una cella della griglia.
   * </p>
   *
   * @param row       Riga della cella.
   * @param column    Colonna della cella.
   * @param shipIndex Indice della nave da impostare.
   */
  public void setCellShipIndex(final int row, final int column, final int shipIndex) {
    grid[row][column].setShipIndex(shipIndex);
  }

  /**
   * <h3> getCell </h3>
   * <p>
   * Restituisce una cella della griglia.
   * </p>
   *
   * @param row    Riga della cella.
   * @param column Colonna della cella.
   * @return Cella della griglia.
   * @see Cell
   */
  public Cell getCell(final int row, final int column) {
    return grid[row][column];
  }

  /**
   * <h3> getCellCharacter </h3>
   * <p>
   * Restituisce il carattere di una cella della griglia.
   * </p>
   *
   * @param row    Riga della cella.
   * @param column Colonna della cella.
   * @return Carattere della cella.
   */
  public char getCellCharacter(final int row, final int column) {
    return grid[row][column].getCharacter();
  }

  /**
   * <h3> getCellShipIndex </h3>
   * <p>
   * Restituisce l'indice della nave di una cella della griglia.
   * </p>
   *
   * @param row    Riga della cella.
   * @param column Colonna della cella.
   * @return Indice della nave della cella.
   */
  public int getCellShipIndex(final int row, final int column) {
    return grid[row][column].getShipIndex();
  }

  /**
   * <h3> toString </h3>
   * <p>
   * Restituisce una stringa che rappresenta la griglia.
   * </p>
   *
   * @return Stringa che rappresenta la griglia.
   */
  public String toString() {
    String str = "";
    char c;
    str += "-".repeat(Util.headingEdgeWidth);
    str += Util.PURPLE + Util.BOLD + "Difesa" + Util.RESET;
    str += "-".repeat(Util.headingEdgeWidth);
    str += "\n\n";
    str += " ".repeat(Util.COLUMNS_EDGE_WIDTH);
    for (char y = Util.MIN_COLUMN; y <= Util.maxColumn; y++) {
      str += y + " ";
    }
    str += "\n\n";
    for (int x = Util.MIN_ROWS; x <= Util.maxRows; x++) {
      str += " ".repeat(Util.ROWS_EDGE_WIDTH);
      if (x < Util.FIRST_TWO_DIGITS) {
        str += " ";
      }
      str += x + "   ";
      for (char y = Util.MIN_COLUMN; y <= Util.maxColumn; y++) {
        c = this.getCellCharacter(x - 1, y - Util.MIN_COLUMN);
        switch (c) {
          case 'X':
            str += Util.YELLOW;
            break;
          case '#':
            str += Util.RED;
            break;
          case '~':
            str += Util.CYAN;
            break;
          case '*':
            str += Util.GREEN;
            break;
          default:
            str += Util.RESET;
        }
        str += c + " " + Util.RESET;
      }
      str += "  " + x + "\n";
    }
    str += "\n";
    str += " ".repeat(Util.COLUMNS_EDGE_WIDTH);
    for (char y = Util.MIN_COLUMN; y <= Util.maxColumn; y++) {
      str += y + " ";
    }
    str += " ".repeat(Util.COLUMNS_EDGE_WIDTH - 1);
    str += "\n\n";
    str += "-".repeat(Util.headingEdgeWidth);
    str += Util.PURPLE + Util.BOLD + "Difesa" + Util.RESET;
    str += "-".repeat(Util.headingEdgeWidth);
    str += "\n";
    return str;
  }

}
