package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

public class ShowShipBoundary {
    private ShowShipBoundary() {
    }

    public static void showShips() {
        System.out.println(Util.CYAN + Util.ITALIC + "\tCacciatorpediniere \t" + Util.RESET + "■■ \t"
                + Util.CYAN + Util.BOLD + "Esemplari: " + Util.DESTROYER_NO + Util.RESET);
        System.out.println(Util.CYAN + Util.ITALIC + "\tIncrociatore \t\t" + Util.RESET + "■■■ \t"
                + Util.CYAN + Util.BOLD + "Esemplari: " + Util.CRUISER_NO + Util.RESET);
        System.out.println(Util.CYAN + Util.ITALIC + "\tCorazzata \t\t" + Util.RESET + "■■■■ \t"
                + Util.CYAN + Util.BOLD + "Esemplari: " + Util.BATTLESHIP_NO + Util.RESET);
        System.out.println(Util.CYAN + Util.ITALIC + "\tPortaerei \t\t" + Util.RESET + "■■■■■ \t"
                + Util.CYAN + Util.BOLD + "Esemplari: " + Util.AIRCRAFT_NO + Util.RESET);
    }
}
