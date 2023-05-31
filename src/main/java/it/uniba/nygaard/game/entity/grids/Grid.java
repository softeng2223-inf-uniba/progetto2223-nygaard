package it.uniba.nygaard.game.entity.grids;

import it.uniba.nygaard.game.Util;

/**
 * <h2> Grid </h2>
 * <p>
 * La classe Grid rappresenta una griglia di gioco.
 * </p>
 */
public abstract class Grid {

    /**
     * <h3> dimension </h3>
     * <p>
     * Dimensione della griglia.
     * </p>
     */
  private int dimension;

  public int getMaxRows() {
    return maxRows;
  }

  public void setMaxRows(int maxRows) {
    this.maxRows = maxRows;
  }

  public char getMaxColumn() {
    return maxColumn;
  }

  public void setMaxColumn(char maxColumn) {
    this.maxColumn = maxColumn;
  }

  private int maxRows;
  private char maxColumn;


  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Grid.
   * </p>
   *
   * @param newDimension Dimensione della griglia.
   */
  Grid(final int newDimension) {
    this.dimension = newDimension;
    this.maxRows = Util.STANDARD_GRID_SIZE;
    this.maxColumn = 'J';
  }

  /**
   * <h3> setDimension </h3>
   * <p>
   * Imposta la dimensione della griglia.
   * </p>
   *
   * @param newDimension Dimensione della griglia.
   */
  public void setDimension(final int newDimension) {
    this.dimension = newDimension;
  }

  /**
   * <h3> getDimension </h3>
   * <p>
   * Restituisce la dimensione della griglia.
   * </p>
   *
   * @return Dimensione della griglia.
   */
  public int getDimension() {
    return this.dimension;
  }


}
