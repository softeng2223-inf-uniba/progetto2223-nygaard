package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.utility.UColor;
import it.uniba.nygaard.game.utility.UTime;
import it.uniba.nygaard.game.control.GameManager;

/**
 * << Boundary >>
 * <h2> TimeBoundary </h2>
 * <p>
 * La classe TimeBoundary stampa a video le informazioni relative al tempo di gioco
 * valido.
 * </p>
 */
public final class TimeBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe TimeBoundary.
   * </p>
   */
  private TimeBoundary() {
  }

  /**
   * <h3> invalidChoice </h3>
   * <p>
   * Stampa a video il messaggio di errore relativo a un tempo di gioco non valido.
   * </p>
   */
  public static void invalidChoice() {
    System.out.println(UColor.RED + "Tempo inserito non valido" + UColor.RESET);
  }

  /**
   * <h3> operationDone </h3>
   * <p>
   * Stampa il messaggio relativo all'aver impostato il tempo di gioco.
   * </p>
   */
  public static void operationDone() {
    System.out.println(UColor.GREEN + "OK" + UColor.RESET);
  }

  /**
   * <h3> alreadyInGame </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che non si può cambiare il tempo di gioco
   * se si è in partita.
   * </p>
   */
  public static void alreadyInGame() {
    System.out.println(UColor.RED + "Non puoi cambiare il tempo di gioco durante una partita" + UColor.RESET);
  }

  /**
   * <h3> notInGame </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che non si può vedere il tempo di gioco.
   * </p>
   */
  public static void notInGame() {
    System.out.println(UColor.RED + "Non puoi visualizzare il tempo rimanente se non sei in partita" + UColor.RESET);
  }

  /**
   * <h3> infiniteTime </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che il tempo di gioco è illimitato.
   * </p>
   */
  public static void infiniteTime() {
    System.out.println(UColor.CYAN + "Il tempo è illimitato" + UColor.RESET);
  }

  /**
   * <h3> showTime </h3>
   * <p>
   * Stampa il tempo di gioco trascorso e quello rimanente.
   * </p>
   *
   * @param startTime Tempo d'inizio della partita.
   */
  public static void showTime(final long startTime) {
    long elapsedTime = (System.currentTimeMillis() - startTime) / UTime.ONE_MINUTE;
    System.out.println(UColor.CYAN + "Il tempo trascorso è di " + elapsedTime + " minuti");
    System.out.println("Il tempo rimanente è di " + (GameManager.getMatchTime() - elapsedTime) + " minuti"
        + UColor.RESET);
  }
}
