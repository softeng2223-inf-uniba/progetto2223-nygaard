package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.entity.Match;

public class SetDifficultyBoundary {
    private SetDifficultyBoundary() {
    }
    public static void alreadyInGame() {
        System.out.println(Util.RED + "Non puoi cambiare difficoltà durante una partita" + Util.RESET);
    }

    public static void sameDifficulty()
    {
        System.out.println(Util.RED + "Hai già impostato questa difficoltà" + Util.RESET);
    }
    public static String ask(Match p, int newDifficulty)
    {
        System.out.println("Il livello attuale è " + Util.BOLD
                + p.getDifficultyNames()[p.getDifficulty()] + Util.RESET + ". Confermare cambio in "
                + Util.BOLD + p.getDifficultyNames()[newDifficulty] + Util.RESET
                + "? (" + Util.GREEN + "y" + Util.RESET
                + "/" + Util.RED + "n" + Util.RESET + ") ");
        return new Scanner(System.in, StandardCharsets.UTF_8).next().toLowerCase();
    }
}
