package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ParamsBoundary {
    private ParamsBoundary(){
    }

    public static void tooManyArgs()
    {
        System.out.println(Util.RED + "Troppi parametri inseriti.\nPremere invio per uscire" + Util.RESET);
        new Scanner(System.in, StandardCharsets.UTF_8).nextLine();
    }

    public static void notRecogniseArg(String argument)
    {
        System.out.println(Util.RED + "Parametro " + argument + " non riconosciuto.\nPremere invio per uscire"
                + Util.RESET);
        new Scanner(System.in, StandardCharsets.UTF_8).nextLine();
    }
}
