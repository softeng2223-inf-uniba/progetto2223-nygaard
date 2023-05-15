package it.uniba.nygaard.game.grids;

import it.uniba.nygaard.game.Util;

/**
 * <h2> CharactersGrid </h2>
 * <p>
 * La classe CharactersGrid rappresenta la griglia di attacco (griglia di caratteri).
 * </p>
 *
 * @see Grid
 */
public final class CharactersGrid extends Grid {

  private final char[][] grid;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe CharactersGrid.
   * </p>
   *
   * @param dimension Dimensione della griglia.
   */
  public CharactersGrid(final int dimension) {
    super(dimension);
    grid = new char[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        grid[i][j] = '~';
      }
    }
  }

  /**
   * <h3> setCharacter </h3>
   * <p>
   * Imposta un carattere della griglia.
   * </p>
   *
   * @param row       Riga del carattere.
   * @param column    Colonna del carattere.
   * @param character Carattere da impostare.
   */
  public void setCharacter(final int row, final int column, final char character) {
    grid[row][column] = character;
  }

  /**
   * <h3> getCharacter </h3>
   * <p>
   * Restituisce un carattere della griglia.
   * </p>
   *
   * @param row    Riga del carattere.
   * @param column Colonna del carattere.
   * @return Carattere della griglia.
   */
  private char getCharacter(final int row, final int column) {
    return grid[row][column];
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
    str += "-".repeat(Util.HEADING_EDGE_WIDTH);
    str += Util.PURPLE + "Attacco" + Util.RESET;
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
          default:
            str += Util.RESET;
        }
        str += c + " " + Util.RESET;
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
    str += Util.PURPLE + "Attacco" + Util.RESET;
    str += "-".repeat(Util.HEADING_EDGE_WIDTH);
    str += "\n";
    return str;
  }

}
