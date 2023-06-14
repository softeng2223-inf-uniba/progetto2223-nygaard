package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.utility.UColor;
import it.uniba.nygaard.game.utility.UDifficulty;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.ShowLevelBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> ShowLevelCommand </h2>
 * <p>
 * La classe ShowLevelCommand rappresenta il comando per mostrare il livello di difficoltà.
 * </p>
 *
 * @see Command
 */
final class ShowLevelCommand extends Command {

  /**
   * <h3> instance </h3>
   * <p>
   * Istanza di ShowLevelCommand.
   * </p>
   */
  private static ShowLevelCommand instance = new ShowLevelCommand();

  /**
   * <h3> getInstance </h3>
   * <p>
   * Restituisce l'istanza di ShowLevelCommand.
   * </p>
   */
  static ShowLevelCommand getInstance() {
    return instance;
  }

  /**
   * <h3> Costruttore </h3>
   * <p>
   * Costruttore della classe ShowLevelCommand.
   * Setta il numero minimo e massimo di parametri che rendono valido il comando.
   * </p>
   */
  private ShowLevelCommand() {
    setMinParamNumber(1);
    setMaxParamNumber(1);
  }

  /**
   * <h3> executeCommand </h3>
   * <p>
   * Esegue il comando per mostrare il livello di difficoltà con relativo numero di tentativi.
   * Se viene passato un numero sbagliato di parametri, viene stampato il come usare il comando.
   * </p>
   *
   * @param command comando da eseguire
   */
  public void executeCommand(final String[] command) {
    if (checkNoParams(command)) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    Match p = GameManager.getMatch();
    String actualColor;
    String s = "Livello di difficoltà scelto: " + UColor.BOLD;
    switch (p.getDifficultyNames(p.getDifficulty())) {
      case UDifficulty.EASY_NAME -> {
        actualColor = UColor.GREEN;
      }
      case UDifficulty.MEDIUM_NAME -> {
        actualColor = UColor.YELLOW;
      }
      case UDifficulty.HARD_NAME -> {
        actualColor = UColor.RED;
      }
      default -> {
        actualColor = UColor.RESET;
      }
    }
    s += (actualColor);
    s += p.getDifficultyNames(p.getDifficulty()) + UColor.RESET + "\n"
        + "Numero massimo di tentativi falliti: " + UColor.BOLD;
    s += actualColor + p.getAttempts(p.getDifficulty()) + UColor.RESET;

    ShowLevelBoundary.printDifficulty(s);
  }
}
