package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

/**
 * <<Boundary>>
 * <h2> ShowAttemptsBoundary </h2>
 * <p>
 * La classe ShowAttemptsBoundary stampa il numero di tentativi
 * effettuati, falliti e massimi fallibili dall'utente.
 * </p>
 */
public final class ShowAttemptsBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ShowAttemptsBoundary.
   * </p>
   */
  private ShowAttemptsBoundary() {
  }

  /**
   * <h3> showAttempts </h3>
   * <p>
   * Stampa il numero di tentativi effettuati, falliti e massimi fallibili dall'utente.
   * </p>
   *
   * @param usedAttempts   Tentativi effettuati
   * @param failedAttempts Tentativi falliti
   * @param maxAttempts    Tentativi massimi fallibili
   */
  public static void showAttempts(final int usedAttempts, final int failedAttempts, final int maxAttempts) {
    System.out.println(Util.CYAN + "Hai già effettuato " + Util.BOLD + usedAttempts + " tentativi " + Util.RESET
        + Util.CYAN + "di cui " + Util.BOLD + failedAttempts + " falliti." + Util.RESET);
    System.out.println(Util.CYAN + "Puoi fallire al massimo " + Util.BOLD + maxAttempts + " tentativi"
        + Util.RESET + Util.CYAN + " prima di perdere la partita." + Util.RESET);
  }
  public static void showAttempts(final int maxAttempts) {
    System.out.println(Util.CYAN + "Puoi fallire al massimo " + Util.BOLD + maxAttempts + " tentativi"
        + Util.RESET);
  }

}
