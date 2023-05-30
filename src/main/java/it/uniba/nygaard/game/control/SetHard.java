package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;

/**
 * << Control >>
 * <h2> SetHard </h2>
 * <p>
 *     La classe SetHard rappresenta il comando di impostazione della difficoltà difficile.
 * </p>
 * @see Command
 */
final class SetHard extends Command {
  /**
   * <h3> instance </h3>
   * <p>
   *   Istanza di SetHard.
   *  </p>
   */
  private static SetHard instance = new SetHard();
  /**
   * <h3> getInstance </h3>
   * <p>
   *   Restituisce l'istanza di SetHard.
   * </p>
   */
  static SetHard getInstance() {
    return instance;
  }
  /**
   * <h3> Costruttore </h3>
   * <p>
   *   Costruttore della classe SetHard.
   * </p>
   */
  private SetHard() {
    setParamNumber(2);
  }
  /**
   * <h3> executeCommand </h3>
   * <p>
   *   Esegue il comando per impostare la difficoltà difficile.
   * </p>
   * @param command Comando da eseguire.
   */
  public void executeCommand(final String[] command) {
    if (invalidNumber(command)) {
      return;
    }
    GameManager.setNextDifficulty(Util.DIFFICULTY_HARD);
        /*
      TO DO -> GESTIRE IL CASO CON PARAMETRI
    }*/
    SetDifficultyControl.setDifficulty();
  }
}
