package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

/**
 * << Boundary >>
 * <h2> LogoBoundary </h2>
 * <p>
 * La classe LogoBoundary stampa il logo del gioco.
 * </p>
 */
public final class LogoBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe LogoBoundary.
   * </p>
   */
  private LogoBoundary() {
  }

  /**
   * <h3> printLogo </h3>
   * <p>
   * Stampa il logo del gioco.
   * </p>
   */
  public static void printLogo() {
    String logo = Util.BOLD + Util.RED
        + "    ____   ___   ______ ______ __     ______ _____  __  __ ____ ____ \n"
        + "   / __ ) /   | /_  __//_  __// /    / ____// ___/ / / / //  _// __ \\\n"
        + "  / __  |/ /| |  / /    / /  / /    / __/   \\__ \\ / /_/ / / / / /_/ /\n"
        + Util.BLUE
        + " / /_/ // ___ | / /    / /  / /___ / /___  ___/ // __  /_/ / / ____/ \n"
        + "/_____//_/  |_|/_/    /_/  /_____//_____/ /____//_/ /_//___//_/      \n"
        + Util.RESET;
    System.out.println(logo);
  }
}
