package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.utility.UColor;
import it.uniba.nygaard.game.utility.UShip;

/**
 * << Boundary >>
 * <h2> ShowShipsBoundary </h2>
 * <p>
 * La classe ShowShipsBoundary stampa le navi disponibili.
 * </p>
 */
public final class ShowShipsBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ShowShipBoundary.
   * </p>
   */
  private ShowShipsBoundary() {
  }

  /**
   * <h3> showShips </h3>
   * <p>
   * Stampa le navi disponibili.
   * </p>
   */
  public static void showShips() {
    System.out.println(UColor.CYAN + UColor.ITALIC + "\tCacciatorpediniere \t" + UColor.RESET
        + "■".repeat(UShip.DESTROYER_HP) + "\t" + UColor.CYAN + UColor.BOLD
        + "Esemplari: " + UShip.DESTROYER_NO + UColor.RESET);
    System.out.println(UColor.CYAN + UColor.ITALIC + "\tIncrociatore \t\t" + UColor.RESET
        + "■".repeat(UShip.CRUISER_HP) + "\t" + UColor.CYAN + UColor.BOLD
        + "Esemplari: " + UShip.CRUISER_NO + UColor.RESET);
    System.out.println(UColor.CYAN + UColor.ITALIC + "\tCorazzata \t\t" + UColor.RESET
        + "■".repeat(UShip.BATTLESHIP_HP) + "\t" + UColor.CYAN + UColor.BOLD
        + "Esemplari: " + UShip.BATTLESHIP_NO + UColor.RESET);
    System.out.println(UColor.CYAN + UColor.ITALIC + "\tPortaerei \t\t" + UColor.RESET
        + "■".repeat(UShip.AIRCRAFT_HP) + "\t" + UColor.CYAN + UColor.BOLD
        + "Esemplari: " + UShip.AIRCRAFT_NO + UColor.RESET);
  }
}
