package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * << Boundary >>
 * <h2> ParamsBoundary </h2>
 * <p>
 * La classe ParamsBoundary stampa i messaggi di errore
 * relativi ai parametri passati in ingresso all'avvio
 * del gioco.
 * </p>
 */
public final class ParamsBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ParamsBoundary.
   * </p>
   */
  private ParamsBoundary() {
  }

  /**
   * <h3> tooManyArgs </h3>
   * <p>
   * Stampa il messaggio di errore relativo al numero
   * di parametri passati in ingresso all'avvio del gioco.
   * </p>
   */
  public static void tooManyArgs() {
    System.out.println(Util.RED + "Troppi parametri inseriti.\nPremere invio per uscire" + Util.RESET);
    new Scanner(System.in, StandardCharsets.UTF_8).nextLine();
  }

  /**
   * <h3> notRecogniseArg </h3>
   * <p>
   * Stampa il messaggio di errore relativo al parametro non valido
   * passato in ingresso all'avvio del gioco.
   * </p>
   *
   * @param argument Parametro non riconosciuto
   */
  public static void notRecognisedArg(final String argument) {
    System.out.println(Util.RED + "Parametro " + argument + " non riconosciuto.\nPremere invio per uscire"
        + Util.RESET);
    new Scanner(System.in, StandardCharsets.UTF_8).nextLine();
  }
}
