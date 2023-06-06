package it.uniba.nygaard.game.entity.ships;

import it.uniba.nygaard.game.Util;

/**
 * <h2> ShipType </h2>
 * <p>
 *   La classe ShipType modella le tipologie di navi
 *   presenti nel gioco, con i loro hp e il numero di occorrenze.
 * </p>
 */
public enum ShipType {
  AIRCRAFT(Util.AIRCRAFT_NO, Util.AIRCRAFT_CARRIER_HP),
  BATTLESHIP(Util.BATTLESHIP_NO, Util.BATTLESHIP_HP),
  CRUISER(Util.CRUISER_NO, Util.CRUISER_HP),
  DESTROYER(Util.DESTROYER_NO, Util.DESTROYER_HP);

  private final int numShips;
  private final int hp;

  ShipType(int numShips, int hp) {
    this.numShips = numShips;
    this.hp = hp;
  }

  public int getNumShips() {
    return numShips;
  }

  public int getHp() {
    return hp;
  }
}
