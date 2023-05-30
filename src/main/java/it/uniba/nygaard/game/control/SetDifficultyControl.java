package it.uniba.nygaard.game.control;

import it.uniba.nygaard.game.Util;
import it.uniba.nygaard.game.boundary.SetDifficultyBoundary;
import it.uniba.nygaard.game.entity.Match;

/**
 * << Control >>
 * <h2> SetDifficultyControl </h2>
 * <p>
 *     La classe SetDifficultyControl rappresenta il controllo per impostare la difficoltà.
 * </p>
 * @see CommandInterface
 */
final class SetDifficultyControl {
  /**
   * <h3> Costruttore </h3>
   * <p>
   *     Costruttore della classe SetDifficultyControl.
   * </p>
   */
  private SetDifficultyControl() {
  }
  /**
   * <h3> setDifficulty </h3>
   * <p>
   *     Imposta la difficoltà.
   * </p>
   */
  static void setDifficulty() {
    int difficulty = GameManager.getNextDifficulty();
    Match p = GameManager.getMatch();
    if (p.getInGame()) {
      SetDifficultyBoundary.alreadyInGame();
      return;
    }
    if (p.getDifficulty() == difficulty) {
      SetDifficultyBoundary.sameDifficulty();
      return;
    }
    if (p.getDifficulty() != Util.DIFFICULTY_NOT_SETTED) {
      String choice;
      do {
        choice = SetDifficultyBoundary.ask(p, difficulty);
      }
      while (!choice.equals("y") && !choice.equals("n"));
      if (choice.equals("n")) {
        SetDifficultyBoundary.operationCancelled();
        return;
      }
    }
    p.setDifficulty(difficulty);
    SetDifficultyBoundary.operationDone();
  }
}
