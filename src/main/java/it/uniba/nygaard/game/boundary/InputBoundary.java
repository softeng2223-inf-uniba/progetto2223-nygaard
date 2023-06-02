package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * << Boundary >>
 * <h2> InputBoundary </h2>
 * <p>
 * La classe InputBoundary rappresenta la classe che si occupa di gestire
 * l'input da tastiera.
 * </p>
 */
public final class InputBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe InputBoundary.
   * </p>
   */
  private InputBoundary() {
  }

  /**
   * <h3> getCommand </h3>
   * <p>
   * Metodo che chiede all'utente di inserire un comando.
   * Il comando inserito viene convertito in minuscolo e restituito.
   * </p>
   *
   * @return Stringa che rappresenta il comando inserito dall'utente.
   */
  public static String getCommand() {
    System.out.print("Inserire un comando: " + Util.CYAN);
    return new Scanner(System.in, StandardCharsets.UTF_8).nextLine().toLowerCase();
  }

  /**
   * <h3> notRecognisedCommand </h3>
   * <p>
   * Metodo che stampa a video il messaggio di comando non riconosciuto.
   * </p>
   *
   * @param command Vettore di stringhe che rappresenta il comando non riconosciuto.
   */
  public static void notRecognisedCommand(final String[] command) {
    String commandString = "";
    commandString = String.join(" ", command);
    System.out.println(Util.RED + "Comando non riconosciuto: " + commandString + Util.RESET);
  }

  /**
   * <h3> reset </h3>
   * <p>
   * Metodo che resetta il colore del testo a quello di default.
   * </p>
   */
  public static void resetColor() {
    System.out.print(Util.RESET);
  }

  /**
   * <h3> howToUse </h3>
   * <p>
   * Metodo che stampa a video il messaggio di come usare un comando.
   * </p>
   *
   * @param command Stringa che rappresenta il comando.
   */
  public static void howToUse(final String command) {
    System.out.println(Util.CYAN + "Il comando dovrebbe essere usato come segue: " + command + Util.RESET);
  }

  /**
   * <h3> howToUse </h3>
   * <p>
   * Metodo che stampa a video il messaggio di come usare un comando.
   * </p>
   *
   * @param command Stringa che rappresenta il comando.
   */
  public static void howToUse(final String command, final String command2) {
    System.out.println(Util.CYAN + "Il comando dovrebbe essere usato come segue: " + command + command2
        + Util.RESET);
  }
}
