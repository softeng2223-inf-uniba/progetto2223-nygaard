package it.uniba.app;

import it.uniba.nygaard.game.Match;
import it.uniba.nygaard.game.Util;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
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
  public String getGreeting() {
    return "Hello World!!!";
  }

  /**
   * Punto di ingresso dell'applicazione.
   *
   * @param args Parametri di ingresso da linea di comando
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
        System.out.println("Parametro " + argument + " non riconosciuto");
        //esci
      }
    } else {
      Util.printDescription();
    }

    while (true) {
      System.out.print("Inserire un comando: ");
      command = in.nextLine().toLowerCase();

      switch (command) {
        case "/help" -> Util.printHelp();
        case "/facile" -> p.setDifficulty(Util.DIFFICULTY_EASY);
        case "/medio" -> p.setDifficulty(Util.DIFFICULTY_MEDIUM);
        case "/difficile" -> p.setDifficulty(Util.DIFFICULTY_HARD);
        case "/mostralivello" -> p.showLevel();
        // case "/mostranavi" -> Mostrare le navi e
        // il numero di occorrenze di esse
        // case "/gioca" -> Incomincia la partita
        // case "/svelagriglia" -> Svela la griglia con tanto di navi
        default -> System.out.println("Comando non riconosciuto");
      }
    }
  }
}
