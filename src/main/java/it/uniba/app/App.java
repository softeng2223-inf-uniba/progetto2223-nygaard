package it.uniba.app;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Main class of the application.
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
   * Entrypoint of the application.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    Scanner in = new Scanner(System.in, StandardCharsets.UTF_16);
    String command;
    // Creazione del match
    /*
    if (args.length > 0 && (args[0].equals("--help") || args[0].equals("-h"))) {
        Stampa help
    }
    */
    while (true) {
      System.out.print("Inserire un comando: ");
      command = in.nextLine().toLowerCase();
      /* case "/help" -> Stampa help
                case "/esci" -> Esegui comando di uscita
                case "/facile" -> Setta la difficolta a facile
                case "/medio" -> Setta la difficolta a medio
                case "/difficile" -> Setta la difficolta a difficile
                case "/mostralivello" -> Mostrare il livello
                case "/mostranavi" -> Mostrare le navi e
                il numero di occorrenze di esse
                case "/gioca" -> Incomincia la partita
                case "/svelagriglia" -> Svela la griglia con tanto di navi
                 */
      System.out.println("Comando non riconosciuto");
    }
  }
}
