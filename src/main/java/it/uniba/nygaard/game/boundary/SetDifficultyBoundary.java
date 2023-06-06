package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.utility.UColor;
import it.uniba.nygaard.game.control.GameManager;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * << Boundary >>
 * <h2> SetDifficultyBoundary </h2>
 * <p>
 * La classe SetDifficultyBoundary stampa i messaggi
 * relativi al cambio di difficoltà.
 * </p>
 */
public final class SetDifficultyBoundary {

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe SetDifficultyBoundary.
   * </p>
   */
  private SetDifficultyBoundary() {
  }

  /**
   * <h3> alreadyInGame </h3>
   * <p>
   * Stampa il messaggio di errore relativo al cambio
   * di difficoltà durante una partita.
   * </p>
   *
   * @param diff True se si vuole cambiare la difficoltà mentre si è in partita,
   *             false se si vuole cambiare il numero di tentativi mentre si è in partita.
   */
  public static void alreadyInGame(final boolean diff) {
    if (diff) {
      System.out.println(UColor.RED + "Non puoi cambiare difficoltà durante una partita" + UColor.RESET);
    } else {
      System.out.println(UColor.RED + "Non puoi cambiare il numero di tentativi durante una partita" + UColor.RESET);
    }
  }

  /**
   * <h3> sameDifficulty </h3>
   * <p>
   * Stampa il messaggio relativo al fatto che la difficoltà scelta
   * è già quella attuale.
   * </p>
   */
  public static void sameDifficulty() {
    System.out.println(UColor.RED + "Hai già impostato questa difficoltà" + UColor.RESET);
  }

  /**
   * <h3> sameAttempts</h3>
   * <p>
   * Stampa il messaggio relativo al fatto che il numero di tentativi
   * che si vuole inserire per una certa difficoltà è già quello impostato.
   * </p>
   */
  public static void sameAttempts() {
    System.out.println(UColor.RED + "Questo numero di tentativi è uguale a quello già impostato" + UColor.RESET);
  }

  /**
   * <h3> ask </h3>
   * <p>
   * Stampa il messaggio relativo alla conferma del cambio di difficoltà.
   * </p>
   *
   * @param newDifficulty Nuova difficoltà
   * @return Risposta dell'utente
   */
  public static String ask(final int newDifficulty) {
    System.out.print("Il livello attuale è " + UColor.BOLD
        + GameManager.actualDifficultyName() + UColor.RESET + ". Confermare cambio in "
        + UColor.BOLD + GameManager.newDifficultyName(newDifficulty) + UColor.RESET
        + "? (" + UColor.GREEN + "y" + UColor.RESET
        + "/" + UColor.RED + "n" + UColor.RESET + ") ");
    return new Scanner(System.in, StandardCharsets.UTF_8).next().toLowerCase();
  }

  /**
   * <h3> operationCancelled </h3>
   * <p>
   * Stampa il messaggio relativo all'annullamento del cambio di difficoltà.
   * </p>
   */
  public static void operationCancelled() {
    System.out.println(UColor.RED + "Cambio difficoltà annullato" + UColor.RESET);
  }

  /**
   * <h3> operationDone </h3>
   * <p>
   * Stampa il messaggio relativo al cambio di difficoltà avvenuto con successo.
   * </p>
   */
  public static void operationDone() {
    System.out.println(UColor.GREEN + "OK" + UColor.RESET);
  }

  /**
   * <h3> notValideChoice </h3>
   * <p>
   * Stampa il messaggio relativo alla scelta non valida.
   * </p>
   */
  public static void notValidChoice() {
    System.out.println(UColor.RED + "Scelta non valida" + UColor.RESET);
  }
}
