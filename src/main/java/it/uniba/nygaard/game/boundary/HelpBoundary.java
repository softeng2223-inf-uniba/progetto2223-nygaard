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

  /**
   * <h2> Costruttore </h2>
   * <p>
   * Costruttore per la classe HelpBoundary.
   * </p>
   */
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
    String help = mainCommands()
        + subCommandsDifficulty()
        + subCommandsGrid()
        + subCommandsTime();

        System.out.println(help);
    }
    /**
     * <h3> mainCommands </h3>
     * <p>
     * Restituisce una stringa contenente tutte le informazioni sui
     * comandi principali del gioco.
     * </p>
     * @return Stringa contenente i comandi principali del gioco.
     */
    private static String mainCommands() {
        String mainCommands = Util.YELLOW
            + Util.BOLD + "> COMANDI\n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /help                " + Util.RESET
            + "Vengono visualizzate le regole " + "di gioco e i comandi disponibili\n"
            + Util.ITALIC + Util.CYAN + "    * /esci                " + Util.RESET
            + "Ti permette di uscire dal gioco\n"
            + Util.ITALIC + Util.CYAN + "    * /facile              " + Util.RESET
            + "Imposta la difficolta' della partita a \"Facile\"\n"
            + Util.ITALIC + Util.CYAN + "    * /medio               " + Util.RESET
            + "Imposta la difficolta' della partita a \"Medio\"\n"
            + Util.ITALIC + Util.CYAN + "    * /difficile           " + Util.RESET
            + "Imposta la difficolta' della partita a \"Difficile\"\n"
            + Util.ITALIC + Util.CYAN + "    * /tentativi numero    " + Util.RESET
            + "Imposta un numero massimo di tentativi fallibili, pari a \n"
            + Util.ITALIC + "                           numero" + Util.RESET + ", per tutti i"
            +  " livelli di difficolta'\n"
            + Util.ITALIC + Util.CYAN + "    * /mostralivello       " + Util.RESET
            + "Mostra il livello della partita\n"
            + Util.ITALIC + Util.CYAN + "    * /mostratentativi     " + Util.RESET
            + "In base allo stato del gioco, il comando si comporta nei seguenti modi: \n"
            + "                             - Se sei in partita mostra il numero di tentativi effettuati, il numero\n"
            + "                               di tentativi falliti e il numero massimo\n"
            + "                             - Se non sei in partita mostra il numero massimo di tentativi "
            + "falliti effettuati\n"
            + Util.ITALIC + Util.CYAN + "    * /mostragriglia       " + Util.RESET
            + "Mostra la griglia contenente le navi affondate e le parti di \n"
            + "                           navi colpite ma non affondate\n"
            + Util.ITALIC + Util.CYAN + "    * /mostranavi          " + Util.RESET
            + "Mostra le navi ancora in gioco e il loro numero\n"
            + Util.ITALIC + Util.CYAN + "    * /gioca               " + Util.RESET
            + "Ti fa iniziare una partita\n"
            + Util.ITALIC + Util.CYAN + "    * /svelagriglia        " + Util.RESET
            + "Mostra la griglia generata dal computer\n"
            + Util.ITALIC + Util.CYAN + "    * /abbandona           " + Util.RESET
            + "Ti fa abbandonare una parita gia' in corso e, una volta \n"
            + "                           confermato, ti mostra le posizioni generate di tutte le navi\n\n";

        return mainCommands;
    }
    /**
     * <h3> subCommandsDifficulty </h3>
     * <p>
     * Restituisce una stringa contenente tutte le informazioni sui comandi
     * di personalizzazione delle difficolta'.
     * </p>
     * @return Stringa contenente i comandi di personalizzazione
     * delle difficolta'.
     */
    private static String subCommandsDifficulty() {
        String subDifficulty = Util.YELLOW
            + Util.BOLD + "> DIFFICOLTA' PERSONALIZZATE\n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /facile numero       " + Util.RESET
            + "Imposta il numero massimo di tentativi falliti, per la \n"
            + "                           difficolta' \"Facile\", ad un valore pari a"
            + Util.ITALIC + " numero \n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /medio numero        " + Util.RESET
            + "Imposta il numero massimo di tentativi falliti, per la \n"
            + "                           difficolta' \"Medio\", ad un valore pari a"
            + Util.ITALIC + " numero \n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /difficile numero    " + Util.RESET
            + "Imposta il numero massimo di tentativi falliti, per la \n"
            + "                           difficolta' \"Difficile\", ad un valore pari a"
            + Util.ITALIC + " numero \n" + Util.RESET;

        return subDifficulty;
    }
    /**
     * <h3> subCommandsGrid </h3>
     * <p>
     * Restituisce una stringa contenente tutte le informazioni sui comandi
     * di personalizzazione della griglia di gioco.
     * </p>
     * @return Stringa contenente i comandi di personalizzazione
     * della griglia di gioco'.
     */
    private static String subCommandsGrid() {
        String subGrid = Util.YELLOW
            + Util.BOLD + "> GRIGLIA PERSONALIZZATA\n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /standard            " + Util.RESET
            + "Imposta una griglia 10x10 \n"
            + Util.ITALIC + Util.CYAN + "    * /large               " + Util.RESET
            + "Imposta una griglia 18x18 \n"
            + Util.ITALIC + Util.CYAN + "    * /extralarge          " + Util.RESET
            + "Imposta una griglia 26x26 \n\n";

        return subGrid;
    }
    /**
     * <h3> subCommandsTime </h3>
     * <p>
     * Restituisce una stringa contenente tutte le informazioni sui comandi
     * di visualizzazione del tempo di gioco.
     * </p>
     * @return Stringa contenente i comandi di visualizzazione
     * del tempo di gioco.
     */
    private static String subCommandsTime() {
        String subTime = Util.YELLOW
            + Util.BOLD + "> TEMPO DI GIOCO\n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /tempo numero        " + Util.RESET
            + "Imposta il tempo di gioco di \n"
            + "                           una partita, ad un valore pari a "
            + Util.ITALIC + "numero \n" + Util.RESET
            + Util.ITALIC + Util.CYAN + "    * /mostratempo         " + Util.RESET
            + "Mostra i minuti di gioco trascorsi e i minuti rimanenti";

        return subTime;
    }
}
