package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

public class ShowGridBoundary {
    private ShowGridBoundary() {
    }
    public static void notInGame()
    {
        System.out.println(Util.RED + "Non sei in partita" + Util.RESET);
    }
}
