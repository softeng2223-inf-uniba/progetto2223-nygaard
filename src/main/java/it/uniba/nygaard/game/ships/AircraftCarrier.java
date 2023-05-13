package it.uniba.nygaard.game.ships;

import it.uniba.nygaard.game.Util;

/**
 * <h2> AircraftCarrier </h2>
 * <p>
 * La classe AircraftCarrier rappresenta la nave Portaerei.
 * </p>
 *
 * @see Ship
 */
public class AircraftCarrier extends Ship {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe AircraftCarrier.
   * </p>
   */
  public AircraftCarrier() {
    super(Util.AIRCRAFT_CARRIER_HP);
  }

}
