package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

public class MatchBoundary {
    private MatchBoundary() {
    }
    public static void noDifficulty()
    {
        System.out.println(Util.RED + "Non puoi iniziare una partita senza impostare il livello di difficoltà" + Util.RESET);
    }
    public static void alreadyInGame()
    {
        System.out.println(Util.RED + "Partita in corso\nPer cominciare una nuova partita abbandona la corrente" + Util.RESET);
    }
}
