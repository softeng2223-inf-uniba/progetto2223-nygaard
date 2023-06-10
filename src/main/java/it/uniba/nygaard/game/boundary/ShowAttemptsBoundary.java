package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.utility.UColor;

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
    System.out.println(UColor.CYAN + "Hai già effettuato " + UColor.BOLD + usedAttempts + " tentativi " + UColor.RESET
        + UColor.CYAN + "di cui " + UColor.BOLD + failedAttempts + " falliti." + UColor.RESET);
    showAttempts(maxAttempts);
  }

  /**
   * <h3> showAttempts </h3>
   * <p>
   * Stampa il numero di tentativi massimi fallibili dall'utente.
   * </p>
   *
   * @param maxAttempts Tentativi massimi fallibili
   */
  public static void showAttempts(final int maxAttempts) {
    System.out.println(UColor.CYAN + "Puoi fallire al massimo " + UColor.BOLD + maxAttempts + " tentativi"
        + UColor.RESET);
  }

}
