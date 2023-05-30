package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.InputBoundary;

/**
 * << Control >>
 * <h2> SetMediumDifficulty </h2>
 * <p>
 *     La classe SetMediumDifficulty rappresenta il comando di impostazione della difficoltà media.
 * </p>
 * @see Command
 */
final class SetMediumDifficulty extends Command {
  /**
   * <h3> instance </h3>
   * <p>
   *   Istanza di SetMediumDifficulty.
   *  </p>
   */
  private static SetMediumDifficulty instance = new SetMediumDifficulty();
  /**
   * <h3> getInstance </h3>
   * <p>
   *   Restituisce l'istanza di SetMediumDifficulty.
   * </p>
   */
  static SetMediumDifficulty getInstance() {
    return instance;
  }
  /**
   * <h3> Costruttore </h3>
   * <p>
   *   Costruttore della classe SetMediumDifficulty.
   * </p>
   */
  private SetMediumDifficulty() {
    setParamNumber(2);
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *   Esegue il comando impostando la difficoltà media.
   * </p>
   */
  public void executeCommand(final String[] command) {
    if (command.length > getParamNumber()) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    GameManager.setNextDifficulty(Util.DIFFICULTY_MEDIUM);
        /*
      TO DO -> GESTIRE IL CASO CON PARAMETREI
    }*/
    SetDifficultyControl.setDifficulty();
  }
}
