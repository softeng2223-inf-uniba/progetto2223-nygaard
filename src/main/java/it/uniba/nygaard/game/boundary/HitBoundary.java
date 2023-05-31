package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

public class HitBoundary {

    private HitBoundary(){
    }

    public static void notInGame(){
        System.out.println(Util.RED + "Non puoi eseguire colpi se non sei in una partita!" + Util.RESET);
    }

    public static void invalidCoordinates(){
        System.out.println(Util.RED + "Coordinate non valide" + Util.RESET);
    }

    public static void miss(){
        System.out.println(Util.CYAN + "Acqua!" + Util.RESET);
    }

    public static void hit(){
        System.out.println(Util.YELLOW + "Colpito!" + Util.RESET);
    }

    public static void sunk(){
        System.out.println(Util.RED + "Colpito e affondato!" + Util.RESET);
    }

}
