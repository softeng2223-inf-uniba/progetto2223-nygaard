package it.uniba.nygaard.game.entity.grids;

import it.uniba.nygaard.game.Util;

/**
 * <h2> Cell </h2>
 * <p>
 * La classe Cell rappresenta una cella della griglia (di difesa).
 * </p>
 */
class Cell {

  /**
   * <h3> character </h3>
   * <p>
   * Carattere della cella.
   * </p>
   */
  private char character;
  /**
   * <h3> shipIndex </h3>
   * <p>
   * Indice della nave della cella.
   * </p>
   */
  private int shipIndex;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Cell.
   * </p>
   *
   * @param c Carattere della cella.
   */
  Cell(final char c) {
    this.character = c;
    this.shipIndex = Util.SEA_INDEX;
  }

  /**
   * <h3> setCharacter </h3>
   * <p>
   * Imposta il carattere della cella.
   * </p>
   *
   * @param newCharacter Carattere da impostare.
   */
  void setCharacter(final char newCharacter) {
    this.character = newCharacter;
  }

  /**
   * <h3> setShipIndex </h3>
   * <p>
   * Imposta l'indice della nave della cella.
   * </p>
   *
   * @param newShipIndex Indice della nave da impostare.
   */
  void setShipIndex(final int newShipIndex) {
    this.shipIndex = newShipIndex;
  }

  /**
   * <h3> getCharacter </h3>
   * <p>
   * Restituisce il carattere della cella.
   * </p>
   *
   * @return Carattere della cella.
   */
  char getCharacter() {
    return character;
  }

  /**
   * <h3> getShipIndex </h3>
   * <p>
   * Restituisce l'indice della nave della cella.
   * </p>
   *
   * @return Indice della nave della cella.
   */
  int getShipIndex() {
    return shipIndex;
  }

}
