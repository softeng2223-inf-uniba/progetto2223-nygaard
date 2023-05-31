package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.entity.Match;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import it.uniba.nygaard.game.control.GameManager;

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
     */
    public static void alreadyInGame() {
        System.out.println(Util.RED + "Non puoi cambiare difficoltà durante una partita" + Util.RESET);
    }
    /**
     * <h3> sameDifficulty </h3>
     * <p>
     *     Stampa il messaggio relativo al fatto che la difficoltà scelta
     *     è già quella attuale.
     * </p>
     */
    public static void sameDifficulty() {
        System.out.println(Util.RED + "Hai già impostato questa difficoltà" + Util.RESET);
    }
    /**
     * <h3> ask </h3>
     * <p>
     *     Stampa il messaggio relativo alla conferma del cambio di difficoltà.
     * </p>
     * @param p Partita
     * @param newDifficulty Nuova difficoltà
     * @return Risposta dell'utente
     */
    public static String ask(final Match p, final int newDifficulty) {
        System.out.print("Il livello attuale è " + Util.BOLD
                + GameManager.actualDifficultyName() + Util.RESET + ". Confermare cambio in "
                + Util.BOLD + GameManager.newDifficultyName(newDifficulty) + Util.RESET
                + "? (" + Util.GREEN + "y" + Util.RESET
                + "/" + Util.RED + "n" + Util.RESET + ") ");
        return new Scanner(System.in, StandardCharsets.UTF_8).next().toLowerCase();
    }
    /**
     * <h3> operationCancelled </h3>
     * <p>
     *     Stampa il messaggio relativo all'annullamento del cambio di difficoltà.
     * </p>
     */
    public static void operationCancelled() {
        System.out.println(Util.RED + "Cambio difficoltà annullato" + Util.RESET);
    }
    /**
     * <h3> operationDone </h3>
     * <p>
     *     Stampa il messaggio relativo al cambio di difficoltà avvenuto con successo.
     * </p>
     */
    public static void operationDone() {
        System.out.println(Util.GREEN + "OK" + Util.RESET);
    }
    /**
     * <h3> notValideChoice </h3>
     * <p>
     *     Stampa il messaggio relativo alla scelta non valida.
     * </p>
     */
    public static void notValidChoice() {
        System.out.println(Util.RED + "Scelta non valida" + Util.RESET);
    }
}
