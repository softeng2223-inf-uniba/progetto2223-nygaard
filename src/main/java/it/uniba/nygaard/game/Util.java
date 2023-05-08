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
  /**
   * Costante che contiene il percorso del file che contiene
   * le informazioni mostrate quando si digita il comando "/help".
   */
  private static final
    String HELP_PATH = "src/main/java/it/uniba/nygaard/help/help.txt";

  private static final
    String DESCRIPTION_PATH =
      "src/main/java/it/uniba/nygaard/description/description.txt";


  private Util() { }

  /**
   * <p>
   * Mostra una descrizione del programma insieme a tutti
   * i comandi disponibili che si possono eseguire.
   * </p>
   */
  public static void printHelp() {
    Path filePath = Paths.get(Util.HELP_PATH);

    try {
      String result = Files.readString(filePath);
      System.out.println(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * <p>
   *   Mostra una descrizione coincisa del programma.
   * </p>
   */
  public static void printDescription() {
    Path filePath = Paths.get(Util.DESCRIPTION_PATH);

    try {
      String result = Files.readString(filePath);
      System.out.println(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Metodo usato per la lettura di tutto il contenuto
   * di un file posizionato in un certo percorso.
   * @param path Percorso del file
   */
  private void fileReader(final String path) {

  }

}
