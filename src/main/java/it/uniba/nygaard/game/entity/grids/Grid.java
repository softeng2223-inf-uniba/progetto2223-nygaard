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
   * <h3> headingEdgeWidth </h3>
   * <p>
   * Larghezza del bordo superiore.
   * </p>
   */
  private int headingEdgeWidth;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Grid.
   * </p>
   */
  Grid() {
    maxRows = UGrid.STANDARD_GRID_SIZE;
    maxColumn = 'J';
  }

  /**
   * <h3> getHeadingEdgeWidth </h3>
   * <p>
   * Restituisce la larghezza del bordo superiore.
   * </p>
   *
   * @return Larghezza del bordo superiore.
   */
  public int getHeadingEdgeWidth() {
    return headingEdgeWidth;
  }

  /**
   * <h3> setHeadingEdgeWidth </h3>
   * <p>
   * Imposta la larghezza del bordo superiore.
   * </p>
   *
   * @param newHeadingEdgeWidth Larghezza del bordo superiore.
   */
  public void setHeadingEdgeWidth(final int newHeadingEdgeWidth) {
    this.headingEdgeWidth = newHeadingEdgeWidth;
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
