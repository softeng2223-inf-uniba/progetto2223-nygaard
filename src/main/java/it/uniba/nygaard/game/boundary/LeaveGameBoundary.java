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
    public static void notInGame() {
        System.out.println(Util.RED + "Non puoi usare il comando quando non sei in partita"
            + Util.RESET);
    }


}
