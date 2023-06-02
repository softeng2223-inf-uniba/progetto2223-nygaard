package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;
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
        System.out.println(Util.RED + "Non puoi usare il comando quando non sei in partita"
            + Util.RESET);
    }
    /**
     * <h2> invalidChoice </h2>
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
     * Messaggio per chiedere conferma di abbandono delle partita.
     * </p>
     *
     * @return Scelta dell'utente
     */
    public static String ask() {
        System.out.print("Vuoi abbandonare la partita? "
            + "(" + Util.GREEN + "y" + Util.RESET
            + "/" + Util.RED + "n" + Util.RESET + ") ");
        return new Scanner(System.in, StandardCharsets.UTF_8).nextLine().toLowerCase();
    }

    /**
     * <h2> operationCancelled </h2>
     * <p>
     * Messaggio di annullamento di abbandono della partita.
     * </p>
     */
    public static void operationCancelled() {
        System.out.println(Util.RED + "Operazione annullata" + Util.RESET);
    }

}