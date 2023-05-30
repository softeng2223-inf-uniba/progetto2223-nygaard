package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.Util;

/**
 * << Boundary >>
 * <h2> HelpBoundary </h2>
 * <p>
 * La classe HelpBoundary rappresenta la schermata di aiuto.
 * </p>
 *
 * @see DescriptionBoundary
 */
public final class HelpBoundary {
    private HelpBoundary() {
    }
    /**
     * <h3> getHelp </h3>
     * <p>
     * Metodo che stampa a schermo la schermata di aiuto.
     * </p>
     */
    public static void getHelp() {
        DescriptionBoundary.getDescription();
        String help = mainCommands() + subCommandsDifficulty();
        System.out.println(help);
    }


    private static String mainCommands() {
        String mainCommands = Util.YELLOW
            + Util.BOLD + "> COMANDI\n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /help             " + Util.RESET
            + "Vengono visualizzate le regole " + "di gioco e i comandi disponibili\n"
            + Util.ITALIC + Util.CYAN + "    * /esci             " + Util.RESET
            + "Ti permette di uscire dal gioco\n"
            + Util.ITALIC + Util.CYAN + "    * /facile           " + Util.RESET
            + "Imposta la difficolta' della partita a \"Facile\"\n"
            + Util.ITALIC + Util.CYAN + "    * /medio            " + Util.RESET
            + "Imposta la difficolta' della partita a \"Medio\"\n"
            + Util.ITALIC + Util.CYAN + "    * /difficile        " + Util.RESET
            + "Imposta la difficolta' della partita a \"Difficile\"\n"
            + Util.ITALIC + Util.CYAN + "    * /mostralivello    " + Util.RESET
            + "Mostra il livello della partita\n"
            + Util.ITALIC + Util.CYAN + "    * /mostranavi       " + Util.RESET
            + "Mostra le navi ancora in gioco e il loro numero\n"
            + Util.ITALIC + Util.CYAN + "    * /gioca            " + Util.RESET
            + "Ti fa iniziare una partita\n"
            + Util.ITALIC + Util.CYAN + "    * /svelagriglia     " + Util.RESET
            + "Mostra la griglia generata dal computer\n\n";

        return mainCommands;
    }


    private static String subCommandsDifficulty() {
        String subDifficulty = Util.YELLOW
            + Util.BOLD + "> DIFFICOLTA' PERSONALIZZATE\n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /facile numero       " + Util.RESET
            + "Imposta il numero massimo di tentativi, per la difficolta' \"Facile\", ad un valore pari a"
            + Util.ITALIC + " numero \n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /medio numero        " + Util.RESET
            + "Imposta il numero massimo di tentativi, per la difficolta' \"Medio\", ad un valore pari a"
            + Util.ITALIC + " numero \n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /difficile numero    " + Util.RESET
            + "Imposta il numero massimo di tentativi, per la difficolta' \"Difficile\", ad un valore pari a"
            + Util.ITALIC + " numero \n" + Util.RESET;

        return subDifficulty;
    }
}
