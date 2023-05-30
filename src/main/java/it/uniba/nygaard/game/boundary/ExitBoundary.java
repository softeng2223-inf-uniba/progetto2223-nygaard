package it.uniba.nygaard.game.boundary;
import it.uniba.nygaard.game.Util

public class ExitBoundary {

    private ExitBoundary(){
    }

    public static void exitString()
    {
        System.out.println(Util.YELLOW + Util.BOLD +  "GRAZIE PER AVER GIOCATO!" + Util.RESET);
    }


}
