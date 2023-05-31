package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

public class HitBoundary {

    private HitBoundary(){
    }

    public static void notInGame(){
        System.out.println(Util.RED + "Non puoi eseguire colpi se non sei in una partita!" + Util.RESET);
    }

}
