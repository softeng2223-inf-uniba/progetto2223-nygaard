package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

/**
 * <h2> HitBoundary </h2>
 * <p>
 * La classe HitBoundary stampa i messaggi
 * relativi ai colpi effettuati.
 * </p>
 */
public final class HitBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe HitBoundary.
   * </p>
   */
  private HitBoundary() {
  }

  /**
   * <h3> notInGame </h3>
   * <p>
   * Stampa il messaggio di errore relativo
   * al tentativo di effettuare un colpo
   * senza essere in una partita.
   * </p>
   */
  public static void notInGame() {
    System.out.println(Util.RED + "Non puoi eseguire colpi se non sei in una partita" + Util.RESET);
  }

  /**
   * <h3> invalidCoordinates </h3>
   * <p>
   * Stampa il messaggio di errore relativo
   * al tentativo di effettuare un colpo
   * con coordinate non valide.
   * </p>
   */
  public static void invalidChoice() {
    System.out.println(Util.RED + "Coordinate non valide" + Util.RESET);
  }

  /**
   * <h3> miss </h3>
   * <p>
   * Stampa il messaggio relativo al fatto
   * che il colpo effettuato è andato a vuoto.
   * </p>
   */
  public static void miss() {
    System.out.println(Util.BOLD + "Acqua!" + Util.RESET);
  }

  /**
   * <h3> hit </h3>
   * <p>
   * Stampa il messaggio relativo al fatto
   * che il colpo effettuato ha colpito una nave.
   * </p>
   */
  public static void hit() {
    System.out.println(Util.YELLOW + Util.BOLD + "Colpito!" + Util.RESET);
  }

  /**
   * <h3> sunk </h3>
   * <p>
   * Stampa il messaggio relativo al fatto
   * che il colpo effettuato ha affondato una nave.
   * </p>
   */
  public static void sunk() {
    System.out.println(Util.RED + Util.BOLD + "Colpito e affondato!" + Util.RESET);
  }

}
