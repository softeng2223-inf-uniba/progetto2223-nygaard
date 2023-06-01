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

    public static void win(){
        System.out.println(Util.GREEN + Util.BOLD + "Hai vinto la partita!" + Util.RESET);
    }

    public static void outOfAttempts(){
        System.out.println(Util.RED + Util.BOLD + "Hai perso! Hai finito i tentativi disponibili!" + Util.RESET);
    }

    public static void timeOut(){
        System.out.println(Util.RED + Util.BOLD + "Hai perso! Hai esaurito il tempo a tua disposizione!" + Util.RESET);
        System.out.println(Util.CYAN + "Premere invio per continuare!" + Util.RESET);
    }

    public static void playAgain(){
        System.out.println(Util.CYAN + "\nHai terminato la partita precedente, i parametri sono stati resettati." + Util.RESET);
        System.out.println(Util.CYAN + "Puoi inserire qualsiasi comando o iniziare una nuova partita.\n" + Util.RESET);
    }

}
