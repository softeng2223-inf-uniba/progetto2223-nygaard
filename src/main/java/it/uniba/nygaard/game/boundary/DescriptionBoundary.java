package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.utility.UColor;

/**
 * << Boundary >>
 * <h2> DescriptionBoundary </h2>
 * <p>
 * La classe DescriptionBoundary rappresenta la boundary per la descrizione del gioco.
 * </p>
 */
public final class DescriptionBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe DescriptionBoundary.
   * </p>
   */
  private DescriptionBoundary() {
  }

  /**
   * <h3> getDescription </h3>
   * <p>
   * Metodo che stampa la descrizione del gioco.
   * </p>
   */
  public static void getDescription() {
    String description = UColor.BOLD + UColor.PURPLE
        + "Benvenuti nel gioco della battaglia navale!\n"
        + UColor.RESET
        + "Prima di iniziare vi andiamo a presentare una breve introduzione al gioco con\n"
        + "i suoi relativi comandi.\n\n"
        + UColor.YELLOW + UColor.BOLD + "> INTRODUZIONE\n" + UColor.RESET
        + "    In questa realizzazione della battaglia navale, giocherete voi contro il vostro\n"
        + "    computer che posizionerà le navi in automatico prima dell'inizio della partita.\n\n"
        + "    Come giocatore, dovete individuare le posizioni delle navi e affondarle\n"
        + "    tutte, dalla prima all'ultima.\n\n"
        + "    Vincerete la partita solamente se affonderete tutte le navi prima di raggiungere\n"
        + "    il numero massimo di tentativi falliti, che cambia in base alla difficoltà scelta.\n";
    System.out.println(description);
  }
}
