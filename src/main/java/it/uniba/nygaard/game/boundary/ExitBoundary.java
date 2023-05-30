package it.uniba.nygaard.game.boundary;
import it.uniba.nygaard.game.Util

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ExitBoundary {

    private ExitBoundary(){
    }

    public static void exitString()
    {
        System.out.println(Util.YELLOW + Util.BOLD +  "GRAZIE PER AVER GIOCATO!" + Util.RESET);
    }

    public static String ask()
    {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        String command;
        System.out.print("Vuoi veramente uscire? "
                + "(" + Util.GREEN + "y" + Util.RESET
                + "/" + Util.RED + "n" + Util.RESET + ") ");
        command = in.nextLine().toLowerCase();
        return command;
    }

}
