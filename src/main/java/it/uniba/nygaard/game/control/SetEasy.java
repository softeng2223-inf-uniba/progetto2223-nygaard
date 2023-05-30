package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;

/**
 * << Control >>
 * <h2> SetEasy </h2>
 * <p>
 *     La classe SetEasy rappresenta il comando di impostazione della difficoltà facile.
 * </p>
 * @see Command
 */
final class SetEasy extends Command {
  /**
   * <h3> instance </h3>
   * <p>
   *   Istanza di SetEasy.
   *  </p>
   */
  private static SetEasy instance = new SetEasy();
  /**
   * <h3> getInstance </h3>
   * <p>
   *   Restituisce l'istanza di SetEasy.
   * </p>
   */
  static SetEasy getInstance() {
    return instance;
  }
  /**
   * <h3> Costruttore </h3>
   * <p>
   *   Costruttore della classe SetEasy.
   * </p>
   */
  private SetEasy() {
    setParamNumber(2);
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *   Esegue il comando per impostare la difficoltà facile.
   * </p>
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (invalidNumber(command)) {
      return;
    }

    if (command.length == 1) {
      GameManager.setNextDifficulty(Util.DIFFICULTY_EASY);
      SetDifficultyControl.setDifficulty();
    } else {
      GameManager.setNextAttempts(Integer.parseInt(command[1]));
      SetDifficultyControl.setAttempts();
    }

  }
}
