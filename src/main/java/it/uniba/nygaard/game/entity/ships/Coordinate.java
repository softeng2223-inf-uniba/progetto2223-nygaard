package it.uniba.nygaard.game.entity.ships;

/**
 * <h2> Coordinate </h2>
 * <p>
 * La classe Coordinate rappresenta la coordinata iniziale di una nave.
 * Se la nave è posizionata in verticale, la coordinata rappresenta la cella in alto.
 * Se la nave è posizionata in orizzontale, la coordinata rappresenta la cella a sinistra.
 * </p>
 *
 * @see Ship
 */
public final class Coordinate {

  private int row;
  private char column;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Coordinate.
   * </p>
   */
  public Coordinate() {

  }

  /**
   * <h3> setRow </h3>
   * <p>
   * Imposta la riga della coordinata.
   * </p>
   *
   * @param newRow Riga della coordinata.
   */
  public void setRow(final int newRow) {
    this.row = newRow;
  }

  /**
   * <h3> setColumn </h3>
   * <p>
   * Imposta la colonna della coordinata.
   * </p>
   *
   * @param newColumn Colonna della coordinata.
   */
  public void setColumn(final char newColumn) {
    this.column = newColumn;
  }

  /**
   * <h3> getRow </h3>
   * <p>
   * Restituisce la riga della coordinata.
   * </p>
   *
   * @return Riga della coordinata.
   */
  int getRow() {
    return row;
  }

  /**
   * <h3> getColumn </h3>
   * <p>
   * Restituisce la colonna della coordinata.
   * </p>
   *
   * @return Colonna della coordinata.
   */
  char getColumn() {
    return column;
  }

}
