package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.entity.grids.Grid;

public class ShowGridBoundary {
    private ShowGridBoundary() {
    }
    public static void notInGame()
    {
        System.out.println(Util.RED + "Non sei in partita" + Util.RESET);
    }
    public static void printGrid(Grid grid)
    {
        System.out.println(grid);
    }
}
