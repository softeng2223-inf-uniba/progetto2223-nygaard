package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

public class SetDifficultyBoundary {
    private SetDifficultyBoundary() {
    }
    public static void alreadyInGame() {
        System.out.println(Util.RED + "Non puoi cambiare difficoltà durante una partita" + Util.RESET);
    }
}
