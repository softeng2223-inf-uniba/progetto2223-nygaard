package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.InputBoundary;

/**
 * << Control >>
 * <h2> SetMedium </h2>
 * <p>
 *     La classe SetMedium rappresenta il comando di impostazione della difficoltà media.
 * </p>
 * @see Command
 */
final class SetMedium extends Command {
  /**
   * <h3> instance </h3>
   * <p>
   *   Istanza di SetMedium.
   *  </p>
   */
  private static SetMedium instance = new SetMedium();
  /**
   * <h3> getInstance </h3>
   * <p>
   *   Restituisce l'istanza di SetMedium.
   * </p>
   */
  static SetMedium getInstance() {
    return instance;
  }
  /**
   * <h3> Costruttore </h3>
   * <p>
   *   Costruttore della classe SetMedium.
   * </p>
   */
  private SetMedium() {
    setParamNumber(2);
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *   Esegue il comando impostando la difficoltà media.
   * </p>
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (invalidNumber(command)) {
      return;
    }
    GameManager.setNextDifficulty(Util.DIFFICULTY_MEDIUM);
        /*
      TO DO -> GESTIRE IL CASO CON PARAMETREI
    }*/
    SetDifficultyControl.setDifficulty();
  }
}
