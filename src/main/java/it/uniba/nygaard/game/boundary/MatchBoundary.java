package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

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
     * <h3> noDifficulty </h3>
     * <p>
     *     Stampa il messaggio di errore relativo al tentativo di
     *     iniziare una partita senza aver impostato il livello di difficoltà.
     * </p>
     */
    public static void noDifficulty() {
        System.out.println(Util.RED + "Non puoi iniziare una partita senza impostare il livello di difficoltà"
                + Util.RESET);
    }

    /**
     * <h3> alreadyInGame </h3>
     * <p>
     *    Stampa il messaggio di errore relativo al tentativo di
     *    iniziare una partita senza aver prima abbandonato la partita corrente.
     * </p>
     */
    public static void alreadyInGame() {
        System.out.println(Util.RED + "Partita in corso\nPer cominciare una nuova partita abbandona la corrente"
                + Util.RESET);
    }
}
