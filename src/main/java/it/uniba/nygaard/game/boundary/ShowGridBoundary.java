package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

/**
 * << Boundary >>
 * <h2> ShowGridBoundary </h2>
 * <p>
 * La classe ShowGridBoundary stampa la griglia di gioco.
 * </p>
 */
public final class ShowGridBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ShowGridBoundary.
   * </p>
   */
  private ShowGridBoundary() {
  }

  /**
   * <h3> notInGame </h3>
   * <p>
   * Stampa il messaggio di errore relativo al tentativo di
   * stampare la griglia di gioco senza essere in partita.
   * </p>
   */
  public static void notInGame() {
    System.out.println(Util.RED + "Non sei in partita" + Util.RESET);
  }

  /**
   * <h3> printGrid </h3>
   * <p>
   * Stampa la griglia di gioco.
   * </p>
   *
   * @param grid Griglia di gioco
   */
  public static void printGrid(final String grid) {
    System.out.println(grid);
  }
}
