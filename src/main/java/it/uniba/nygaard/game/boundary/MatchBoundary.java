package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.utility.UColor;

/**
 * << Boundary >>
 * <h2> MatchBoundary </h2>
 * <p>
 * La classe MatchBoundary stampa messaggi relativi alla partita.
 * </p>
 */
public final class MatchBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe MatchBoundary.
   * </p>
   */
  private MatchBoundary() {
  }

  /**
   * <h3> alreadyInGame </h3>
   * <p>
   * Stampa il messaggio di errore relativo al tentativo di
   * iniziare una partita senza aver prima abbandonato la partita corrente.
   * </p>
   */
  public static void alreadyInGame() {
    System.out.println(UColor.RED + "Partita in corso\nPer cominciare una nuova partita abbandona la corrente"
        + UColor.RESET);
  }

  /**
   * <h3> win </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che
   * il giocatore ha vinto la partita.
   * </p>
   */
  public static void win() {
    System.out.println(UColor.GREEN + UColor.BOLD + "Hai vinto la partita!" + UColor.RESET);
  }

  /**
   * <h3> outOfAttempts </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che
   * il giocatore ha esaurito i tentativi disponibili.
   * </p>
   */
  public static void outOfAttempts() {
    System.out.println(UColor.RED + UColor.BOLD + "Hai perso! Hai finito i tentativi disponibili!" + UColor.RESET);
  }

  /**
   * <h3> timeOut </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che
   * il giocatore ha esaurito il tempo a disposizione.
   * </p>
   */
  public static void timeOut() {
    System.out.println(UColor.RED + UColor.BOLD
        + "\nHai perso! Hai esaurito il tempo a tua disposizione!" + UColor.RESET);
    System.out.print(UColor.CYAN + "Premere invio per continuare..." + UColor.RESET);
  }

  /**
   * <h3> playAgain </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che
   * il giocatore ha terminato la partita precedente.
   * </p>
   */
  public static void playAgain() {
    System.out.println(Util.CYAN + "\nHai terminato la partita precedente, "
        + "i parametri sono stati resettati." + Util.RESET);
    System.out.println(Util.CYAN + "Puoi inserire qualsiasi comando o iniziare una nuova partita.\n" + Util.RESET);
  }

  /**
   * <h3> printSolution </h3>
   * <p>
   * Stampa il messaggio relativo alla disposizione delle navi.
   * </p>
   */
  public static void printSolution() {
    System.out.println(UColor.CYAN + "Questa era la disposizione delle navi!" + UColor.RESET);
  }
}
