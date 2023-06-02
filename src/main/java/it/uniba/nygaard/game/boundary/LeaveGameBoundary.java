package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LeaveGameBoundary {
    /**
     * <h2> Costruttore </h2>
     * <p>
     * Costruttore privato della classe.
     * </p>
     */
    private LeaveGameBoundary() {
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



}
