package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.InputBoundary;
import it.uniba.nygaard.game.boundary.ShowLevelBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> ShowLevelCommand </h2>
 * <p>
 *     La classe ShowLevelCommand rappresenta il comando per mostrare il livello di difficoltà.
 * </p>
 * @see Command
 */
final class ShowLevelCommand extends Command {
  /**
   * <h3> instance </h3>
   * <p>
   *     Istanza di ShowLevelCommand.
   * </p>
   */
  private static ShowLevelCommand instance = new ShowLevelCommand();
  /**
   * <h3> getInstance </h3>
   * <p>
   *    Restituisce l'istanza di ShowLevelCommand.
   * </p>
   */
  static ShowLevelCommand getInstance() {
    return instance;
  }
  /**
   * <h3> Costruttore </h3>
   * <p>
   *     Costruttore della classe ShowLevelCommand.
   * </p>
   */
  private ShowLevelCommand() {
    setParamNumber(1);
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *     Esegue il comando.
   * </p>
   */
  public void executeCommand(final String[] command) {
    if (command.length > getParamNumber()) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    Match p = GameManager.getMatch();
    String actualColor = Util.RESET;
    String s = "";
    if (p.getDifficulty() != Util.DIFFICULTY_NOT_SETTED) {
      s = "Livello di difficoltà scelto: " + Util.BOLD;
      switch (p.getDifficultyNames()[p.getDifficulty()]) {
        case Util.EASY_NAME -> {
          actualColor = Util.GREEN;
        }
        case Util.MEDIUM_NAME -> {
          actualColor = Util.YELLOW;
        }
        case Util.HARD_NAME -> {
          actualColor = Util.RED;
        }
        default -> {
          actualColor = Util.RESET;
        }
      }
      s += (actualColor);
      s += p.getDifficultyNames()[p.getDifficulty()] + Util.RESET + "\n"
              + "Numero massimo di tentativi falliti: " + Util.BOLD;
      s += actualColor + p.getAttempts()[p.getDifficulty()] + Util.RESET;
    } else {
      s += Util.RED + "Difficoltà non ancora scelta\nPer scegliere la difficoltà utilizzare "
              + "il comando /facile, /medio o /difficile" + Util.RESET;
    }
    ShowLevelBoundary.printActualDifficulty(s);
  }
}
