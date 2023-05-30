package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;

/**
 * << Control >>
 * <h2> SetEasyDifficulty </h2>
 * <p>
 *     La classe SetEasyDifficulty rappresenta il comando di impostazione della difficoltà facile.
 * </p>
 * @see CommandInterface
 */
final class SetEasyDifficulty implements CommandInterface {
  /**
   * <h3> instance </h3>
   * <p>
   *     Istanza di SetEasyDifficulty.
   * </p>
   */
  private static SetEasyDifficulty instance = new SetEasyDifficulty();
  /**
   * <h3> getInstance </h3>
   * <p>
   *    Restituisce l'istanza di SetEasyDifficulty.
   * </p>
   */
  static SetEasyDifficulty getInstance() {
    return instance;
  }
  /**
   * <h3> Costruttore </h3>
   * <p>
   *     Costruttore della classe SetEasyDifficulty.
   * </p>
   */
  private SetEasyDifficulty() {
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *     Esegue il comando.
   * </p>
   */
  public void executeCommand(final String[] command) {
    GameManager.setNextDifficulty(Util.DIFFICULTY_EASY);
    SetDifficultyControl.setDifficulty();
  }
}
