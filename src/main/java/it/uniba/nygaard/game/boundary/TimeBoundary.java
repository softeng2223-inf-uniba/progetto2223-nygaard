package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;
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
   * <h3> errorTime </h3>
   * <p>
   * Stampa a video il messaggio di errore relativo a un tempo di gioco non valido.
   * </p>
   */
  public static void errorTime() {
    System.out.println(Util.RED + "Errore: il tempo inserito non è valido.\nInserire un intero positivo"
        + " rappresentante i minuti di gioco" + Util.RESET);
  }

  /**
   * <h3> operationDone </h3>
   * <p>
   * Stampa il messaggio relativo all'aver impostato il tempo di gioco.
   * </p>
   */
  public static void operationDone() {
    System.out.println(Util.GREEN + "OK" + Util.RESET);
  }

  /**
   * <h3> notInGame </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che non si può cambiare il tempo di gioco
   * se si è in partita.
   * </p>
   */
  public static void notInGame() {
    System.out.println(Util.RED + "Non puoi cambiare il tempo di gioco se sei in partita" + Util.RESET);
  }

  /**
   * <h3> mustBeInGame </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che non si può vedere il tempo di gioco.
   * </p>
   */
  public static void mustBeInGame() {
    System.out.println(Util.RED + "Devi essere in partita per vedere il tempo" + Util.RESET);
  }

  /**
   * <h3> infiniteTime </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che il tempo di gioco è illimitato.
   * </p>
   */
  public static void infiniteTime() {
    System.out.println(Util.CYAN + "Il tempo è illimitato" + Util.RESET);
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
    long elapsedTime = (System.currentTimeMillis() - startTime) / Util.ONE_MINUTE;
    System.out.println(Util.CYAN + "Il tempo trascorso è di " + elapsedTime + " minuti");
    System.out.println("Il tempo rimanente è di " + (GameManager.getMatchTime() - elapsedTime) + " minuti"
        + Util.RESET);
  }
}
