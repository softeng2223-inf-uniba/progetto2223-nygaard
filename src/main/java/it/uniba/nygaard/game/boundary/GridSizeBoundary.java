package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.control.GameManager;
import it.uniba.nygaard.game.entity.Match;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class GridSizeBoundary {
    private GridSizeBoundary() {
    }


    public static void inGameError() {
        System.out.println(Util.RED + "Errore: Non puoi impostare le dimensioni della griglia "
            + "mentre sei in partita" + Util.RESET);
    }

    public static void tooManyArgs() {
        System.out.println(Util.RED + "Errore: il comando non accetta argomenti" + Util.RESET);
    }

    public static void operationDone() {
        System.out.println(Util.GREEN + "OK" + Util.RESET);
    }

    public static void sameSizeError() {
        System.out.println(Util.RED + "Dimensioni gia' impostate" + Util.RESET);
    }

    public static void invalidChoiceError() {
        System.out.println(Util.RED + "Scelta non valida" + Util.RESET);
    }

    public static String ask(final Match p, final int newSize) {
        int cSize = GameManager.currentGridSizeName();

        System.out.print("Le dimensioni attuali sono " + Util.BOLD
            + cSize + "x" + cSize + Util.RESET + ". Confermare cambio in "
            + Util.BOLD + newSize + "x" + newSize + Util.RESET
            + "? (" + Util.GREEN + "y" + Util.RESET
            + "/" + Util.RED + "n" + Util.RESET + ") ");
        return new Scanner(System.in, StandardCharsets.UTF_8).next().toLowerCase();
    }

    public static void operationCancelled() {
        System.out.println(Util.RED + "Cambio dimensioni annullato" + Util.RESET);
    }
}
