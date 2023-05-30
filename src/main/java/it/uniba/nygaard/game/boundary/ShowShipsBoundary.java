package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

/**
 * <<Boundary>>
 *<h2> ShowShipsBoundary </h2>
 *<p>
 *La classe ShowShipsBoundary stampa le navi disponibili.
 *</p>
 */
public final class ShowShipsBoundary {
    /**
     * <h3> Costruttore </h3>
     * <p>
     * Costruttore della classe ShowShipBoundary.
     * </p>
     */
    private ShowShipsBoundary() {
    }
    /**
     * <h3> showShips </h3>
     * <p>
     * Stampa le navi disponibili.
     * </p>
     */
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
