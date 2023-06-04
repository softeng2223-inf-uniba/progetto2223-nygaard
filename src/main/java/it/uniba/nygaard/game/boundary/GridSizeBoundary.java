package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.control.GameManager;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * << Boundary >>
 * <h2> GridSizeBoundary </h2>
 * <p>
 * Classe che implementa i messaggi per la gestione delle dimensioni della griglia.
 * </p>
 */
public final class GridSizeBoundary {

  /**
   * <h2> Costruttore </h2>
   * <p>
   * Costruttore privato della classe.
   * </p>
   */
  private GridSizeBoundary() {
  }

  /**
   * <h2> inGameError </h2>
   * <p>
   * Messaggio di errore per quando si tenta di impostare la dimensione della griglia
   * mentre si è in partita.
   * </p>
   */
  public static void alreadyInGame() {
    System.out.println(Util.RED + "Non puoi impostare le dimensioni della griglia"
        + "mentre sei in partita" + Util.RESET);
  }

  /**
   * <h2> operationDone </h2>
   * <p>
   * Messaggio di conferma per quando si è impostata la dimensione della griglia.
   * </p>
   */
  public static void operationDone() {
    System.out.println(Util.GREEN + "OK" + Util.RESET);
  }

  /**
   * <h2> sameSizeError </h2>
   * <p>
   * Messaggio di errore per quando si tenta di impostare la dimensione della griglia
   * con le stesse dimensioni attuali.
   * </p>
   */
  public static void sameSize() {
    System.out.println(Util.RED + "Dimensioni gia' impostate" + Util.RESET);
  }

  /**
   * <h2> invalidChoiceError </h2>
   * <p>
   * Messaggio di errore per quando si inserisce una scelta non valida.
   * </p>
   */
  public static void invalidChoice() {
    System.out.println(Util.RED + "Scelta non valida" + Util.RESET);
  }

  /**
   * <h2> ask </h2>
   * <p>
   * Messaggio per chiedere conferma per il cambio di dimensione della griglia.
   * </p>
   *
   * @param newSize Nuova dimensione della griglia
   * @return Scelta dell'utente
   */
  public static String ask(final int newSize) {
    int cSize = GameManager.currentGridSize();
    System.out.print("Le dimensioni attuali sono " + Util.BOLD
        + cSize + "x" + cSize + Util.RESET + ". Confermare cambio in "
        + Util.BOLD + newSize + "x" + newSize + Util.RESET
        + "? (" + Util.GREEN + "y" + Util.RESET
        + "/" + Util.RED + "n" + Util.RESET + ") ");
    return new Scanner(System.in, StandardCharsets.UTF_8).next().toLowerCase();
  }

  /**
   * <h2> operationCancelled </h2>
   * <p>
   * Messaggio di annullamento del cambio di dimensione della griglia.
   * </p>
   */
  public static void operationCancelled() {
    System.out.println(Util.RED + "Cambio dimensioni della griglia annullato" + Util.RESET);
  }
}
