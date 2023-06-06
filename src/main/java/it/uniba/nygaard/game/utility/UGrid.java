package it.uniba.nygaard.game.utility;

/**
 * <h2> UGrid </h2>
 * <p>
 *   La classe UGrid contiene delle costanti utili
 *   per la gestione della griglia di gioco.
 * </p>
 *
 */
public final class UGrid {
  public static final int COLUMNS_EDGE_WIDTH = 13;
  public static final int ROWS_EDGE_WIDTH = 8;
  public static final char SEA_CHARACTER = '~';
  public static final char SHIP_CHARACTER = '*';
  public static final char HITTED_SEA_CHARACTER = 'O';
  public static final char HITTED_SHIP_CHARACTER = 'X';
  public static final char SUNK_SHIP_CHARACTER = '#';
  public static final int STANDARD_GRID_SIZE = 10;
  public static final int LARGE_GRID_SIZE = 18;
  public static final int EXTRA_LARGE_GRID_SIZE = 26;
  public static final int MIN_ROWS = 1;
  public static final char MIN_COLUMN = 'A';
  public static final int BORDER_ADDER = 9;
  public static final int SEA_INDEX = -1;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe UGrid.
   * </p>
   */
  private UGrid() {
  }
}
