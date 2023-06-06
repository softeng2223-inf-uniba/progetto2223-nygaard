package it.uniba.nygaard.game.entity.grids;

import it.uniba.nygaard.game.utility.UColor;
import it.uniba.nygaard.game.utility.UGrid;
import it.uniba.nygaard.game.utility.Util;

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
    super();
    grid = new Cell[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        grid[i][j] = new Cell('~');
      }
    }
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

    int headingEdgeWidth = this.getMaxRows() + Util.BORDER_ADDER;

    str += "-".repeat(headingEdgeWidth);
    str += UColor.PURPLE + UColor.BOLD + "Difesa" + UColor.RESET;
    str += "-".repeat(headingEdgeWidth);
    str += "\n\n";
    str += " ".repeat(Util.COLUMNS_EDGE_WIDTH);
    for (char y = Util.MIN_COLUMN; y <= this.getMaxColumn(); y++) {
      str += y + " ";
    }
    str += "\n\n";
    for (int x = Util.MIN_ROWS; x <= getMaxRows(); x++) {
      str += " ".repeat(Util.ROWS_EDGE_WIDTH);
      if (x < Util.FIRST_TWO_DIGITS) {
        str += " ";
      }
      str += x + "   ";
      for (char y = Util.MIN_COLUMN; y <= this.getMaxColumn(); y++) {
        c = this.getCellCharacter(x - 1, y - Util.MIN_COLUMN);
        switch (c) {
          case 'X':
            str += UColor.YELLOW;
            break;
          case '#':
            str += UColor.RED;
            break;
          case '~':
            str += UColor.CYAN;
            break;
          case '*':
            str += UColor.GREEN;
            break;
          default:
            str += UColor.RESET;
        }
        str += c + " " + UColor.RESET;
      }
      str += "  " + x + "\n";
    }
    str += "\n";
    str += " ".repeat(Util.COLUMNS_EDGE_WIDTH);
    for (char y = Util.MIN_COLUMN; y <= this.getMaxColumn(); y++) {
      str += y + " ";
    }
    str += "\n\n";
    str += "-".repeat(headingEdgeWidth);
    str += UColor.PURPLE + UColor.BOLD + "Difesa" + UColor.RESET;
    str += "-".repeat(headingEdgeWidth);
    str += "\n";
    return str;
  }

}
