package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
/**
 * << Control >>
 * <h2> SetMediumDifficulty </h2>
 * <p>
 *     La classe SetMediumDifficulty rappresenta il comando di impostazione della difficoltà media.
 * </p>
 * @see CommandInterface
 */
final class SetMediumDifficulty implements CommandInterface {
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
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *   Esegue il comando.
   * </p>
   */
  public void executeCommand(final String[] command) {
    GameManager.setNextDifficulty(Util.DIFFICULTY_MEDIUM);
    SetDifficultyControl.setDifficulty();
  }
}
