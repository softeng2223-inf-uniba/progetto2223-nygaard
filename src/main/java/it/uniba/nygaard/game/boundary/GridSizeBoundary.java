package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

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


    public static void notValidChoice() {
        System.out.println(Util.RED + "Scelta non valida" + Util.RESET);
    }
}
