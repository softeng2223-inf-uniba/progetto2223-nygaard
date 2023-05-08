package it.uniba.nygaard.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>
 * La classe Util contiene tutte le costanti globali
 * e funzioni di servizio.
 * </p>
 */
public final class Util {

    private Util() { }

    /**
     * <p>
     * Mostra una descrizione del programma insieme a tutti
     * i comandi disponibili che si possono eseguire.
     * </p>
     */
    public static void printHelp() {
        Path filePath = Paths.get("src/main/java/it/uniba/nygaard/game/help/help.txt");

        try {
            String result = Files.readString(filePath);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
