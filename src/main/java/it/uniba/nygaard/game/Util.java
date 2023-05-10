package it.uniba.nygaard.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>
 * La classe Util contiene tutte le costanti globali
 * e funzioni di servizio.
 * </p>
 */
public final class Util {
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
  /**
   * <p>
   * Costante che contiene il percorso del file che contiene
   * le informazioni mostrate quando si digita il comando "/help".
   * </p>
   */
  private static final
    String HELP_PATH = "src/main/java/it/uniba/nygaard/help/help.txt";

  /**
   * <p>
   * Costante che contiene il percorso del file che contiene
   * una breve descrizione del programma.
   * </p>
   */
  private static final
    String DESCRIPTION_PATH = "src/main/java/it/uniba/nygaard/"
      + "description/description.txt";

  private Util() {
  }

  /**
   * <p>
   * Mostra una descrizione del programma insieme a tutti
   * i comandi disponibili che si possono eseguire.
   * </p>
   */
  public static void printHelp() {
    Util.printFile(Util.DESCRIPTION_PATH);
    Util.printFile(Util.HELP_PATH);
  }

  /**
   * <p>
   * Mostra una descrizione coincisa del programma.
   * </p>
   */
  public static void printDescription() {
    Util.printFile(Util.DESCRIPTION_PATH);
  }

  /**
   * <p>
   * Metodo usato per la lettura di tutto il contenuto
   * di un file posizionato in un certo percorso.
   * </p>
   * <p>
   * Una volta letto tutto il contenuto del file, lo
   * mostra a video.
   * </p>
   * @param path Percorso del file
   */
  private static void printFile(final String path) {
    Path filePath = Paths.get(path);

    try {
      String content = Files.readString(filePath);
      System.out.println(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String concatCharacters(char c, int n) {
    String str = "";
    for (int i = 0; i < n; i++) {
      str += c;
    }
    return str;
  }

}
