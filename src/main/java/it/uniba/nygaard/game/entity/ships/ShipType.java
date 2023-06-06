package it.uniba.nygaard.game.entity.ships;

import it.uniba.nygaard.game.utility.UShip;

/**
 * <h2> ShipType </h2>
 * <p>
 *   La classe ShipType modella le tipologie di navi
 *   presenti nel gioco, con i loro hp e il numero di occorrenze.
 * </p>
 */
public enum ShipType {
  AIRCRAFT(UShip.AIRCRAFT_NO, UShip.AIRCRAFT_HP),
  BATTLESHIP(UShip.BATTLESHIP_NO, UShip.BATTLESHIP_HP),
  CRUISER(UShip.CRUISER_NO, UShip.CRUISER_HP),
  DESTROYER(UShip.DESTROYER_NO, UShip.DESTROYER_HP);

  private final int numShips;
  private final int hp;

  ShipType(final int newNumShips, final int newHp) {
    this.numShips = newNumShips;
    this.hp = newHp;
  }

  public int getNumShips() {
    return numShips;
  }

  public int getHp() {
    return hp;
  }
}
