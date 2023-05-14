package it.uniba.nygaard.game;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * <h2> Util </h2>
 * <p>
 * La classe Util contiene tutte le costanti globali
 * e funzioni di servizio.
 * </p>
 */
public final class Util {
  public static final int HEADING_EDGE_WIDTH = 19;
  public static final int COLUMNS_EDGE_WIDTH = 13;
  public static final int ROWS_EDGE_WIDTH = 8;
  public static final int MIN_ROWS = 1;
  public static final int MAX_ROWS = 10;
  public static final char MIN_COLUMN = 'A';
  public static final char MAX_COLUMN = 'J';
  public static final int MIN_SHIP = 1;
  public static final int MAX_SHIP = 10;
  public static final int AIRCRAFT_CARRIER_HP = 5;
  public static final int BATTLESHIP_HP = 4;
  public static final int CRUISER_HP = 3;
  public static final int DESTROYER_HP = 2;
  public static final int DIFFICULTY_NOT_SETTED = -1;
  public static final int DIFFICULTY_EASY = 0;
  public static final int DIFFICULTY_MEDIUM = 1;
  public static final int DIFFICULTY_HARD = 2;
  public static final int EASY_ATTEMPTS = 50;
  public static final int MEDIUM_ATTEMPTS = 30;
  public static final int HARD_ATTEMPTS = 10;
  public static final String EASY_NAME = "Facile";
  public static final String MEDIUM_NAME = "Medio";
  public static final String HARD_NAME = "Difficile";
  public static final int AIRCRAFT_NO = 1;
  public static final int BATTLESHIP_NO = 2;
  public static final int CRUISER_NO = 3;
  public static final int DESTROYER_NO = 4;
  public static final int MIN_GENERATIONS = 1;
  public static final int MAX_GENERATIONS = 50;
  public static final int SEA_INDEX = -1;
  public static final char SEA_CHARACTER = '~';
  public static final char SHIP_CHARACTER = '*';
  public static final int FIRST_TWO_DIGITS = 10;
  public static final boolean VERTICAL = true;
  public static final boolean HORIZONTAL = false;

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe Util.
   * </p>
   */
  private Util() {
  }

  /**
   * <h3> printLogo </h3>
   * <p>
   *   Metodo che stampa il logo dell'applicazione.
   * </p>
   */
  public static void printLogo() {
    String logo = "  ____        _   _   _           _     _       \n"
                  + " |  _ \\      | | | | | |         | |   (_)      \n"
                  + " | |_) | __ _| |_| |_| | ___  ___| |__  _ _ __  \n"
                  + " |  _ < / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\ \n"
                  + " | |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |\n"
                  + " |____/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/ \n"
                  + "                                         | |    \n"
                  + "                                         |_|    \n";
    System.out.println(logo);
  }


  /**
   * <h3> printHelp </h3>
   * <p>
   * Mostra una descrizione del programma insieme a tutti
   * i comandi disponibili che si possono eseguire.
   * </p>
   */
  public static void printHelp() {
    Util.printDescription();
    String help =
        "> COMANDI\n"
        + "    * /help             Vengono visualizzate le regole di gioco e i comandi disponibili\n"
        + "    * /esci             Ti permette di uscire dal gioco\n"
        + "    * /facile           Imposta la difficolta' della partita a \"Facile\"\n"
        + "    * /medio            Imposta la difficolta' della partita a \"Medio\"\n"
        + "    * /difficile        Imposta la difficolta' della partita a \"Difficile\"\n"
        + "    * /mostralivello    Mostra il livello della partita\n"
        + "    * /mostranavi       Mostra le navi ancora in gioco e il loro numero\n"
        + "    * /gioca            Ti fa iniziare una partita\n"
        + "    * /svelagriglia     Mostra la griglia generata dal computer\n";
    System.out.println(help);
  }

  /**
   * <h3> printDescription </h3>
   * <p>
   * Mostra una descrizione concisa del programma.
   * </p>
   */
  public static void printDescription() {
    String description =
        "Benvenuti nel gioco della battaglia navale!\n"
        + "Prima di iniziare vi andiamo a presentare una breve introduzione al gioco con\n"
        + "i suoi relativi comandi.\n\n"
        + "> INTRODUZIONE\n"
        + "    In questa realizzazione della battaglia navale, giocherete voi contro il vostro\n"
        + "    computer che posizionera' le navi in automatico prima dell'inizio della partita.\n\n"
        + "    Come giocatore, dovete individuare le posizioni delle navi e affondarle\n"
        + "    tutte, dalla prima all'ultima.\n\n"
        + "    Vincerete la partita solamente se affonderete tutte le navi prima di raggiungere\n"
        + "    il numero massimo di tentativi falliti, che cambia in base alla difficolta' scelta.\n";
    System.out.println(description);
  }

   /**
   * <h3> exit </h3>
   * <p>
   * Metodo usato per effettuare la conferma dell'uscita dal programma e in caso affermativo eseguirla.
   * </p>
   */
  public static void exit() {
    Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
    String command;
    System.out.print("Cliccare 's' per confermare l'uscita: ");
    command = in.nextLine().toLowerCase();
    if (command.equals("s")) {
      System.exit(0);

  }
  }

}
