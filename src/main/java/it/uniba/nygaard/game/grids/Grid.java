package it.uniba.nygaard.game.grids;

/**
 * <h2> Grid </h2>
 * <p>
 * La classe Grid rappresenta una griglia di gioco.
 * </p>
 */
public abstract class Grid {

  private int dimension;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Grid.
   * </p>
   * @param newDimension Dimensione della griglia.
   */
  Grid(final int newDimension) {
    this.dimension = newDimension;
  }

  /**
   * <h3> setDimension </h3>
   * <p>
   * Imposta la dimensione della griglia.
   * </p>
   * @param newDimension Dimensione della griglia.
   */
  public void setDimension(final int newDimension) {
    this.dimension = newDimension;
  }

}
