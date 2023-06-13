package it.uniba.nygaard.game.entity.ships;

import it.uniba.nygaard.game.utility.UShip;

/**
 * <h2> ShipType </h2>
 * <p>
 *   La classe ShipType modella le tipologie di navi
 *   presenti nel gioco, con i loro hp e il numero di occorrenze.
 *   Sono presenti quattro tipologie di navi: Aircraft, Battleship, Cruiser e Destroyer.
 * </p>
 */
public enum ShipType {

  AIRCRAFT(UShip.AIRCRAFT_NO, UShip.AIRCRAFT_HP),
  BATTLESHIP(UShip.BATTLESHIP_NO, UShip.BATTLESHIP_HP),
  CRUISER(UShip.CRUISER_NO, UShip.CRUISER_HP),
  DESTROYER(UShip.DESTROYER_NO, UShip.DESTROYER_HP);

  /**
   * <h3> numShips </h3>
   * <p>
   * Numero di occorrenze della nave.
   * </p>
   */
  private final int numShips;

  /**
   * <h3> hp </h3>
   * <p>
   * Hp della nave.
   * </p>
   */
  private final int hp;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ShipType.
   * Imposta il numero di occorrenze e gli hp della nave.
   * </p>
   *
   * @param newNumShips Numero di occorrenze della nave.
   * @param newHp Hp della nave.
   */

  ShipType(final int newNumShips, final int newHp) {
    this.numShips = newNumShips;
    this.hp = newHp;
  }

  /**
   * <h3> getNumShips </h3>
   * Restituisce il numero di occorrenze della nave.
   * @return
   */
  public int getNumShips() {
    return numShips;
  }

  /**
   * <h3> getHp </h3>
   * Restituisce gli hp della nave.
   * @return
   */
  public int getHp() {
    return hp;
  }
}
