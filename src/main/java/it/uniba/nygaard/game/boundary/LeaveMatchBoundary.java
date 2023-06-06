package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.utility.UColor;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * << Boundary >>
 * <h2> LeaveMatchBoundary </h2>
 * <p>
 * Classe che implementa i messaggi per la gestione dell'abbandono della partita.
 * </p>
 */
public final class LeaveMatchBoundary {
    /**
     * <h2> Costruttore </h2>
     * <p>
     * Costruttore della classe LeaveMatchBoundary.
     * </p>
     */
    private LeaveMatchBoundary() {
    }
    /**
     * <h2> notInGame </h2>
     * <p>
     * Messaggio di errore per quando si tenta di abbandonare una partita non iniziata.
     * </p>
     */
    public static void notInGame() {
        System.out.println(UColor.RED + "Non puoi usare il comando quando non sei in partita"
            + UColor.RESET);
    }
    /**
     * <h2> invalidChoice </h2>
     * <p>
     * Messaggio di errore per quando si inserisce una scelta non valida.
     * </p>
     */
    public static void invalidChoice() {
        System.out.println(UColor.RED + "Scelta non valida" + UColor.RESET);
    }

    /**
     * <h2> ask </h2>
     * <p>
     * Messaggio per chiedere conferma di abbandono delle partita.
     * </p>
     *
     * @return Scelta dell'utente
     */
    public static String ask() {
        System.out.print("Vuoi abbandonare la partita? "
            + "(" + UColor.GREEN + "y" + UColor.RESET
            + "/" + UColor.RED + "n" + UColor.RESET + ") ");
        return new Scanner(System.in, StandardCharsets.UTF_8).nextLine().toLowerCase();
    }

    /**
     * <h2> operationCancelled </h2>
     * <p>
     * Messaggio di annullamento di abbandono della partita.
     * </p>
     */
    public static void operationCancelled() {
        System.out.println(UColor.RED + "Operazione annullata" + UColor.RESET);
    }

    /**
     * <h3> leave </h3>
     * <p>
     * Stampa il messaggio relativo al fatto che
     * il giocatore ha abbandonato la partita.
     * </p>
     */
    public static void leave() {
        System.out.println(UColor.RED + UColor.BOLD + "Hai perso! Hai abbandonato la partita!" + UColor.RESET);
    }

}
