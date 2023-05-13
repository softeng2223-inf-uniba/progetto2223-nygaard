package it.uniba.app;

import it.uniba.nygaard.game.Match;
import it.uniba.nygaard.game.Util;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * <h2> App </h2>
 * <p>
 * La classe App si occupa della gestione dei comandi da tastiera,
 * vede se ci sono flags in ingresso all'avvio dell'applicazione
 * e in tal caso esegue le funzioni associate.
 * </p>
 */
public final class App {

  App() {
  }

  /**
   * Get a greeting sentence.
   *
   * @return the "Hello World!" string.
   */
  String getGreeting() {
    return "Hello World!!!";
  }

  /**
   * <h3> Main </h3>
   * <p>
   * Punto d'ingresso dell'applicazione.
   * </p>
   *
   * @param args Parametri d'ingresso da linea di comando
   */
  public static void main(final String[] args) {
    Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
    String command;

    Match p = new Match();

    if (args.length > 0) {
      String argument = args[0].toLowerCase();
      if (argument.equals("--help") || argument.equals("-h")) {
        Util.printHelp();
      } else {
        System.out.println("Parametro " + argument + " non riconosciuto.Premere invio per uscire");
        in.nextLine();
        System.exit(0);
      }
    } else {
      Util.printDescription();
    }

    while (true) {
      System.out.print("Inserire un comando: ");
      command = in.nextLine().toLowerCase();

      switch (command) {
        case "/help" -> Util.printHelp();
        case "/esci" ->Util.exit();
        case "/facile" -> p.setDifficulty(Util.DIFFICULTY_EASY);
        case "/medio" -> p.setDifficulty(Util.DIFFICULTY_MEDIUM);
        case "/difficile" -> p.setDifficulty(Util.DIFFICULTY_HARD);
        case "/mostralivello" -> p.showLevel();
        case "/mostranavi" -> p.showShips();
        case "/gioca" -> p.play();
        // case "/svelagriglia" -> Svela la griglia con tanto di navi
        default -> System.out.println("Comando non riconosciuto");
      }
    }
  }
}
