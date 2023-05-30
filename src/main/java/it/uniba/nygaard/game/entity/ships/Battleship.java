package it.uniba.nygaard.game.entity.ships;

import it.uniba.nygaard.game.Util;

/**
 * <h2> Battleship </h2>
 * <p>
 * La classe Battleship rappresenta la nave Corazzata.
 * </p>
 *
 * @see Ship
 */
public class Battleship extends Ship {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Battleship.
   * </p>
   */
  public Battleship() {
    super(Util.BATTLESHIP_HP);
  }

}
