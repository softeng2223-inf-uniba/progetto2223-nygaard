package it.uniba.nygaard.game.boundary;

import it.uniba.nygaard.game.utility.UColor;

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
   *
   * @return Stringa contenente i comandi principali del gioco.
   */
  private static String mainCommands() {
    return UColor.YELLOW
        + UColor.BOLD + "> COMANDI\n" + UColor.RESET
        + UColor.ITALIC + UColor.CYAN + "    * /help                " + UColor.RESET
        + "Vengono visualizzate le regole " + "di gioco e i comandi disponibili\n"
        + UColor.ITALIC + UColor.CYAN + "    * /esci                " + UColor.RESET
        + "Ti permette di uscire dal gioco\n"
        + UColor.ITALIC + UColor.CYAN + "    * /facile              " + UColor.RESET
        + "Imposta la difficoltà della partita a \"Facile\"\n"
        + UColor.ITALIC + UColor.CYAN + "    * /medio               " + UColor.RESET
        + "Imposta la difficoltà della partita a \"Medio\"\n"
        + UColor.ITALIC + UColor.CYAN + "    * /difficile           " + UColor.RESET
        + "Imposta la difficoltà della partita a \"Difficile\"\n"
        + UColor.ITALIC + UColor.CYAN + "    * /tentativi numero    " + UColor.RESET
        + "Imposta un numero massimo di tentativi fallibili, pari a \n"
        + UColor.ITALIC + "                           numero" + UColor.RESET + ", per tutti i"
        + " livelli di difficoltà\n"
        + UColor.ITALIC + UColor.CYAN + "    * /mostralivello       " + UColor.RESET
        + "Mostra il livello della partita\n"
        + UColor.ITALIC + UColor.CYAN + "    * /mostratentativi     " + UColor.RESET
        + "In base allo stato del gioco, il comando si comporta nei seguenti modi: \n"
        + "                             - Se sei in partita mostra il numero di tentativi effettuati, il numero\n"
        + "                               di tentativi falliti e il numero massimo di tentativi fallibili\n"
        + "                             - Se non sei in partita mostra il numero massimo di tentativi "
        + "fallibili\n"
        + UColor.ITALIC + UColor.CYAN + "    * /mostragriglia       " + UColor.RESET
        + "Mostra la griglia contenente le navi affondate e le parti di \n"
        + "                           navi colpite ma non affondate\n"
        + UColor.ITALIC + UColor.CYAN + "    * /mostranavi          " + UColor.RESET
        + "Mostra le navi ancora in gioco e il loro numero\n"
        + UColor.ITALIC + UColor.CYAN + "    * /gioca               " + UColor.RESET
        + "Ti fa iniziare una partita\n"
        + UColor.ITALIC + UColor.CYAN + "    * /svelagriglia        " + UColor.RESET
        + "Mostra la griglia generata dal computer\n"
        + UColor.ITALIC + UColor.CYAN + "    * /abbandona           " + UColor.RESET
        + "Ti fa abbandonare una partita già in corso e, una volta \n"
        + "                           confermato, ti mostra le posizioni generate di tutte le navi\n\n";
  }

  /**
   * <h3> subCommandsDifficulty </h3>
   * <p>
   * Restituisce una stringa contenente tutte le informazioni sui comandi
   * di personalizzazione delle difficolta'.
   * </p>
   *
   * @return Stringa contenente i comandi di personalizzazione
   * delle difficolta'.
   */
  private static String subCommandsDifficulty() {
    return UColor.YELLOW
        + UColor.BOLD + "> DIFFICOLTA' PERSONALIZZATE\n" + UColor.RESET
        + UColor.ITALIC + UColor.CYAN + "    * /facile numero       " + UColor.RESET
        + "Imposta il numero massimo di tentativi falliti, per la \n"
        + "                           difficolta' \"Facile\", ad un valore pari a"
        + UColor.ITALIC + " numero \n" + UColor.RESET
        + UColor.ITALIC + UColor.CYAN + "    * /medio numero        " + UColor.RESET
        + "Imposta il numero massimo di tentativi falliti, per la \n"
        + "                           difficolta' \"Medio\", ad un valore pari a"
        + UColor.ITALIC + " numero \n" + UColor.RESET
        + UColor.ITALIC + UColor.CYAN + "    * /difficile numero    " + UColor.RESET
        + "Imposta il numero massimo di tentativi falliti, per la \n"
        + "                           difficolta' \"Difficile\", ad un valore pari a"
        + UColor.ITALIC + " numero \n" + UColor.RESET;
  }

  /**
   * <h3> subCommandsGrid </h3>
   * <p>
   * Restituisce una stringa contenente tutte le informazioni sui comandi
   * di personalizzazione della griglia di gioco.
   * </p>
   *
   * @return Stringa contenente i comandi di personalizzazione
   * della griglia di gioco'.
   */
  private static String subCommandsGrid() {
    return UColor.YELLOW
        + UColor.BOLD + "> GRIGLIA PERSONALIZZATA\n" + UColor.RESET
        + UColor.ITALIC + UColor.CYAN + "    * /standard            " + UColor.RESET
        + "Imposta una griglia 10x10 \n"
        + UColor.ITALIC + UColor.CYAN + "    * /large               " + UColor.RESET
        + "Imposta una griglia 18x18 \n"
        + UColor.ITALIC + UColor.CYAN + "    * /extralarge          " + UColor.RESET
        + "Imposta una griglia 26x26 \n\n";
  }

  /**
   * <h3> subCommandsTime </h3>
   * <p>
   * Restituisce una stringa contenente tutte le informazioni sui comandi
   * di visualizzazione del tempo di gioco.
   * </p>
   *
   * @return Stringa contenente i comandi di visualizzazione
   * del tempo di gioco.
   */
  private static String subCommandsTime() {
    return UColor.YELLOW
        + UColor.BOLD + "> TEMPO DI GIOCO\n" + UColor.RESET
        + UColor.ITALIC + UColor.CYAN + "    * /tempo numero        " + UColor.RESET
        + "Imposta il tempo di gioco di \n"
        + "                           una partita, ad un valore pari a "
        + UColor.ITALIC + "numero \n" + UColor.RESET
        + UColor.ITALIC + UColor.CYAN + "    * /mostratempo         " + UColor.RESET
        + "Mostra i minuti di gioco trascorsi e i minuti rimanenti";
  }
}
