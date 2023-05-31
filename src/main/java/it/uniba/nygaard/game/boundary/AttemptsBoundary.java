package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

/**
 * << Boundary >>
 * <h2> AttemptsBoundary </h2>
 * <p>
 * La classe AttemptsBoundary stampa i messaggi relativi al numero di tentativi.
 * </p>
 */
public final class AttemptsBoundary {
    /**
     * <h3> Costruttore </h3>
     * <p>
     * Costruttore della classe AttemptsBoundary.
     * </p>
     */
    private AttemptsBoundary() {
    }

    /**
     * <h3> notValidChoice </h3>
     * <p>
     * Stampa il messaggio relativo alla scelta non valida.
     * </p>
     */
    public static void notValidChoice() {
        System.out.println(Util.RED + "Numero di tentativi non valido" + Util.RESET);
    }

    /**
     * <h3> operationDone </h3>
     * <p>
     * Stampa il messaggio relativo al cambio di difficoltà avvenuto con successo.
     * </p>
     */
    public static void operationDone() {
        System.out.println(Util.GREEN + "OK" + Util.RESET);
    }

    /**
     * <h3> alreadyInGame </h3>
     * <p>
     * Stampa il messaggio di errore relativo al tentativo di
     * cambiare il numero di tentativi durante una partita.
     * </p>
     */
    public static void alreadyInGame() {
        System.out.println(Util.RED + "Non puoi cambiare il numero di tentativi durante una partita" + Util.RESET);
    }
}
