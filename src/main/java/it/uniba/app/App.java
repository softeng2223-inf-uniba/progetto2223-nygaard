package it.uniba.app;


import it.uniba.nygaard.game.control.GeneralControl;

/**
 * <h2> App </h2>
 * <p>
 * La classe App si occupa della gestione dei comandi da tastiera,
 * vede se ci sono flags in ingresso all'avvio dell'applicazione
 * e in tal caso esegue le funzioni associate.
 * </p>
 */
final class App {

  App() {
  }

  /**
   * Get a greeting sentence.
   *
   * @return the "Hello World!" string.
   */
  String getGreeting() {
    return "Hello World!!!";
  }

  /**
   * <h3> Main </h3>
   * <p>
   * Punto d'ingresso dell'applicazione.
   * </p>
   *
   * @param args Parametri d'ingresso da linea di comando
   */
  public static void main(final String[] args) {
    GeneralControl.startGame(args);
  }
}
