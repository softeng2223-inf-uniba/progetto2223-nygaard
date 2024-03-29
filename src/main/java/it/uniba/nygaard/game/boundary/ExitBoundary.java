package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.utility.UColor;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * << Boundary >>
 * <h2> ExitBoundary </h2>
 * <p>
 * La classe ExitBoundary rappresenta la classe che si occupa di gestire
 * l'uscita dal gioco.
 * </p>
 */
public final class ExitBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ExitBoundary.
   * </p>
   */
  private ExitBoundary() {
  }

  /**
   * <h3> exitString </h3>
   * <p>
   * Metodo che stampa a video il messaggio di uscita dal gioco.
   * </p>
   */
  public static void exitString() {
    System.out.println(UColor.YELLOW + UColor.BOLD + "GRAZIE PER AVER GIOCATO!" + UColor.RESET);
  }

  /**
   * <h3> ask </h3>
   * <p>
   * Metodo che chiede all'utente se vuole veramente uscire dal gioco.
   * </p>
   *
   * @return Stringa che rappresenta la risposta dell'utente.
   */
  public static String ask() {
    Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
    String command;
    System.out.print("Vuoi veramente uscire dal gioco? "
        + "(" + UColor.GREEN + "y" + UColor.RESET
        + "/" + UColor.RED + "n" + UColor.RESET + ") ");
    command = in.nextLine().toLowerCase();
    return command;
  }

  /**
   * <h3> operationCancelled </h3>
   * <p>
   * Metodo che stampa a video il messaggio di annullamento dell'operazione.
   * </p>
   */
  public static void operationCancelled() {
    System.out.println(UColor.RED + "Uscita dall'applicazione annullata" + UColor.RESET);
  }

  /**
   * <h3> invalidChoice </h3>
   * <p>
   * Metodo che stampa a video il messaggio di scelta non valida.
   * </p>
   */
  public static void invalidChoice() {
    System.out.println(UColor.RED + "Scelta non valida" + UColor.RESET);
  }

}
