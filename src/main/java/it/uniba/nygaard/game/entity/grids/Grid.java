package it.uniba.nygaard.game.entity.grids;

import it.uniba.nygaard.game.utility.UGrid;

/**
 * <h2> Grid </h2>
 * <p>
 * La classe Grid rappresenta una griglia di gioco.
 * </p>
 */
public abstract class Grid {

  /**
   * <h3> maxRows </h3>
   * <p>
   * Numero massimo di righe.
   * </p>
   */
  private int maxRows;
  /**
   * <h3> maxColumn </h3>
   * <p>
   * Numero massimo di colonne.
   * </p>
   */
  private char maxColumn;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Grid.
   * Imposta il numero massimo di righe e colonne.
   * </p>
   */
  Grid() {
    maxRows = UGrid.STANDARD_GRID_SIZE;
    maxColumn = 'J';
  }

  /**
   * <h3> getMaxRows </h3>
   * <p>
   * Restituisce il numero massimo di righe.
   * </p>
   *
   * @return Numero massimo di righe.
   */
  public int getMaxRows() {
    return maxRows;
  }

  /**
   * <h3> setMaxRows </h3>
   * <p>
   * Imposta il numero massimo di righe.
   * </p>
   *
   * @param newMaxRows Numero massimo di righe.
   */
  public void setMaxRows(final int newMaxRows) {
    maxRows = newMaxRows;
  }

  /**
   * <h3> getMaxColumn </h3>
   * <p>
   * Restituisce il numero massimo di colonne.
   * </p>
   *
   * @return Numero massimo di colonne.
   */
  public char getMaxColumn() {
    return maxColumn;
  }

  /**
   * <h3> setMaxColumn </h3>
   * <p>
   * Imposta il numero massimo di colonne.
   * </p>
   *
   * @param newMaxColumn Numero massimo di colonne.
   */
  public void setMaxColumn(final char newMaxColumn) {
    maxColumn = newMaxColumn;
  }
}
