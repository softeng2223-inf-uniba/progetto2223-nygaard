package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.InputBoundary;

/**
 * << Control >>
 * <h2> SetHardDifficulty </h2>
 * <p>
 *     La classe SetHardDifficulty rappresenta il comando di impostazione della difficoltà difficile.
 * </p>
 * @see Command
 */
final class SetHardDifficulty extends Command {
  /**
   * <h3> instance </h3>
   * <p>
   *   Istanza di SetHardDifficulty.
   *  </p>
   */
  private static SetHardDifficulty instance = new SetHardDifficulty();
  /**
   * <h3> getInstance </h3>
   * <p>
   *   Restituisce l'istanza di SetHardDifficulty.
   * </p>
   */
  static SetHardDifficulty getInstance() {
    return instance;
  }
  /**
   * <h3> Costruttore </h3>
   * <p>
   *   Costruttore della classe SetHardDifficulty.
   * </p>
   */
  private SetHardDifficulty() {
    setParamNumber(2);
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *   Esegue il comando.
   * </p>
   */
  public void executeCommand(final String[] command) {
    if (command.length > getParamNumber()) {
      InputBoundary.howToUse(command[0]);
      return;
    }
    GameManager.setNextDifficulty(Util.DIFFICULTY_HARD);
        /*
      TO DO -> GESTIRE IL CASO CON PARAMETREI
    }*/
    SetDifficultyControl.setDifficulty();
  }
}
